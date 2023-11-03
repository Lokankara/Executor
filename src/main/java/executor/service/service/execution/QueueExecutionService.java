package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

import java.util.Queue;

public class QueueExecutionService
        implements ExecutionService {

    @Override
    public void execute(
            WebDriver webDriver,
            ScenarioSourceListener listener,
            ScenarioExecutor scenarioExecutor) {
        listener.execute();
        Queue<Scenario> scenarios = listener.getScenarioQueue();
        while (!scenarios.isEmpty()) {
            Scenario scenario = scenarios.poll();
            scenarioExecutor.execute(scenario, webDriver);
        }
    }
}
