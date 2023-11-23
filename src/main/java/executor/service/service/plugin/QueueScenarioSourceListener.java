package executor.service.service.plugin;


import executor.service.model.Scenario;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.model.Constants.SCENARIO_FILENAME;

public class QueueScenarioSourceListener
        implements ScenarioSourceListener<Scenario> {

    private final Queue<Scenario> scenarioQueue;

    public QueueScenarioSourceListener() {
        scenarioQueue = new FileSourcesReader()
                        .getAllFromFile(SCENARIO_FILENAME, Scenario.class);
    }

    @Override
    public Queue<Scenario> execute(
            String filename,
            Class<Scenario> type) {
        return new LinkedBlockingQueue<>(scenarioQueue);
    }
}
