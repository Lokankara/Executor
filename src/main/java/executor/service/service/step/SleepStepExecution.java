package executor.service.service.step;

import executor.service.exception.StepExecutionInterruptedException;
import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;
import static java.lang.Math.round;

public record SleepStepExecution(String getStepAction)
        implements StepExecution {

    @Override
    public void step(
            final WebDriver webDriver, final Step step) {
        try {
            String[] timeParts = step.getValue().split(":");
            long first = Long.parseLong(timeParts[0]);
            long second = Long.parseLong(timeParts[1]);
            long sleep = round(first + (random() * ((second - first) + 1)));
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            String errorMessage = "Step execution interrupted while sleeping";
            throw new StepExecutionInterruptedException(errorMessage, e);
        }
    }
}
