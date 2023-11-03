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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClickXpathStepExecutionTest {

    @Mock
    private WebDriver mockWebDriver;

    @Mock
    private WebElement mockElement;

    @InjectMocks
    private ClickXpathStepExecution clickStep;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        clickStep = new ClickXpathStepExecution("clickXpath");
    }

    @Test
    @DisplayName("Given a ClickXpathStepExecution instance, when step method is called, then the correct element is clicked")
    void testClickingElementByXpath() {
        String xpathValue = "/html/body/p";
        Step step = new Step("clickXpath", xpathValue);
        when(mockWebDriver.findElement(By.xpath(xpathValue))).thenReturn(mockElement);
        clickStep.step(mockWebDriver, step);
        verify(mockElement).click();

    }

        @Test
    @DisplayName("Given a ClickXpathStepExecution instance, when getStepAction method is called, then the correct step action is returned")
    void testGetStepAction() {
        String result = clickStep.getStepAction();
        assertEquals("clickXpath", result);
    }
}
