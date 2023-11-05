package executor.service.service.plugin;

import executor.service.model.Scenario;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.model.Constants.SCENARIO_FILENAME;
import static executor.service.service.plugin.FileSourcesReader.readFile;
import static java.util.Arrays.asList;

public class QueueScenarioSourceListener
        implements ScenarioSourceListener {
    private final Queue<Scenario> scenarioQueue = new LinkedBlockingQueue<>();

    @Override
    public void execute() {
        scenarioQueue.addAll(asList(readFile(SCENARIO_FILENAME, Scenario[].class)));
    }

    public Queue<Scenario> getScenarioQueue() {
        return scenarioQueue;
    }
}
