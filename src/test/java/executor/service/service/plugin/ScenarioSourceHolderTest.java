package executor.service.service.plugin;

import executor.service.model.Scenario;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertSame;

class ScenarioSourceHolderTest {

    @Test
    void testSingleton() {
        Queue<Scenario> scenarios = new LinkedList<>();
        scenarios.add(new Scenario());
        scenarios.add(new Scenario());

        ScenarioSourceHolder instance1 =
                ScenarioSourceHolder.getInstance(scenarios);
        ScenarioSourceHolder instance2 =
                ScenarioSourceHolder.getInstance(scenarios);
        assertSame(instance1, instance2);
//        assertSame(scenarios, instance1.getScenarioQueue());
    }
}
