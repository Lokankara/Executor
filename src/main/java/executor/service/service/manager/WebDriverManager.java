package executor.service.service.manager;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.Optional;

public abstract class WebDriverManager {

    public static synchronized WebDriverManager chromeDriver() {
        return new ChromeDriverManager();
    }

    public static synchronized WebDriverManager firefoxDriver() {
        return new FirefoxDriverManager();
    }

    public static synchronized WebDriverManager edgeDriver() {
        return new EdgeDriverManager();
    }

    public static synchronized WebDriverManager safariDriver() {
        return new SafariDriverManager();
    }

    public static synchronized WebDriverManager voidDriver() {
        return new VoidDriverManager();
    }

    public static synchronized WebDriverManager getInstance(
            DriverManagerType driverManagerType) {
        return getDriver(driverManagerType);
    }

    protected static synchronized WebDriverManager getDriver(
            DriverManagerType driverManagerType) {
        return switch (driverManagerType) {
            case CHROME -> chromeDriver();
            case FIREFOX -> firefoxDriver();
            case EDGE -> edgeDriver();
            case SAFARI -> safariDriver();
            default -> voidDriver();
        };
    }

    public abstract WebDriver buildWebDriver();

    public abstract DriverManagerType getDriverManagerType();

    protected abstract String getDriverName();

    protected abstract Optional<URL> buildUrl(String driverVersion);
}
