package executor.service.controller;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.Scenario;
import executor.service.model.WebDriverConfig;
import executor.service.service.executor.ScenarioExecutorService;

import java.util.Queue;

public class Worker
        implements Runnable {

    private final Queue<Scenario> scenarioQueue;
    private final Queue<ProxyConfigHolder> proxyQueue;
    private final ScenarioExecutorService service =
            new ScenarioExecutorService();


    public Worker(
            Queue<Scenario> scenarioQueue,
            Queue<ProxyConfigHolder> proxyQueue) {
        this.scenarioQueue = scenarioQueue;
        this.proxyQueue = proxyQueue;
    }

    @Override
    public void run() {
        while (!scenarioQueue.isEmpty() || !proxyQueue.isEmpty()) {
            try {
                Scenario scenario = scenarioQueue.poll();
                ProxyConfigHolder proxyConfig = proxyQueue.poll();
                if (scenario != null && proxyConfig != null) {
                    WebDriverConfig config = new WebDriverConfig();
                    //                    WebDriverInitializer.getInstance(config);
                    //                    WebDriver driver = initializeDriver(proxyConfig);
                    //                    service.execute(scenario, driver);
                } else {
                    System.out.println("Waiting for both scenario and proxy...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
