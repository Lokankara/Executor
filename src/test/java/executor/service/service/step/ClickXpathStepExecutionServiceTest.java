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

import static executor.service.service.step.Action.CLICK_XPATH_ACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClickXpathStepExecutionServiceTest {

    @Mock
    private WebDriver mockWebDriver;

    @Mock
    private WebElement mockElement;

    @InjectMocks
    private ClickXpathStepExecution clickStep;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        clickStep = new ClickXpathStepExecution(CLICK_XPATH_ACTION);
    }

    @AfterEach
    public void cleanUp() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Given a ClickXpathStepExecution instance, when step method is called, then the correct element is clicked")
    void testClickingElementByXpath() {
        String xpathValue = "/html/body/p";
        Step step = new Step(CLICK_XPATH_ACTION, xpathValue);
        when(mockWebDriver.findElement(By.xpath(xpathValue))).thenReturn(mockElement);
        clickStep.step(mockWebDriver, step);
        verify(mockElement).click();

    }

        @Test
    @DisplayName("Given a ClickXpathStepExecution instance, when getStepAction method is called, then the correct step action is returned")
    void testGetStepAction() {
        String result = clickStep.getStepAction();
        assertEquals(CLICK_XPATH_ACTION, result);
    }
}
