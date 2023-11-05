package executor.service.service.webdriver.safari;

import executor.service.service.webdriver.BuildBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverBuildFactory implements BuildBrowser {

    public WebDriver createWebDriver() {
        return new SafariDriver();
    }
}