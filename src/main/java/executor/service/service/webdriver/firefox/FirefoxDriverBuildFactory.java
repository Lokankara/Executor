package executor.service.service.webdriver.firefox;

import executor.service.service.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverBuildFactory
        implements WebDriverFactory {


    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}