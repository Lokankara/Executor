package executor.service.service.execution;

import executor.service.exception.StepExecutionInterruptedException;
import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public class SleepStepExecution
        implements StepExecution {

    private final String stepAction;


    public SleepStepExecution(
            final String stepAction) {
        this.stepAction = stepAction;
    }

    @Override
    public String getStepAction() {
        return this.stepAction;
    }

    @Override
    public void step(
            final WebDriver webDriver,
            final Step step) {
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
