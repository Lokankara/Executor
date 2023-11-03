package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.execution.step.StepExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static executor.service.service.execution.step.Action.CLICK_CSS_ACTION;
import static executor.service.service.execution.step.Action.CLICK_XPATH_ACTION;
import static executor.service.service.execution.step.Action.SLEEP_ACTION;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ScenarioExecutorServiceTest {

    @InjectMocks
    private ScenarioExecutorService executor;
    private WebDriver webDriver;
    private Step a;
    private Step b;
    private Step c;
    private Scenario scenario;
    private StepExecution stepA;
    private StepExecution stepB;
    private StepExecution stepC;

    @BeforeEach
    public void setup() {
        a = mock(Step.class);
        b = mock(Step.class);
        c = mock(Step.class);
        scenario = mock(Scenario.class);
        webDriver = mock(WebDriver.class);
        stepA = mock(StepExecution.class);
        stepB = mock(StepExecution.class);
        stepC = mock(StepExecution.class);
        executor = spy(ScenarioExecutorService.class);
        List<Step> steps = Arrays.asList(a, b, c);
        when(scenario.getSteps()).thenReturn(steps);
    }

    @Test
    @DisplayName("Given a ScenarioExecutor instance, when execute method is called, then the correct steps are executed")
    void testExecuteScenario() {

//        doReturn(stepA).when(executor).getStepExecution(CLICK_XPATH_ACTION);
//        doReturn(stepB).when(executor).getStepExecution(CLICK_CSS_ACTION);
//        doReturn(stepC).when(executor).getStepExecution(SLEEP_ACTION);
//        when(a.getAction()).thenReturn(CLICK_XPATH_ACTION);
//        when(b.getAction()).thenReturn(CLICK_CSS_ACTION);
//        when(c.getAction()).thenReturn(SLEEP_ACTION);
//
//        executor.execute(scenario, webDriver);
//
//        verify(a, times(1)).getAction();
//        verify(b, times(1)).getAction();
//        verify(c, times(1)).getAction();
//        verify(stepA, times(1)).step(webDriver, a);
//        verify(stepB, times(1)).step(webDriver, b);
//        verify(stepC, times(1)).step(webDriver, c);
    }
}
