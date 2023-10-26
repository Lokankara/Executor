package executor.service.service.execution.step;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public class UnsupportedStepExecution
        implements StepExecution {
    @Override
    public String getStepAction() {
        return "unsupported";
    }

    @Override
    public void step(
            final WebDriver webDriver,
            final Step step) {
        throw new UnsupportedOperationException(String.format(
                "The action %s is not supported.",
                step.getAction()));
    }
}
