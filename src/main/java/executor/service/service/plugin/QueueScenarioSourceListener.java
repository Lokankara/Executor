package executor.service.service.plugin;

import executor.service.model.Scenario;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.service.plugin.FileSourcesReader.readFile;
import static java.util.Arrays.asList;

public class QueueScenarioSourceListener
        implements ScenarioSourceListener {
    private static final String SCENARIO_JSON = "json/Scenario.json";
    private final Queue<Scenario> scenarioQueue = new LinkedBlockingQueue<>();

    @Override
    public void execute() {
        scenarioQueue.addAll(asList(readFile(SCENARIO_JSON, Scenario[].class)));
    }

    public Queue<Scenario> getScenarioQueue() {
        return scenarioQueue;
    }
}
