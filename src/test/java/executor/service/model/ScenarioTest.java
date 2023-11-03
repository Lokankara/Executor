package executor.service.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScenarioTest {

    private Scenario a;
    private Scenario b;
    private final Scenario scenario = new Scenario();
    List<Step> stepsA = new ArrayList<>();
    List<Step> stepsB = new ArrayList<>();

    @BeforeEach
    void setUp() {
        stepsA.add(new Step("up", "a"));
        stepsB.add(new Step("down", "b"));
        a = new Scenario("Scenario A", "Site A", stepsA);
        b = new Scenario("Scenario B", "Site B", stepsB);
    }

    @Test
    @DisplayName("Given a Scenario instance, when using the default constructor, then name, site, and steps should be null")
    void testDefaultConstructor() {
        assertNull(scenario.getName());
        assertNull(scenario.getSite());
        assertNull(scenario.getSteps());
    }

    @Test
    @DisplayName("Given Scenario instances A and B with the same name, site, and empty steps, when using getters and setters, then they should be equal")
    void testGettersAndSetters() {
        a.setName("New Name");
        a.setSite("New Site");
        List<Step> steps = new ArrayList<>();
        steps.add(new Step("up", "a"));
        a.setSteps(steps);

        assertEquals("New Name", a.getName());
        assertEquals("New Site", a.getSite());
        assertEquals(steps, a.getSteps());
    }

    @Test
    @DisplayName("Given Scenario instances A and B with the same name, site, and empty steps, when equals is called, then they should be equal")
    void testEquals_EqualScenarios() {
        Scenario aClone = new Scenario("Scenario A", "Site A", stepsA);
        assertTrue(a.equals(aClone));
    }

    @Test
    @DisplayName("Given Scenario instances A and B with different names, when equals is called, then they should not be equal")
    void testEquals_DifferentScenarios() {
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("Given Scenario instances A and A clone with the same name, site, and empty steps, when hashCode is called, then they should have the same hash code")
    void testHashCode() {
        Scenario aClone = new Scenario("Scenario A", "Site A", stepsA);
        assertEquals(a.hashCode(), aClone.hashCode());
    }

    @Test
    @DisplayName("Given a Scenario instance A with steps, when toString is called, then it should return the expected string representation")
    void testToString() {
        a.getSteps().add(new Step("up", "a"));
        String expected = "{name='Scenario A', site='Site A', steps=[{action='up', value='a'}, {action='up', value='a'}]}";
        assertEquals(expected, a.toString());
    }

    @Test
    @DisplayName("Given Scenario instances A and B with the same name, site, and steps, when equals is called, then they should be equal")
    void testEquals_SameScenario() {
        assertEquals(a, a);
    }

    @Test
    @DisplayName("Given Scenario instances A and B with different names, when equals is called, then they should not be equal")
    void testEquals_DifferentScenarioNames() {
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("Given Scenario instances A and B with different sites, when equals is called, then they should not be equal")
    void testEquals_DifferentScenarioSites() {
        b.setSite("Site A");
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("Given Scenario instances A and B with different steps, when equals is called, then they should not be equal")
    void testEquals_DifferentScenarioSteps() {
        b.getSteps().add(new Step("left", "c"));
        assertNotEquals(a, b);
    }

    @Test
    @DisplayName("Given Scenario instance A with steps and instance B without steps, when equals is called, then they should not be equal")
    void testEquals_ScenarioWithAndWithoutSteps() {
        Scenario c = new Scenario("Scenario C", "Site C", new ArrayList<>());
        assertNotEquals(a, c);
    }
}