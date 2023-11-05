package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static executor.service.model.Constants.PROXY_CONFIG_FILENAME;
import static executor.service.model.Constants.WEBDRIVER_FILENAME;

public class WebDriverInitializerFactory
        implements WebDriverInitializer {
    private ProxyConfigHolder holder;
    private ConfigurationLoader loader;
    private WebDriverConfig webDriverConfig;
    private static final Map<WebDriverConfig, WebDriverInitializerFactory> INSTANCES = new ConcurrentHashMap<>();

    private static class Holder {
        private static final WebDriverInitializerFactory INSTANCE =
                new WebDriverInitializerFactory();
    }

    public WebDriverInitializerFactory() {
        this.webDriverConfig = new WebDriverConfig();
        this.holder = new ProxyConfigHolder();
        this.loader = new ConfigurationLoader();
    }

    public WebDriverInitializerFactory(
            final WebDriverConfig webDriverConfig,
            final ProxyConfigHolder holder) {
        this.webDriverConfig = webDriverConfig;
        this.holder = holder;
        this.loader = new ConfigurationLoader();
    }

    private WebDriverInitializerFactory(
            final WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public static WebDriverInitializerFactory getInstance(
            final WebDriverConfig config) {
        return INSTANCES.computeIfAbsent(config,
                WebDriverInitializerFactory::new);
    }

    public static WebDriverInitializerFactory getInstance() {
        return Holder.INSTANCE;
    }

    public WebDriver init(Browser browser) {
        return getWebDriver(browser, webDriverConfig, holder);
    }

    @Override
    public WebDriverInitializer create() {
        webDriverConfig = loader.loadWebDriverConfig(WEBDRIVER_FILENAME);
        holder = loader.loadProxyConfig(PROXY_CONFIG_FILENAME);
        return new WebDriverInitializerFactory(webDriverConfig, holder);
    }

    public static WebDriver getWebDriver(
            Browser browser,
            WebDriverConfig config,
            final ProxyConfigHolder holder) {
        return browser.init(config, holder);
    }
}
