package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.execution.step.StepExecution;
import executor.service.service.execution.step.StepExecutionType;
import org.openqa.selenium.WebDriver;

public class ScenarioExecutorService
        implements ScenarioExecutor {

    @Override
    public void execute(
            final Scenario scenario,
            final WebDriver webDriver) {
        for (Step step : scenario.getSteps()) {
            StepExecution stepExecution =
                    StepExecutionType.valueOf(step.getAction())
                    .getStepExecution();
            stepExecution.step(webDriver, step);
        }
    }
}
