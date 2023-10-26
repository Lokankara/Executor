package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;

import static executor.service.service.webdriver.WebDriverInitializerFactory.getInstance;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static WebDriver driver;

    private WebDriverManager() {
    }

    public static WebDriverInitializer create(
            final String webdriverConfigPath,
            final String proxyConfigHolderPath) {
        return getInstance().create(
                webdriverConfigPath, proxyConfigHolderPath);
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
