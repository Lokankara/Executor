package executor.service.service.execution;

import executor.service.model.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickXpathStepExecution
        implements StepExecution {

    private final String stepAction;

    public ClickXpathStepExecution(
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
        By xpath = By.xpath(step.getValue());
        webDriver.findElement(xpath).click();
    }
}
