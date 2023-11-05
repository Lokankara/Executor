package executor.service.service.step;

import executor.service.exception.StepExecutionInterruptedException;
import executor.service.model.Step;
import executor.service.service.step.SleepStepExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SleepStepExecutionTestService {

    String stepAction = "sleep";
    @Mock
    private WebDriver mockWebDriver;

    @Mock
    private Step step;

    @InjectMocks
    private SleepStepExecution sleepStepExecution;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        sleepStepExecution = new SleepStepExecution(stepAction);
        when(step.getValue()).thenReturn("1:2");
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance, when an InterruptedException occurs, it should throw a StepExecutionInterruptedException")
    void testStepInterruptedException() {
        Thread.currentThread().interrupt();
        assertThrows(StepExecutionInterruptedException.class, () -> {
            sleepStepExecution.step(mockWebDriver, step);
        });
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance when step method is called then no exception is thrown")
     void testStepMethodNoException() {
        Step step = new Step("sleep", "2:5");
        assertDoesNotThrow(() -> sleepStepExecution.step(mockWebDriver, step));
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance when getStepAction method is called then correct step action is returned")
    void testGetStepAction() {
        String result = sleepStepExecution.getStepAction();
        assertEquals(stepAction, result);
    }
}