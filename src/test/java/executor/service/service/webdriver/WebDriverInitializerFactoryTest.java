package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import static executor.service.model.Constants.PROXY_CONFIG_FILENAME;
import static executor.service.model.Constants.WEBDRIVER_FILENAME;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WebDriverInitializerFactoryTest {
    private WebDriverInitializerFactory webDriverInitializerFactory;
    private WebDriverConfig webDriverConfig;
    private ProxyConfigHolder proxyConfigHolder;
    private WebDriver webDriver;
    private ConfigurationLoader configurationLoader;

    @BeforeEach
    public void setUp() {
        webDriverConfig = Mockito.mock(WebDriverConfig.class);
        proxyConfigHolder = Mockito.mock(ProxyConfigHolder.class);
        configurationLoader = Mockito.mock(ConfigurationLoader.class);
        webDriver = Mockito.mock(WebDriver.class);
        webDriverInitializerFactory = new WebDriverInitializerFactory(webDriverConfig, proxyConfigHolder);
    }

//    @Test
//    void testCreate() {
//        when(configurationLoader.loadWebDriverConfig(WEBDRIVER_FILENAME)).thenReturn(webDriverConfig);
//        when(configurationLoader.loadProxyConfig(PROXY_CONFIG_FILENAME)).thenReturn(proxyConfigHolder);
//        when(webDriverInitializerFactory.create()).thenReturn(webDriverInitializerFactory);
//        WebDriverInitializer initializer = webDriverInitializerFactory.create();
//        assertNotNull(initializer, "WebDriverInitializer should not be null after creation");
//    }
//
//    @Test
//    void testInit() {
//        Browser browser = Mockito.mock(Browser.class);
//        when(browser.init(webDriverConfig, proxyConfigHolder)).thenReturn(webDriver);
//        WebDriver driver = webDriverInitializerFactory.init(browser);
//        assertNotNull(driver, "WebDriver should not be null after initialization");
//    }
}
