package executor.service.service.execution.step;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public interface StepExecution {
    String getStepAction();

    void step(WebDriver webDriver, Step step);
}
