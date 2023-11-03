package executor.service.service.execution.step;

import executor.service.model.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record ClickXpathStepExecution(String getStepAction)
        implements StepExecution {

    @Override
    public void step(
            final WebDriver webDriver, final Step step) {
        By xpath = By.xpath(step.getValue());
        webDriver.findElement(xpath).click();
    }
}
