package executor.service.service.plugin;

import java.util.Queue;

public interface ScenarioSourceListener<T> {

    Queue<T> execute(String filename, Class<T> types);
}
