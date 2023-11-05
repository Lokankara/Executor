package executor.service.service.step;

import executor.service.model.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record ClickCssStepExecution(String getStepAction)
        implements StepExecution {

    @Override
    public void step(final WebDriver webDriver, final Step step) {
        By selector = By.cssSelector(step.getValue());
        webDriver.findElement(selector).click();
    }
}
