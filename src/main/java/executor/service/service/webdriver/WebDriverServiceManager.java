package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class WebDriverServiceManager
        implements WebDriverService {

    private final WebDriver driver;

    public WebDriverServiceManager(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getWebDriver(
            final WebDriverConfig config) {
        return WebDriverInitializer
                .getInstance(config)
                .init(Browser.FIREFOX);
    }

    @Override
    public void quitWebDriver(
            final WebDriver webDriver) {
        webDriver.quit();
    }

//    public WebDriver getDriver(
//            final Browser browser,
//            final WebDriverConfig config,
//            final ProxyConfigHolder configHolder) {
//        if (driver == null) {
//            driver = browser.init(config, configHolder);
//        }
//        return driver;
//    }
//
//    public void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
}
