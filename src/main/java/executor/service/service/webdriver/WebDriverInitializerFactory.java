package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ConcurrentHashMap;

public class WebDriverInitializerFactory
        implements WebDriverInitializer {

    private static final String PROXY_FILE = "proxy.properties";
    private static final String WEBDRIVER_FILE = "web-driver.properties";

    private WebDriverConfig config;
    private ProxyConfigHolder holder;
    private ConfigurationLoader loader;
    private static final ConcurrentHashMap<WebDriverConfig, WebDriverInitializerFactory>
            INSTANCES = new ConcurrentHashMap<>();

    private static class Holder {
        private static final WebDriverInitializerFactory INSTANCE =
                new WebDriverInitializerFactory();
    }

    public WebDriverInitializerFactory() {
        this.config = new WebDriverConfig();
        this.holder = new ProxyConfigHolder();
        this.loader = new ConfigurationLoader();
    }

    public WebDriverInitializerFactory(
            final WebDriverConfig config,
            final ProxyConfigHolder holder) {
        this.config = config;
        this.holder = holder;
        this.loader = new ConfigurationLoader();
    }

    private WebDriverInitializerFactory(
            final WebDriverConfig config) {
        this.config = config;
    }

    public static WebDriverInitializerFactory getInstance(
            final WebDriverConfig config) {
        return INSTANCES.computeIfAbsent(
                config, WebDriverInitializerFactory::new);
    }

    public static WebDriverInitializerFactory getInstance() {
        return Holder.INSTANCE;
    }

    public WebDriver init(Browser browser) {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        return switch (browser) {
            case CHROME -> webDriverFactory.initChromeDriver();
            case FIREFOX -> webDriverFactory.initFirefoxDriver();
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        };
    }

    @Override
    public WebDriverInitializer create() {
        config = loader.loadWebDriverConfig(WEBDRIVER_FILE);
        holder = loader.loadProxyConfig(PROXY_FILE);
        return new WebDriverInitializerFactory(config, holder);
    }

    public static WebDriver getWebDriver(
            final Browser browser, final WebDriverConfig config,
            final ProxyConfigHolder configHolder) {
        return browser.init(config, configHolder);
    }
}
