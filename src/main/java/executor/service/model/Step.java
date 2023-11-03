package executor.service.model;

import java.util.Objects;

public class Step {
    private String action;
    private String value;

    public Step() {
    }

    public Step(
            final String action,
            final String value) {
        this.action = action;
        this.value = value;
    }

    public String getAction() {
        return action;
    }

    public void setAction(
            final String action) {
        this.action = action;
    }

    public String getValue() {
        return value;
    }

    public void setValue(
            final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Step step = (Step) o;

        if (!Objects.equals(action, step.action)) {
            return false;
        }
        return Objects.equals(value, step.value);
    }

    @Override
    public int hashCode() {
        int result = action != null
                     ? action.hashCode()
                     : 0;
        return 31 * result + (value != null
                              ? value.hashCode()
                              : 0);
    }

    @Override
    public String toString() {
        return String.format(
                "{action='%s', value='%s'}",
                action, value);
    }
}
