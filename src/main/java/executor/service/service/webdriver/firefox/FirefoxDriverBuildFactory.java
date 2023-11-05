package executor.service.service.webdriver.firefox;

import executor.service.service.webdriver.WebDriverBuildFactory;
import executor.service.service.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverBuildFactory
        extends WebDriverBuildFactory {

    public FirefoxDriverBuildFactory(
            WebDriverFactory factory) {
        super(factory);
    }
}