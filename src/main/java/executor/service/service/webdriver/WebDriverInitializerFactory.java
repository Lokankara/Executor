package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class WebDriverInitializerFactory implements WebDriverInitializer {

    private WebDriverConfig config;
    private ProxyConfigHolder holder;
    private final ConfigurationLoader loader;
    private static WebDriverInitializerFactory instance;

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

    public static WebDriverInitializerFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverInitializerFactory();
        }
        return instance;
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
            final Browser browser,
            final WebDriverConfig config,
            final ProxyConfigHolder configHolder) {
        return browser.init(config, configHolder);
    }
}
