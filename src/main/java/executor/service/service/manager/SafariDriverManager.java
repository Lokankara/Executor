package executor.service.service.manager;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.Optional;

public class SafariDriverManager extends  WebDriverManager{
    @Override
    public WebDriver buildWebDriver() {
        return null;
    }

    @Override
    public DriverManagerType getDriverManagerType() {
        return null;
    }

    @Override
    protected String getDriverName() {
        return null;
    }

    @Override
    protected Optional<URL> buildUrl(String driverVersion) {
        return Optional.empty();
    }
}
