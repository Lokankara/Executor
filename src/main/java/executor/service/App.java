package executor.service;

import executor.service.controller.ControllerWorker;
import executor.service.service.execution.ExecutionService;
import executor.service.service.execution.ScenarioExecutionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        ControllerWorker controller = new ControllerWorker();
        LOGGER.info("Controller Worker started.");
        controller.start();
    }
}
