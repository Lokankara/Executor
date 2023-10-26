package executor.service.service.facade.impl;

import executor.service.model.WebDriverConfig;
import executor.service.service.facade.WebDriverService;
import executor.service.service.webdriver.Browser;
import executor.service.service.webdriver.WebDriverInitializerFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverServiceImpl
        implements WebDriverService {

    @Override
    public WebDriver getWebDriver(
            final WebDriverConfig config) {
        return WebDriverInitializerFactory
                .getInstance(config)
                .init(Browser.FIREFOX);
    }

    @Override
    public void quitWebDriver(
            final WebDriver webDriver) {
        webDriver.quit();
    }
}
