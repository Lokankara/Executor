package executor.service.service.webdriver.chrome;

import executor.service.service.webdriver.BuildBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverBuildFactory implements BuildBrowser {

    public WebDriver createWebDriver() {
//        System.setProperty("webdriver.chrome.driver", webDriverConfig.getDriverPath());
        return new ChromeDriver();
    }
}
