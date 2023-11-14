package executor.service.service.factory;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import executor.service.service.webdriver.Browser;
import executor.service.service.webdriver.WebDriverInitializer;
import executor.service.service.webdriver.WebDriverService;
import executor.service.service.webdriver.WebDriverServiceManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class WebDriverServiceTest {
    @Mock
    private WebDriver webDriver;
    @Mock
    private WebDriverConfig config;
    @Mock
    private WebDriverService service;
    @Mock
    private WebDriverInitializer factory;
    @Mock
    private ProxyConfigHolder holder;
    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        when(service.getWebDriver(config)).thenReturn(webDriver);
        when(factory.init(Browser.FIREFOX)).thenReturn(webDriver);
    }

    @AfterEach
    public void cleanUp()
            throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Given a WebDriverServiceManager instance, when getWebDriver is called, then the correct WebDriver is returned")
    void testGetWebDriverServices() {
        WebDriver driver = service.getWebDriver(config);
        assertEquals(webDriver, driver);
        assertNotNull(driver);
        verify(service, times(1)).getWebDriver(config);
    }

    @Test
    @DisplayName("Given a WebDriverServiceImpl instance, when getWebDriver is called, then the correct WebDriver is returned")
    void testGetWebDriverService() {
        when(service.getWebDriver(config)).thenReturn(webDriver);
        when(factory.init(Browser.FIREFOX)).thenReturn(webDriver);
        WebDriver result = service.getWebDriver(config);
        assertEquals(webDriver, result);
        verify(service, times(1)).getWebDriver(config);
    }

    @Test
    @DisplayName("Given a WebDriverServiceImpl instance and a WebDriver, when quitWebDriver is called, then the quit method of the WebDriver is called")
    void testQuitWebDriver() {
        service = new WebDriverServiceManager();
        service.quitWebDriver(webDriver);
        verify(webDriver, times(1)).quit();
    }

    @Test
    void testQuitDriver() {
        when(service.getWebDriver(config)).thenReturn(webDriver);
        when(factory.init(Browser.FIREFOX)).thenReturn(webDriver);
        WebDriver result = service.getWebDriver(config);
        result.quit();
        verify(webDriver, times(1)).quit();
    }
}
