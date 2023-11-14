package executor.service.service.step;

import executor.service.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static executor.service.service.step.Action.CLICK_XPATH_ACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StepRequestExecutionClickXpathTest {

    private StepExecution clickXpath;

    @BeforeEach
    public void setUp() {
        clickXpath = new ClickXpathStepExecution(CLICK_XPATH_ACTION);
    }

    @Test
    void testGetStepAction() {
        String stepAction = clickXpath.getStepAction();
        assertEquals("clickXpath", stepAction);
    }

    @Test
    void testStepClicksElementWhenFound() {
        WebDriver webDriver = mock(WebDriver.class);
        Step step = new Step("clickXpath", "xpath_expression");
        WebElement mockElement = mock(WebElement.class);
        By xpath = By.xpath(step.getValue());
        when(webDriver.findElement(xpath)).thenReturn(mockElement);
        clickXpath.step(webDriver, step);
        verify(mockElement, times(1)).click();
    }
}
