package executor.service.service.execution;

import executor.service.service.executor.ParallelFlowExecutorService;
import executor.service.service.executor.ScenarioExecutor;
import executor.service.service.executor.ScenarioExecutorService;

public class ExecutionServiceFacade {
//    ScenarioSourceListener listener = new QueueScenarioSourceListener();
//    private final WebDriverService webDriverService =
//            new WebDriverServiceManager();
    private final StepExecutionService stepExecutionService =
            new StepActionExecutionService();
//    private final ExecutionScenarioService scenarioService =
//            new ExecutionScenarioService(webDriverService,
//                    stepExecutionService);

    ScenarioExecutor executorService = new ScenarioExecutorService();

    ParallelFlowExecutorService flowExecutorService =
            new ParallelFlowExecutorService();

//    public ExecutionServiceFacade() {
//        listener.execute();
//        Queue<Scenario> scenarios =
//                ScenarioSourceHolder.getInstance().getScenarioQueue();
//
//
//
//        flowExecutorService.executeScenario();
//        scenarioService.executeScenario();
//    }

}
