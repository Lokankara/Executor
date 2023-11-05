package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class WebDriverServiceManager
        implements WebDriverService {

    private final WebDriverInitializerFactory factory;

    private static WebDriver driver;

    public WebDriverServiceManager(
            final WebDriverInitializerFactory factory) {
        this.factory = factory;
    }

    @Override
    public WebDriver getWebDriver(
            final WebDriverConfig config) {
        return WebDriverInitializerFactory.getInstance(config)
                .init(Browser.FIREFOX);
        // return factory.getInstance(config).init(Browser.FIREFOX);
    }

    @Override
    public void quitWebDriver(
            final WebDriver webDriver) {
        webDriver.quit();
    }



    public static WebDriver getDriver(
            final Browser browser,
            final WebDriverConfig config,
            final ProxyConfigHolder configHolder) {
        if (driver == null) {
            driver = browser.init(config, configHolder);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
