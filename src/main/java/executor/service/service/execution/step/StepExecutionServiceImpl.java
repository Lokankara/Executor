package executor.service.service.execution.step;

import executor.service.model.Step;
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
