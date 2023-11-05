package executor.service;

import executor.service.service.execution.ExecutionService;
import executor.service.service.execution.ExecutionServiceFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ExecutionService facade = new ExecutionServiceFacade();
        LOGGER.info("Application started.");
    }
}
