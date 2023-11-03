package executor.service.service.execution.step;

import executor.service.exception.StepExecutionInterruptedException;
import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public record SleepStepExecution(String getStepAction)
        implements StepExecution {

    @Override
    public void step(
            final WebDriver webDriver, final Step step) {
        long sleepTimeMillis = Long.parseLong(step.getValue());
        try {
            Thread.sleep(sleepTimeMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String errorMessage = "Step execution interrupted while sleeping";
            throw new StepExecutionInterruptedException(errorMessage, e);
        }
    }
}
