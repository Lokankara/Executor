package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

class WebDriverInitializerTest {
    private WebDriverInitializer webDriverInitializer;
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
        webDriverInitializer = new WebDriverInitializer(webDriverConfig, proxyConfigHolder);
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
