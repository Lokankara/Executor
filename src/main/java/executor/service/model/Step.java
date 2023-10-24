package executor.service.model;

import java.io.Serializable;
import java.util.Objects;

public class Step
        implements Serializable {

    private static final long serialVersionUID = 54321L;

    public Step() {
    }

    public Step(
            String action,
            String value) {
        this.action = action;
        this.value = value;
    }

    private String action;
    private String value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Step step = (Step) o;

        if (!Objects.equals(action, step.action)) return false;
        return Objects.equals(value, step.value);
    }

    @Override
    public int hashCode() {
        int result = action != null ? action.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Step{action='%s', value='%s'}", action, value);
    }
}