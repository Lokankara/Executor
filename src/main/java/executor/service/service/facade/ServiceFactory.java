package executor.service.service.facade;

import executor.service.service.execution.ExecutionService;
import executor.service.service.execution.step.StepExecutionService;
import executor.service.service.facade.impl.ScenarioServiceImpl;
import executor.service.service.execution.step.StepExecutionServiceImpl;
import executor.service.service.facade.impl.WebDriverServiceImpl;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static ServiceFacade createServiceFacade() {
        ExecutionService executionService = new ExecutionService();
        WebDriverService webDriverService = new WebDriverServiceImpl();
        StepExecutionService stepExecutionService =
                new StepExecutionServiceImpl();
        ScenarioService scenarioService = new ScenarioServiceImpl(
                webDriverService, stepExecutionService);
        return new ServiceFacade(scenarioService);
    }
}
