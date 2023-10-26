package executor.service.service.plugin.impl;

import executor.service.model.Scenario;
import executor.service.service.plugin.ScenarioSourceListener;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.service.plugin.FileSourcesReader.readFile;

public class ScenarioSourceListenerImpl
        implements ScenarioSourceListener {
    private final Queue<Scenario> scenarioQueue = new LinkedBlockingQueue<>();

    @Override
    public void execute() {
        String filename = "Scenario.json";
        Scenario[] scenarios = readFile(filename, Scenario[].class);
        scenarioQueue.addAll(Arrays.asList(scenarios));
    }

    public Queue<Scenario> getScenarioQueue() {
        return scenarioQueue;
    }
}
