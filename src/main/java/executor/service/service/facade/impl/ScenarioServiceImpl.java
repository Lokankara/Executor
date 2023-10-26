package executor.service.service.facade.impl;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.facade.ScenarioService;
import executor.service.service.execution.step.StepExecutionService;
import executor.service.service.facade.WebDriverService;
import executor.service.service.webdriver.Browser;
import executor.service.service.webdriver.WebDriverInitializerFactory;
import org.openqa.selenium.WebDriver;

public class ScenarioServiceImpl
        implements ScenarioService {
    private final WebDriverService webDriverService;
    private final StepExecutionService stepExecutionService;

    public ScenarioServiceImpl(
            WebDriverService webDriverService,
            StepExecutionService stepExecutionService) {
        this.webDriverService = webDriverService;
        this.stepExecutionService = stepExecutionService;
    }

    @Override
    public void executeScenario(
            final Scenario scenario) {

        WebDriver webDriver = WebDriverInitializerFactory
                .getInstance()
                .init(Browser.FIREFOX);

        for (Step step : scenario.getSteps()) {
            stepExecutionService.executeStep(webDriver, step);
        }

        webDriverService.quitWebDriver(webDriver);
    }
}