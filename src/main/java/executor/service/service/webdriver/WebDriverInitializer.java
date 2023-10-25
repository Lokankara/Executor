package executor.service.service.webdriver;

public interface WebDriverInitializer {

    WebDriverInitializer create(
            String webdriverConfigPath,
            String proxyConfigHolderPath);
}
