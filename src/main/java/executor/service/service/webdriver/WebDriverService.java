package executor.service.service.webdriver;

import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public interface WebDriverService {
    WebDriver getWebDriver(WebDriverConfig config);

    void quitWebDriver(WebDriver webDriver);
}
