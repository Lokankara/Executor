package executor.service.service.step;

import executor.service.model.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static executor.service.service.step.Action.SLEEP_ACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class StepExecutionSleepTest {
    private StepExecution execution;

    @BeforeEach
    public void setUp() {
        execution = new SleepStepExecution(SLEEP_ACTION);
    }

    @AfterEach
    public void tearDown() {
        execution = null;
    }

    @Test
    void testGetStepAction() {
        String action = execution.getStepAction();
        assertEquals("sleep", action);
    }

    @Test
    void testStepWithInvalidSleepValue() {
        WebDriver webDriver = mock(WebDriver.class);
        Step stepRequest = new Step("sleep", "invalid_value");
        assertThrows(NumberFormatException.class,
                () -> execution.step(webDriver, stepRequest));
    }
}
