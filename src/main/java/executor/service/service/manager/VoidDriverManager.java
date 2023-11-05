package executor.service.service.manager;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.Optional;

public class VoidDriverManager extends WebDriverManager{
    @Override
    public WebDriver buildWebDriver() {
        return null;
    }

    @Override
    public DriverManagerType getDriverManagerType() {
        return DriverManagerType.VOID;
    }

    @Override
    protected String getDriverName() {
        return "void";
    }

    @Override
    protected Optional<URL> buildUrl(String driverVersion) {
        return Optional.empty();
    }
}
