package executor.service.service.execution.step;

import executor.service.model.Step;
import org.openqa.selenium.WebDriver;

public interface StepExecutionService {
    void executeStep(WebDriver webDriver, Step step);
}
