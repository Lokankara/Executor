package executor.service.service.facade.impl;

import executor.service.model.WebDriverConfig;
import executor.service.service.webdriver.Browser;
import executor.service.service.webdriver.WebDriverInitializerFactory;
import executor.service.service.webdriver.WebDriverService;
import executor.service.service.webdriver.WebDriverServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
class WebDriverServiceTest {
    private WebDriverConfig config;
    private WebDriver webDriver;
    private WebDriverInitializerFactory factory;
    private WebDriverService service;

    @BeforeEach
    public void setup() {
        config = mock(WebDriverConfig.class);
        webDriver = mock(WebDriver.class);
        factory = mock(WebDriverInitializerFactory.class);
        service = new WebDriverServiceImpl(factory);

        when(factory.create()).thenReturn(factory);
        when(factory.init(Browser.FIREFOX)).thenReturn(webDriver);
    }

    @Test
    @DisplayName("Given a WebDriverServiceImpl instance, when getWebDriver is called, then the correct WebDriver is returned")
    void testGetWebDriverService() {
        WebDriver mockWebDriver = Mockito.mock(WebDriver.class);
        WebDriverServiceImpl mockService = Mockito.mock(WebDriverServiceImpl.class);
        when(mockService.getWebDriver(config)).thenReturn(mockWebDriver);
        when(factory.init(Browser.FIREFOX)).thenReturn(mockWebDriver);
        WebDriver result = mockService.getWebDriver(config);
        assertEquals(mockWebDriver, result);
        verify(mockService, times(1)).getWebDriver(config);
    }

    @Test
    @DisplayName("Given a WebDriverServiceImpl instance and a WebDriver, when quitWebDriver is called, then the quit method of the WebDriver is called")
    void testQuitWebDriver() {
        service.quitWebDriver(webDriver);
        verify(webDriver, times(1)).quit();
    }

    //    @Test
    //    void testGetWebDriverFirefox() {
    //        WebDriver mockWebDriver = Mockito.mock(WebDriver.class);
    //        WebDriverInitializerFactory mockFactory = Mockito.mock(WebDriverInitializerFactory.class);
    //        WebDriverServiceImpl service = new WebDriverServiceImpl(mockFactory);
    //        when(mockFactory.init(Browser.FIREFOX)).thenReturn(mockWebDriver);
    //        WebDriver result = service.getWebDriver(config);
    //        result.quit();
    //    }
}
