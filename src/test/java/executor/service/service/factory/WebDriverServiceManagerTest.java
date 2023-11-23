package executor.service.service.factory;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.WebDriverConfig;
import executor.service.service.webdriver.WebDriverServiceManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WebDriverServiceManagerTest {

    @Mock
    private WebDriverConfig config;
    @Mock
    private ProxyConfigHolder configHolder;
    @Mock
    private WebDriver driver;

    private WebDriverServiceManager manager;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        manager = new WebDriverServiceManager(driver);
    }

    @AfterEach
    public void cleanUp()
            throws Exception {
        closeable.close();
    }

    @Test
    void testQuitWebDriver() {
        doNothing().when(driver).quit();
        manager.quitWebDriver(driver);
        verify(driver, times(1)).quit();
    }
}
