package executor.service.model;

import java.util.Objects;

public class WebDriverConfig {
    private String webDriverExecutable;
    private String userAgent;
    private Long pageLoadTimeout;
    private Long implicitlyWait;

    public WebDriverConfig() {
    }

    public WebDriverConfig(
            final String webDriverExecutable,
            final String userAgent,
            final Long pageLoadTimeout,
            final Long implicitlyWait) {
        this.webDriverExecutable = webDriverExecutable;
        this.userAgent = userAgent;
        this.pageLoadTimeout = pageLoadTimeout;
        this.implicitlyWait = implicitlyWait;
    }

    public String getWebDriverExecutable() {
        return webDriverExecutable;
    }

    public void setWebDriverExecutable(
            final String webDriverExecutable) {
        this.webDriverExecutable = webDriverExecutable;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(
            final String userAgent) {
        this.userAgent = userAgent;
    }

    public Long getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(
            final Long pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public Long getImplicitlyWait() {
        return implicitlyWait;
    }

    public void setImplicitlyWait(
            final Long implicitlyWait) {
        this.implicitlyWait = implicitlyWait;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebDriverConfig that = (WebDriverConfig) obj;
        return Objects.equals(
                webDriverExecutable, that.webDriverExecutable)
                && Objects.equals(userAgent, that.userAgent)
                && Objects.equals(pageLoadTimeout, that.pageLoadTimeout)
                && Objects.equals(implicitlyWait, that.implicitlyWait);
    }

    @Override
    public int hashCode() {
        int result = webDriverExecutable != null
                     ? webDriverExecutable.hashCode()
                     : 0;
        result = 31 * result + (userAgent != null
                                ? userAgent.hashCode()
                                : 0);
        result = 31 * result + (pageLoadTimeout != null
                                ? pageLoadTimeout.hashCode()
                                : 0);
        result = 31 * result + (implicitlyWait != null
                                ? implicitlyWait.hashCode()
                                : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "{webDriverExecutable='%s', userAgent='%s', pageLoadTimeout=%d, implicitlyWait=%d}",
                webDriverExecutable,
                userAgent,
                pageLoadTimeout,
                implicitlyWait);
    }
}
