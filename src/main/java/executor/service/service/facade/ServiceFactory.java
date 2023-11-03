package executor.service.service.facade;

import executor.service.service.execution.ExecutionService;
import executor.service.service.execution.QueueExecutionService;
import executor.service.service.execution.step.StepExecutionService;
import executor.service.service.facade.impl.ScenarioServiceImpl;
import executor.service.service.execution.step.StepExecutionServiceImpl;
import executor.service.service.webdriver.WebDriverService;
import executor.service.service.webdriver.WebDriverServiceImpl;
import executor.service.service.webdriver.WebDriverInitializerFactory;

public class ServiceFactory {
    private ServiceFactory() {
    }

    public static ServiceFacade createServiceFacade() {
        WebDriverInitializerFactory factory = new WebDriverInitializerFactory();
        ExecutionService executionService = new QueueExecutionService();
        WebDriverService webDriverService = new WebDriverServiceImpl(factory);
        StepExecutionService stepExecutionService =
                new StepExecutionServiceImpl();
        ScenarioService scenarioService = new ScenarioServiceImpl(
                webDriverService, stepExecutionService);
        return new ServiceFacade(scenarioService);
    }
}
