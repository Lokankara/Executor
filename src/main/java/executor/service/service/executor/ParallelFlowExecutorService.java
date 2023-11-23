package executor.service.service.executor;

import executor.service.model.Scenario;
import executor.service.model.ThreadPoolConfig;
import executor.service.service.plugin.FileSourcesReader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ParallelFlowExecutorService {
    private final ThreadPoolExecutor threadPoolExecutor;

    public ParallelFlowExecutorService() {
        ThreadPoolConfig config = new FileSourcesReader()
                .readFile("thread-pool.properties",
                          ThreadPoolConfig.class);
        int corePoolSize = config.getCorePoolSize();
        long keepAliveTime = config.getKeepAliveTime();

        threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize, corePoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }

    public void executeScenario(
            final ScenarioExecutor executor,
            final Scenario scenario,
            final WebDriver webDriver) {
        threadPoolExecutor.execute(() -> executor.execute(scenario, webDriver));
    }
}
