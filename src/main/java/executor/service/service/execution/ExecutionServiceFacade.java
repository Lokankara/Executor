package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.service.executor.ScenarioExecutor;
import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

import java.util.Queue;

public class ExecutionServiceFacade
        implements ExecutionService {

    @Override
    public void execute(
            final WebDriver webDriver,
            final ScenarioSourceListener listener,
            final ScenarioExecutor scenarioExecutor) {
        Queue<Scenario> scenarios = listener.getScenarioQueue();
        while (!scenarios.isEmpty()) {
            scenarioExecutor.execute(scenarios.poll(), webDriver);
        }
    }
}
