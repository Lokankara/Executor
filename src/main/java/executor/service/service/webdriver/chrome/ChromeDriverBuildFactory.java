package executor.service.service.webdriver.chrome;

import executor.service.service.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBuildFactory implements WebDriverFactory {

    @Override
    public WebDriver createDriver() {
        //        System.setProperty("webdriver.chrome.driver", webDriverConfig.getDriverPath());
        return new ChromeDriver();
    }
}
