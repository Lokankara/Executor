package executor.service.service.execution;

import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

public interface ExecutionService {
    void execute(
            WebDriver webDriver,
            ScenarioSourceListener scenarioSourceListener,
            ScenarioExecutor scenarioExecutor);
}