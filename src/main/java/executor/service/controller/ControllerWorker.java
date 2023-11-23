package executor.service.controller;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.Scenario;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ControllerWorker {
    private static final int WORKER_POOL_SIZE = 5;

    public void start() {
        Queue<Scenario> scenarioQueue = new LinkedBlockingQueue<>();
        Queue<ProxyConfigHolder> proxyQueue = new LinkedBlockingQueue<>();

        ExecutorService workerExecutor =
                new ThreadPoolExecutor(WORKER_POOL_SIZE,
                                       WORKER_POOL_SIZE,
                                       1L,
                                       MILLISECONDS,
                                       new LinkedBlockingQueue<>());
        IntStream.range(0, WORKER_POOL_SIZE)
                 .mapToObj(i -> new Worker(scenarioQueue, proxyQueue))
                 .forEach(workerExecutor::submit);
        workerExecutor.shutdown();
    }
}
