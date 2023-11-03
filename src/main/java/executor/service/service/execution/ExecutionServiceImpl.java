package executor.service.service.execution;

import executor.service.model.Scenario;
import executor.service.service.plugin.ScenarioSourceListener;
import org.openqa.selenium.WebDriver;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutionServiceImpl
        implements ExecutionService {

    private Queue<Scenario> scenarioQueue = new LinkedBlockingQueue<>();

    @Override
    public void execute(
            final WebDriver webDriver,
            final ScenarioSourceListener scenarioSourceListener,
            final ScenarioExecutor scenarioExecutor) {

        scenarioSourceListener.execute();
        scenarioQueue = scenarioSourceListener.getScenarioQueue();
        while (!scenarioQueue.isEmpty()) {
            scenarioExecutor.execute(
                    scenarioQueue.poll(), webDriver);
        }
    }

    public Queue<Scenario> getScenarioQueue() {
        return scenarioQueue;
    }
}
