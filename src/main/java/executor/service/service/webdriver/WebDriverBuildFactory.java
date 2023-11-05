package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverBuildFactory {
    private final WebDriver safari;
    private final WebDriver chrome;
    private final WebDriver firefox;


    public WebDriverBuildFactory(WebDriverFactory factory) {
        this.safari = factory.initSafariWebDriver();
        this.chrome = factory.initChromeWebDriver();
        this.firefox = factory.initFirefoxWebDriver();
    }

    public WebDriver getChrome() {
        return chrome;
    }
}