package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public class ScenarioExecutor
        implements Executor {
    @Override
    public void execute(
            final Scenario scenario,
            final WebDriver webDriver) {
        for (Step step : scenario.getSteps()) {
            getStepExecution(step.getAction())
                    .step(webDriver, step);
        }
    }

    private StepExecution getStepExecution(
            final String action) {
        return StepExecutionType.fromString(action)
                .getStepExecution();
    }
}
