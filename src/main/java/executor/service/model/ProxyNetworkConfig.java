package executor.service.model;

import java.io.Serializable;
import java.util.Objects;

public class ProxyNetworkConfig
        implements Serializable {

    private static final long serialVersionUID = 1234567L;
    String hostname;
    Integer port;

    public ProxyNetworkConfig() {
    }

    public ProxyNetworkConfig(
            String hostname,
            Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProxyNetworkConfig that = (ProxyNetworkConfig) o;

        if (!Objects.equals(hostname, that.hostname)) return false;
        return Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        int result = hostname != null ? hostname.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ProxyNetworkConfig{hostname='%s', port=%d}",
                             hostname,
                             port);
    }
}
