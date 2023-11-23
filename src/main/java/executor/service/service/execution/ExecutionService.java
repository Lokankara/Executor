package executor.service.service.execution;

import executor.service.service.executor.ScenarioExecutor;
import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

public interface ExecutionService<T> {
    void execute(
            WebDriver webDriver,
            ScenarioSourceListener<T> scenarioSourceListener,
            ScenarioExecutor scenarioExecutor);
}
