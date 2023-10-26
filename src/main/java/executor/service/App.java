package executor.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static executor.service.service.facade.ServiceFactory.createServiceFacade;
import static executor.service.service.webdriver.WebDriverManager.create;

public class App {
    private static final String PROXY_FILE = "proxy.properties";
    private static final String WEBDRIVER_FILE = "web-driver.properties";
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        create(WEBDRIVER_FILE, PROXY_FILE);
        createServiceFacade();
        LOGGER.info("Application started.");
    }
}
