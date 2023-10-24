package executor.service.model;

import java.io.Serializable;
import java.util.Objects;

public class ThreadPoolConfig
        implements Serializable {

    private static final long serialVersionUID = 1234567L;

    Integer corePoolSize;
    Long keepAliveTime;

    public ThreadPoolConfig() {
    }

    public ThreadPoolConfig(
            Integer corePoolSize,
            Long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(Long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreadPoolConfig that = (ThreadPoolConfig) o;

        if (!Objects.equals(corePoolSize, that.corePoolSize)) return false;
        return Objects.equals(keepAliveTime, that.keepAliveTime);
    }

    @Override
    public int hashCode() {
        int result = corePoolSize != null ? corePoolSize.hashCode() : 0;
        result = 31 * result + (keepAliveTime != null ? keepAliveTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
                "ThreadPoolConfig{corePoolSize=%d, keepAliveTime=%d}",
                corePoolSize,
                keepAliveTime);
    }
}
