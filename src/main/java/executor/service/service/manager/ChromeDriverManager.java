package executor.service.service.manager;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager
        extends WebDriverManager {

    private WebDriverConfig webDriverConfig;
    private ProxyConfigHolder proxyConfigHolder;

    public ChromeDriverManager() {
        this.webDriverConfig = new WebDriverConfig();
        this.proxyConfigHolder = new ProxyConfigHolder();
    }

    @Override
    public WebDriver buildWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                webDriverConfig.getWebDriverExecutable());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=" + webDriverConfig.getUserAgent());

        if (proxyConfigHolder.getProxyNetworkConfig() != null) {
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(proxyConfigHolder
                    .getProxyNetworkConfig()
                    .getHostname() + ":" + proxyConfigHolder
                    .getProxyNetworkConfig()
                    .getPort());
            options.setProxy(proxy);
        }

        WebDriver driver = new ChromeDriver(options);
        driver
                .manage()
                .timeouts()
                .pageLoadTimeout(webDriverConfig.getPageLoadTimeout(),
                        TimeUnit.SECONDS);
        driver
                .manage()
                .timeouts()
                .implicitlyWait(webDriverConfig.getImplicitlyWait(),
                        TimeUnit.SECONDS);

        return driver;
    }

    @Override
    public DriverManagerType getDriverManagerType() {
        return DriverManagerType.CHROME;
    }

    @Override
    protected String getDriverName() {
        return "chromedriver";
    }

    @Override
    protected Optional<URL> buildUrl(String driverVersion) {
        try {
            return Optional.of(
                    new URL("https://chromedriver.storage.googleapis.com/index.html?path=LATEST_RELEASE"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public synchronized WebDriverConfig config() {
        return Optional
                .ofNullable(webDriverConfig)
                .orElse(new WebDriverConfig());
    }
}
