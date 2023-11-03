package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.model.ThreadPoolConfig;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static executor.service.service.plugin.FileSourcesReader.readFile;

public class ParallelFlowExecutorService {
    private final ThreadPoolExecutor threadPoolExecutor;

    public ParallelFlowExecutorService() {
        ThreadPoolConfig config =
                readFile("thread-pool.properties",
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
            final Executor executorInstance,
            final Scenario scenario,
            final WebDriver webDriver) {
        threadPoolExecutor.execute(() -> executorInstance
                .execute(scenario, webDriver));
    }
}
