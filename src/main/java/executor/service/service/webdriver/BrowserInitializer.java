package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public interface BrowserInitializer {
    WebDriver init(
            WebDriverConfig config,
            ProxyConfigHolder configHolder);
}
