package executor.service.service.execution;

import executor.service.model.Step;
import executor.service.service.step.StepExecutionType;
import org.openqa.selenium.WebDriver;

public class StepExecutionServiceImpl
        implements StepExecutionService {

    @Override
    public void executeStep(
            final WebDriver webDriver,
            final Step step) {
        StepExecutionType.fromString(step.getAction())
                .getStepExecution()
                .step(webDriver, step);
    }
}
