package executor.service.service.executor;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndQueue {
    private static final int QUEUE_CAPACITY = 10;
    private static final Queue<String> SCENARIO_QUEUE =
            new LinkedBlockingQueue<>(QUEUE_CAPACITY);
    private static final Queue<String> PROXY_QUEUE =
            new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    private static final CountDownLatch COL = new CountDownLatch(8);

    public void threadAndQueue()
            throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable qaSendScenarios = () -> {
            System.out.println(Thread.currentThread().getName() + " QA submit");
            for (int i = 0; i < 10; i++) {
                String scenario = "Scenario " + i;
                SCENARIO_QUEUE.add(scenario);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            COL.countDown();
        };

        Runnable proxyParsing = () -> {
            System.out.println(Thread.currentThread()
                                     .getName() + " Started proxy submit");
            for (int i = 0; i < 10; i++) {
                String proxy = "Proxy " + i;
                PROXY_QUEUE.add(proxy);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            COL.countDown();
        };

        executorService.execute(qaSendScenarios);
        executorService.execute(proxyParsing);

        TimeUnit.SECONDS.sleep(1);

        int workers = 6;
        for (int i = 1; i <= workers; i++) {
            ExecutorService workerExecutor =
                    Executors.newSingleThreadExecutor();
            Runnable worker = () -> {
                for (int j = 0; j < 10; j++) {
                    String proxy = PROXY_QUEUE.poll();
                    if (proxy == null) {
                        continue;
                    }
                    String scenario = SCENARIO_QUEUE.poll();

                    System.out.printf("Worker: %s %s %s%n",
                                      Thread.currentThread().getName(),
                                      proxy,
                                      scenario);

                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                COL.countDown();
            };
            workerExecutor.execute(worker);
            workerExecutor.shutdown();
            workerExecutor.awaitTermination(10, TimeUnit.SECONDS);
        }

        COL.await();

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
