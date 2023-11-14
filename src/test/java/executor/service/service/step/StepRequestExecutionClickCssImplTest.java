package executor.service.service.step;

import executor.service.model.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static executor.service.service.step.Action.CLICK_CSS_ACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StepRequestExecutionClickCssImplTest {

    private ClickCssStepExecution clickCss;

    @BeforeEach
    public void setUp() {
        clickCss = new ClickCssStepExecution(CLICK_CSS_ACTION);
    }

    @AfterEach
    public void tearDown() {
        clickCss = null;
    }

    @Test
    void testGetStepAction() {
        String action = clickCss.getStepAction();
        assertEquals("clickCss", action);
    }

    @Test
    void testStepClickElementWhenFound() {
        WebDriver webDriver = mock(WebDriver.class);
        WebElement webElement = mock(WebElement.class);
        Step step = new Step("clickCss", "css_expression");
        By selector = By.cssSelector(step.getValue());
        when(webDriver.findElement(selector)).thenReturn(webElement);
        clickCss.step(webDriver, step);
        verify(webElement, times(1)).click();
    }
}
