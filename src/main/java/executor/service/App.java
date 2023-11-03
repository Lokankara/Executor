package executor.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static executor.service.service.facade.ServiceFactory.createServiceFacade;


public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        createServiceFacade();
        LOGGER.info("Application started.");
    }
}
