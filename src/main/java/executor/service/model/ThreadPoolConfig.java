package executor.service.model;

import java.util.Objects;

public class ThreadPoolConfig {
    private Integer corePoolSize;
    private Long keepAliveTime;

    public ThreadPoolConfig() {
    }

    public ThreadPoolConfig(
            final Integer corePoolSize,
            final Long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(
            final Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(
            final Long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ThreadPoolConfig that = (ThreadPoolConfig) o;

        if (!Objects.equals(corePoolSize, that.corePoolSize)) {
            return false;
        }
        return Objects.equals(keepAliveTime, that.keepAliveTime);
    }

    @Override
    public int hashCode() {
        int result = corePoolSize != null
                     ? corePoolSize.hashCode()
                     : 0;
        return 31 * result + (keepAliveTime != null
                              ? keepAliveTime.hashCode()
                              : 0);
    }

    @Override
    public String toString() {
        return String.format(
                "{corePoolSize=%d, keepAliveTime=%d}",
                corePoolSize,
                keepAliveTime);
    }
}
