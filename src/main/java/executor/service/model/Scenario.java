package executor.service.model;

import java.util.List;
import java.util.Objects;

public class Scenario {
    private String name;
    private String site;
    private List<Step> steps;

    public Scenario() {

    }

    public Scenario(
            final String name,
            final String site,
            final List<Step> steps) {
        this.name = name;
        this.site = site;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(
            final String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(
            final String site) {
        this.site = site;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(
            final List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Scenario that = (Scenario) o;

        if (!Objects.equals(name, that.name)) {
            return false;
        }
        if (!Objects.equals(site, that.site)) {
            return false;
        }
        return Objects.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        int result = name != null
                     ? name.hashCode()
                     : 0;
        result = 31 * result + (site != null
                                ? site.hashCode()
                                : 0);
        return 31 * result + (steps != null
                              ? steps.hashCode()
                              : 0);
    }

    @Override
    public String toString() {
        return String.format(
                "{name='%s', site='%s', steps=%s}",
                name, site, steps);
    }
}
