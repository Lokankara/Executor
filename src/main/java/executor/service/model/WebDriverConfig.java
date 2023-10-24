package executor.service.model;

import java.io.Serializable;
import java.util.Objects;

public class WebDriverConfig
        implements Serializable {

    private static final long serialVersionUID = 7654321L;
    String webDriverExecutable;
    String userAgent;
    Long pageLoadTimeout;
    Long implicitlyWait;

    public WebDriverConfig() {
    }

    public WebDriverConfig(
            String webDriverExecutable,
            String userAgent,
            Long pageLoadTimeout,
            Long implicitlyWait) {
        this.webDriverExecutable = webDriverExecutable;
        this.userAgent = userAgent;
        this.pageLoadTimeout = pageLoadTimeout;
        this.implicitlyWait = implicitlyWait;
    }

    public String getWebDriverExecutable() {
        return webDriverExecutable;
    }

    public void setWebDriverExecutable(String webDriverExecutable) {
        this.webDriverExecutable = webDriverExecutable;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Long getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Long pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public Long getImplicitlyWait() {
        return implicitlyWait;
    }

    public void setImplicitlyWait(Long implicitlyWait) {
        this.implicitlyWait = implicitlyWait;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebDriverConfig that = (WebDriverConfig) o;

        if (!Objects.equals(webDriverExecutable, that.webDriverExecutable))
            return false;
        if (!Objects.equals(userAgent, that.userAgent)) return false;
        if (!Objects.equals(pageLoadTimeout, that.pageLoadTimeout))
            return false;
        return Objects.equals(implicitlyWait, that.implicitlyWait);
    }

    @Override
    public int hashCode() {
        int result = webDriverExecutable != null ? webDriverExecutable.hashCode() : 0;
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (pageLoadTimeout != null ? pageLoadTimeout.hashCode() : 0);
        result = 31 * result + (implicitlyWait != null ? implicitlyWait.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "WebDriverConfig{webDriverExecutable='%s', userAgent='%s', pageLoadTimeout=%d, implicitlyWait=%d}",
                webDriverExecutable,
                userAgent,
                pageLoadTimeout,
                implicitlyWait);
    }
}
