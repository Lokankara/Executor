package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static executor.service.model.Constants.PROXY_CONFIG_FILENAME;
import static executor.service.model.Constants.WEBDRIVER_FILENAME;

public class WebDriverInitializer
        implements WebDriverFactory {
    private ProxyConfigHolder proxyConfigHolder;
    private ConfigurationLoader loader;
    private WebDriverConfig webDriverConfig;
    private static final Map<WebDriverConfig, WebDriverInitializer> INSTANCES =
            new ConcurrentHashMap<>();

    private static class Holder {
        private static final WebDriverInitializer INSTANCE =
                new WebDriverInitializer();
    }

    public WebDriverInitializer() {
        this.webDriverConfig = new WebDriverConfig();
        this.proxyConfigHolder = new ProxyConfigHolder();
        this.loader = new ConfigurationLoader();
    }

    public WebDriverInitializer(
            final WebDriverConfig webDriverConfig,
            final ProxyConfigHolder proxyConfigHolder) {
        this.webDriverConfig = webDriverConfig;
        this.proxyConfigHolder = proxyConfigHolder;
        this.loader = new ConfigurationLoader();
    }

    public WebDriverInitializer(
            final WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public static WebDriverInitializer getInstance(
            final WebDriverConfig config) {
        return INSTANCES.computeIfAbsent(config, WebDriverInitializer::new);
    }

    public static WebDriverInitializer getInstance() {
        return Holder.INSTANCE;
    }

    public WebDriver init(Browser browser) {
        return getWebDriver(browser, webDriverConfig, proxyConfigHolder);
    }

    @Override
    public WebDriver createDriver() {
        webDriverConfig = loader.loadWebDriverConfig(WEBDRIVER_FILENAME);
        proxyConfigHolder = loader.loadProxyConfig(PROXY_CONFIG_FILENAME);
        return new WebDriverInitializer(webDriverConfig,
                                        proxyConfigHolder).createDriver();
    }

    public static WebDriver getWebDriver(
            Browser browser,
            WebDriverConfig config,
            final ProxyConfigHolder holder) {
        return browser.init(config, holder);
    }
}
//
//    @Override
//    public WebDriver create(ProxyConfigHolder proxyConfigHolder) {
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions chromeOptions = getChromeOptions();
//        configureProxy(chromeOptions, proxyConfigHolder);
//
//        ChromeDriver driver = new ChromeDriver(chromeOptions);
//        configureProxyAuth(driver, proxyConfigHolder);
//
//        driver.manage().timeouts().pageLoadTimeout(ofSeconds(webDriverConfig.getPageLoadTimeout()));
//        driver.manage().timeouts().implicitlyWait(ofSeconds(webDriverConfig.getImplicitlyWait()));
//
//        return driver;
//    }
//
//    private ChromeOptions getChromeOptions() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--user-agent=" + webDriverConfig.getUserAgent());
//        chromeOptions.setAcceptInsecureCerts(true);
//
//        return chromeOptions;
//    }
//
//    private void configureProxy(ChromeOptions chromeOptions, ProxyConfigHolder proxyConfigHolder) {
//        ProxyNetworkConfig networkConfig = proxyConfigHolder.getProxyNetworkConfig();
//        ProxyCredentials proxyCredentials = proxyConfigHolder.getProxyCredentials();
//
//        if (networkConfig != null) {
//            String hostname = networkConfig.getHostname();
//            Integer port = networkConfig.getPort();
//            chromeOptions.addArguments(String.format("--proxy-server=%s:%d", hostname, port));
//        }
//        if (networkConfig != null && proxyCredentials != null) {
//            chromeOptions.addExtensions(new File(EXTENSION_PATH));
//        }
//    }
//
//    private void configureProxyAuth(WebDriver driver, ProxyConfigHolder proxyConfigHolder) {
//        ProxyNetworkConfig networkConfig = proxyConfigHolder.getProxyNetworkConfig();
//        ProxyCredentials proxyCredentials = proxyConfigHolder.getProxyCredentials();
//
//        if (networkConfig != null && proxyCredentials != null) {
//            configureAuth(driver, proxyCredentials.getUsername(), proxyCredentials.getPassword());
//        }
//    }
//
//    private void configureAuth(WebDriver driver, String username, String password) {
//        driver.get(EXTENSION_URL);
//        driver.findElement(By.id("url")).sendKeys(".*");
//        driver.findElement(By.id("username")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.className("credential-form-submit")).click();
//    }
//}
