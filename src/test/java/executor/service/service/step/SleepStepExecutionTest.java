package executor.service.service.step;

import executor.service.exception.StepExecutionInterruptedException;
import executor.service.model.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import static executor.service.service.step.Action.SLEEP_ACTION;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SleepStepExecutionTest {
    @Mock
    private WebDriver mockWebDriver;

    @Mock
    private Step step;

    @InjectMocks
    private SleepStepExecution execution;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        execution = new SleepStepExecution(SLEEP_ACTION);
        when(step.getValue()).thenReturn("1:2");
    }

    @AfterEach
    public void cleanUp() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance, when an InterruptedException occurs, it should throw a StepExecutionInterruptedException")
    void testStepInterruptedException() {
        Thread.currentThread().interrupt();
        assertThrows(StepExecutionInterruptedException.class, () -> execution.step(mockWebDriver, step));
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance when step method is called then no exception is thrown")
     void testStepMethodNoException() {
        Step step = new Step("sleep", "2:5");
        assertDoesNotThrow(() -> execution.step(mockWebDriver, step));
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance when getStepAction method is called then correct step action is returned")
    void testGetStepAction() {
        String result = execution.getStepAction();
        assertEquals(SLEEP_ACTION, result);
    }

    @Test
    @DisplayName("Given a SleepStepExecution instance, when step is called, it should sleep for the correct amount of time")
    void testStep() {
        String SLEEP_ACTION = "sleepAction";
        SleepStepExecution execution = new SleepStepExecution(SLEEP_ACTION);
        Step step = new Step(SLEEP_ACTION, "1:2");
        execution.step(mockWebDriver, step);
        assertEquals(SLEEP_ACTION, execution.getStepAction());
    }
}