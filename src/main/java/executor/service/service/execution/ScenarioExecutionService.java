package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.service.executor.ScenarioExecutor;
import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

import java.util.Queue;

import static executor.service.model.Constants.SCENARIO_FILENAME;

public class ScenarioExecutionService
        implements ExecutionService<Scenario> {

    @Override
    public void execute(
            final WebDriver webDriver,
            final ScenarioSourceListener<Scenario> listener,
            final ScenarioExecutor scenarioExecutor) {
        Queue<Scenario> scenarios =
                listener.execute(SCENARIO_FILENAME, Scenario.class);
        while (!scenarios.isEmpty()) {
            scenarioExecutor.execute(scenarios.poll(), webDriver);
        }
    }
}
