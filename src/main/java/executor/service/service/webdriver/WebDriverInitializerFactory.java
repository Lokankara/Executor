package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ConcurrentHashMap;

public class WebDriverInitializerFactory
        implements WebDriverInitializer {

    private WebDriverConfig config;
    private ProxyConfigHolder holder;
    private ConfigurationLoader loader;
    private static final ConcurrentHashMap<WebDriverConfig, WebDriverInitializerFactory> INSTANCES
            = new ConcurrentHashMap<>();

    private static class Holder {
        private static final WebDriverInitializerFactory INSTANCE =
                new WebDriverInitializerFactory();
    }

    private WebDriverInitializerFactory() {
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

    public WebDriver init(
            final Browser browser) {
        return browser.init(config, holder);
    }

    @Override
    public WebDriverInitializer create(
            final String webdriverConfigPath,
            final String proxyConfigHolderPath) {
        config = loader.loadWebDriverConfig(webdriverConfigPath);
        holder = loader.loadProxyConfig(proxyConfigHolderPath);
        return new WebDriverInitializerFactory(config, holder);
    }

    public static WebDriver getWebDriver(
            final Browser browser, final WebDriverConfig config,
            final ProxyConfigHolder configHolder) {
        return browser.init(config, configHolder);
    }
}
