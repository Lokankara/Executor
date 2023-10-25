package executor.service;

import static executor.service.service.webdriver.WebDriverManager.create;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final String PROXY_FILE = "proxy.properties";
    private static final String WEBDRIVER_FILE = "webdriver.properties";
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        create(WEBDRIVER_FILE, PROXY_FILE);
        LOGGER.info("Application started.");
    }
}
