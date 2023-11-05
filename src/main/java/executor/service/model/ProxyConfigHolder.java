package executor.service.model;

import java.util.Objects;

public class ProxyConfigHolder {
    private ProxyNetworkConfig proxyNetworkConfig;
    private ProxyCredentials proxyCredentials;

    public ProxyConfigHolder() {
    }

    public ProxyConfigHolder(
            final ProxyNetworkConfig proxyNetworkConfig,
            final ProxyCredentials proxyCredentials) {
        this.proxyNetworkConfig = proxyNetworkConfig;
        this.proxyCredentials = proxyCredentials;
    }

    public ProxyNetworkConfig getProxyNetworkConfig() {
        return proxyNetworkConfig;
    }

    public void setProxyNetworkConfig(
            final ProxyNetworkConfig proxyNetworkConfig) {
        this.proxyNetworkConfig = proxyNetworkConfig;
    }

    public ProxyCredentials getProxyCredentials() {
        return proxyCredentials;
    }

    public void setProxyCredentials(
            final ProxyCredentials proxyCredentials) {
        this.proxyCredentials = proxyCredentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProxyConfigHolder that = (ProxyConfigHolder) o;

        if (!Objects.equals(proxyNetworkConfig, that.proxyNetworkConfig)) {
            return false;
        }
        return Objects.equals(proxyCredentials, that.proxyCredentials);
    }

    @Override
    public int hashCode() {
        int result = proxyNetworkConfig != null
                     ? proxyNetworkConfig.hashCode()
                     : 0;
        return 31 * result + (proxyCredentials != null
                              ? proxyCredentials.hashCode()
                              : 0);
    }

    @Override
    public String toString() {
        return String.format("{proxyNetworkConfig=%s, proxyCredentials=%s}",
                proxyNetworkConfig,
                proxyCredentials);
    }
}
