package executor.service.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Scenario implements Serializable {

    private static final long serialVersionUID = 12345L;
    private String name;
    private String site;
    private List<Step> steps;

    public Scenario() {

    }

    public Scenario(
            String name,
            String site,
            List<Step> steps) {
        this.name = name;
        this.site = site;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scenario that = (Scenario) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(site, that.site)) return false;
        return Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (steps != null ? steps.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ScenarioDto{name='%s', site='%s', steps=%s}",
                             name,
                             site,
                             steps);
    }
}
