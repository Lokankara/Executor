package executor.service.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class StepTest {

    private Step a;
    private Step b;
    private Step step;

    @Before
    public void setUp() {
        a = new Step("up", "a");
        b = new Step("down", "b");
        step = new Step();
    }

    @Test
    @DisplayName("Given a StepDto with action 'up' and value 'a', when toString is called, then it should return Step{action='up', value='a'}")
    public void givenStepDtoWithUpAndA_whenToStringIsCalled_thenItShouldReturnCorrectString() {
        assertEquals("{action='up', value='a'}", a.toString());
        assertEquals("{action='down', value='b'}", b.toString());
    }

    @Test
    @DisplayName("Given two StepDto instances A and B with the same action and value, when hashCode is called, then their hash codes should be equal")
    public void givenStepDtoInstancesAAndBWithSameActionAndValue_whenHashCodeIsCalled_thenTheirHashCodesShouldBeEqual() {
        Step A = new Step("up", "a");
        Step B = new Step("down", "b");
        Step c = new Step("left", "c");

        assertEquals(this.a.hashCode(), A.hashCode());
        assertEquals(this.b.hashCode(), B.hashCode());
        assertNotEquals(this.a.hashCode(), this.b.hashCode());
        assertNotEquals(B.hashCode(), c.hashCode());
    }

    @Test
    @DisplayName("Given StepDto instances A and B with the same action and value, when equals is called, then they should be equal")
    public void givenStepDtoInstancesAAndBWithSameActionAndValue_whenEqualsIsCalled_thenTheyShouldBeEqual() {
        Step A = new Step("up", "a");
        Step B = new Step("down", "b");
        Step C = new Step("down", "c");

        assertEquals(a.equals(A), A.equals(a));
        assertEquals(b.equals(B), B.equals(b));
        assertNotEquals(a, b);
        assertNotEquals(b, C);
    }

    @Test
    @DisplayName("Given a StepDto instance, when setAction is called with 'up', then getAction should return 'up'")
    public void givenStepDtoInstance_whenSetActionIsCalledWithUp_thenGetActionShouldReturnUp() {
        step.setAction("up");
        assertEquals("up", step.getAction());
    }

    @Test
    @DisplayName("Given a StepDto instance, when setValue is called with 'a', then getValue should return 'a'")
    public void givenStepDtoInstance_whenSetValueIsCalledWithA_thenGetValueShouldReturnA() {
        step.setValue("a");
        assertEquals("a", step.getValue());
    }

    @Test
    @DisplayName("Given a StepDto instance, when setAction is called with 'down', then getAction should return 'down'")
    public void givenStepDtoInstance_whenSetActionIsCalledWithDown_thenGetActionShouldReturnDown() {
        step.setAction("down");
        assertEquals("down", step.getAction());
    }

    @Test
    @DisplayName("Given a StepDto instance, when setValue is called with 'b', then getValue should return 'b'")
    public void givenStepDtoInstance_whenSetValueIsCalledWithB_thenGetValueShouldReturnB() {
        step.setValue("b");
        assertEquals("b", step.getValue());
    }

    @Test
    public void testEquals_NullObject() {
        Step a = new Step("up", "a");
        assertFalse(a.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        Object b = new Object();
        assertFalse(a.equals(b));
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(a.equals(a));
    }
}