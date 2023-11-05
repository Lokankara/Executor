package executor.service.service.step;

import executor.service.model.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static executor.service.service.step.Action.CLICK_CSS_ACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClickCssStepExecutionServiceTest {
    @Mock
    private WebDriver mockWebDriver;
    @Mock
    private WebElement mockElement;
    @InjectMocks
    private ClickCssStepExecution clickStep;
    private Step step;
    private final String cssValue = ".submit-button";

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        step = new Step(CLICK_CSS_ACTION, cssValue);
        clickStep = new ClickCssStepExecution(CLICK_CSS_ACTION);
    }

    @AfterEach
    public void cleanUp() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Given a ClickCssStepExecution instance, when step method is called, then the correct element is clicked")
    void testClickingElementByCss() {
        when(mockWebDriver.findElement(By.cssSelector(cssValue))).thenReturn(mockElement);
        clickStep.step(mockWebDriver, step);
        verify(mockElement).click();
    }

    @Test
    @DisplayName("Given a ClickCssStepExecution instance, when getStepAction is called, it should return the correct action")
    void testGetStepAction() {
        StepExecution execution = new ClickCssStepExecution(CLICK_CSS_ACTION);
        String actualAction = execution.getStepAction();
        assertEquals(CLICK_CSS_ACTION, actualAction);
    }
}
