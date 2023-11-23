package executor.service.service.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MultiThreadPool {

    private static final int QUEUE_CAPACITY = 10;
    private static final BlockingQueue<String> SCENARIO_QUEUE =
            new LinkedBlockingQueue<>(QUEUE_CAPACITY);
    private static final BlockingQueue<String> PROXY_QUEUE =
            new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    private static final CountDownLatch COL = new CountDownLatch(8);

    public void threadAndQueue() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService workerExecutor = null;

        try {
            Runnable qaSendScenarios = getRunnable();
            Runnable proxyParsing = getProxyParsing();
            executorService.execute(qaSendScenarios);
            executorService.execute(proxyParsing);

            TimeUnit.SECONDS.sleep(1);

            int workers = 6;
            workerExecutor = Executors.newFixedThreadPool(workers);
            CompletionService<Void> completionService =
                    getVoidCompletionService(workerExecutor, workers);

            for (int i = 0; i < workers; i++) {
                completionService.take();
            }
        } finally {
            executorService.shutdown();
            if (workerExecutor != null) {
                workerExecutor.shutdown();
            }

            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (workerExecutor != null) {
                workerExecutor.awaitTermination(10, TimeUnit.SECONDS);
            }
        }
    }


    private static CompletionService<Void> getVoidCompletionService(
            ExecutorService workerExecutor,
            int workers) {
        CompletionService<Void> completionService =
                new ExecutorCompletionService<>(workerExecutor);

        for (int i = 0; i < workers; i++) {
            completionService.submit(() -> {
                try {
                    start();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    COL.countDown();
                }
                return null;
            });
        }
        return completionService;
    }

    private static void start()
            throws InterruptedException {
        while (true) {
            String proxy = PROXY_QUEUE.poll(1, TimeUnit.SECONDS);
            String scenario = SCENARIO_QUEUE.poll(1, TimeUnit.SECONDS);

            if (proxy == null || scenario == null) {
                break;
            }

            System.out.printf("Worker: %s %s %s%n",
                              Thread.currentThread().getName(),
                              proxy,
                              scenario);

            TimeUnit.SECONDS.sleep(4);
        }
    }

    private static Runnable getProxyParsing() {
        return () -> {
            try {
                System.out.printf("%s Started proxy submit%n",
                                  Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    String proxy = "Proxy " + i;
                    PROXY_QUEUE.put(proxy);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                COL.countDown();
            }
        };
    }

    private static Runnable getRunnable() {
        return () -> {
            try {
                System.out.printf("%s QA submit%n",
                                  Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    String scenario = "Scenario " + i;
                    SCENARIO_QUEUE.put(scenario);
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                COL.countDown();
            }
        };
    }
}

