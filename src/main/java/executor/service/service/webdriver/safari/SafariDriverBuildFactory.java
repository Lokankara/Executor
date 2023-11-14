package executor.service.service.webdriver.safari;

import executor.service.service.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverBuildFactory
        implements WebDriverFactory {
    public WebDriver createDriver() {
        return new SafariDriver();
    }
}