package executor.service.service.execution.step;

import executor.service.model.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClickCssStepExecutionTest {

    @Mock
    private WebDriver mockWebDriver;

    @Mock
    private WebElement mockElement;

    @InjectMocks
    private ClickCssStepExecution clickStep;

    String action = "clickCss";
    String cssValue = ".submit-button";
    Step step;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        step = new Step(action, cssValue);
        clickStep = new ClickCssStepExecution(action);
    }

    @Test
    @DisplayName("Given a ClickCssStepExecution instance, when step method is called, then the correct element is clicked")
    void testClickingElementByCss() {
        when(mockWebDriver.findElement(By.cssSelector(cssValue))).thenReturn(mockElement);
        clickStep.step(mockWebDriver, step);
        verify(mockElement).click();
    }
}