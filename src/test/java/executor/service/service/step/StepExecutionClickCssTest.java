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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class StepExecutionClickCssTest {

    private StepExecution stepExecutionClickCss;
    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        stepExecutionClickCss = new ClickCssStepExecution(CLICK_CSS_ACTION);

    }

    @AfterEach
    public void tearDown() {
        stepExecutionClickCss = null;
        webDriver = null;
    }

    @Test
    void testGetStepAction() {
        String action = stepExecutionClickCss.getStepAction();
        assertEquals("clickCss", action);
    }

    @Test
    void testStepExecutionClickCssWhenFound() {
        webDriver = mock(WebDriver.class);
        Step step = new Step("clickCss", ".test-css-selector");
        WebElement webElement = mock(WebElement.class);
        when(webDriver.findElement(By.cssSelector(step.getValue()))).thenReturn(webElement);
        stepExecutionClickCss.step(webDriver, step);
        verify(webElement).click();
    }
}