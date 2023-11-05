package executor.service.service.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {
    WebDriver initChromeWebDriver();
    WebDriver initSafariWebDriver();
    WebDriver initFirefoxWebDriver();

}