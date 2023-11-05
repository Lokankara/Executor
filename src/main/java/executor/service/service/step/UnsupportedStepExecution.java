package executor.service.service.step;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public record UnsupportedStepExecution(String getStepAction)
        implements StepExecution {

    @Override
    public void step(
            final WebDriver webDriver,
            final Step step) {
        throw new UnsupportedOperationException(String.format(
                "The action %s is not supported.",
                step.getAction()));
    }
}
