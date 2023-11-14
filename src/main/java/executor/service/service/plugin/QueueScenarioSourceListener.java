package executor.service.service.plugin;

import executor.service.model.Scenario;

import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.model.Constants.SCENARIO_FILENAME;
import static executor.service.service.plugin.FileSourcesReader.readFile;
import static java.util.Arrays.asList;

public class QueueScenarioSourceListener
        implements ScenarioSourceListener {

    @Override
    public void execute() {
        ScenarioSourceHolder.getInstance(new LinkedBlockingQueue<>(
                asList(readFile(SCENARIO_FILENAME, Scenario[].class))));
    }
}
