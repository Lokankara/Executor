package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.factory.ScenarioService;
import executor.service.service.webdriver.WebDriverService;
import executor.service.service.webdriver.Browser;
import executor.service.service.webdriver.WebDriverInitializerFactory;
import org.openqa.selenium.WebDriver;

public class ExecutionScenarioService
        implements ScenarioService {
    private final WebDriverService webDriverService;
    private final StepExecutionService stepExecutionService;

    public ExecutionScenarioService(
            final WebDriverService webDriverService,
            final StepExecutionService stepExecutionService) {
        this.webDriverService = webDriverService;
        this.stepExecutionService = stepExecutionService;
    }

    @Override
    public void executeScenario(
            final Scenario scenario) {

        WebDriver webDriver = WebDriverInitializerFactory
                .getInstance().init(Browser.FIREFOX);

        for (Step step : scenario.getSteps()) {
            stepExecutionService.executeStep(webDriver, step);
        }

        webDriverService.quitWebDriver(webDriver); //TODO
    }
}
