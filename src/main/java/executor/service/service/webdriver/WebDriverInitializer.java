package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import org.openqa.selenium.WebDriver;

public interface WebDriverInitializer {

    WebDriverInitializer create();
}
