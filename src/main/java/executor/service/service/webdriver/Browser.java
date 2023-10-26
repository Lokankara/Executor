package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum Browser
        implements Initializer {
    CHROME {
        @Override
        public WebDriver init(
                final WebDriverConfig config,
                final ProxyConfigHolder configHolder) {
            System.setProperty("webdriver.chrome.driver",
                    config.getWebDriverExecutable());
            ChromeOptions options = new ChromeOptions();
            options.addArguments(String.format("--user-agent=%s",
                    config.getUserAgent()));
            return new ChromeDriver(options);
        }
    },
    FIREFOX {
        @Override
        public WebDriver init(
                final WebDriverConfig config,
                final ProxyConfigHolder configHolder) {
            System.setProperty("webdriver.gecko.driver",
                    config.getWebDriverExecutable());
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("general.useragent.override",
                    config.getUserAgent());
            return new FirefoxDriver(options);
        }
    },
    EDGE {
        @Override
        public WebDriver init(
                final WebDriverConfig config,
                final ProxyConfigHolder configHolder) {
            System.setProperty("webdriver.edge.driver",
                    config.getWebDriverExecutable());
            EdgeOptions options = new EdgeOptions();
            options.setCapability("ms:inPrivate", true);
            return new EdgeDriver(options);
        }
    }
}
