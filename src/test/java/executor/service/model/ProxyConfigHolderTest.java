package executor.service.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ProxyConfigHolderTest {

    private ProxyNetworkConfig networkConfig1;
    private ProxyNetworkConfig networkConfig2;
    private ProxyCredentials credentials1;
    private ProxyCredentials credentials2;
    private ProxyConfigHolder holder1;
    private ProxyConfigHolder holder2;

    @Before
    public void setUp() {
        networkConfig1 = new ProxyNetworkConfig("proxyHost1", 8080);
        networkConfig2 = new ProxyNetworkConfig("proxyHost2", 8081);
        credentials1 = new ProxyCredentials("username1", "password1");
        credentials2 = new ProxyCredentials("username2", "password2");
        holder1 = new ProxyConfigHolder(networkConfig1, credentials1);
        holder2 = new ProxyConfigHolder(networkConfig2, credentials2);
    }

    @Test
    @DisplayName("Given a ProxyConfigHolder instance, when getProxyNetworkConfig is called, then it should return the network configuration")
    public void getProxyNetworkConfig() {
        assertEquals(networkConfig1, holder1.getProxyNetworkConfig());
        assertEquals(networkConfig2, holder2.getProxyNetworkConfig());
    }

    @Test
    @DisplayName("Given a ProxyConfigHolder instance, when setProxyNetworkConfig is called, then it should update the network configuration")
    public void setProxyNetworkConfig() {
        ProxyNetworkConfig newNetworkConfig = new ProxyNetworkConfig();
        newNetworkConfig.setPort(8082);
        newNetworkConfig.setHostname("newProxyHost");
        holder1.setProxyNetworkConfig(newNetworkConfig);
        assertEquals(newNetworkConfig, holder1.getProxyNetworkConfig());
    }

    @Test
    @DisplayName("Given a ProxyConfigHolder instance, when getProxyCredentials is called, then it should return the credentials")
    public void getProxyCredentials() {
        assertEquals(credentials1, holder1.getProxyCredentials());
        assertEquals(credentials2, holder2.getProxyCredentials());
    }

    @Test
    @DisplayName("Given a ProxyConfigHolder instance, when setProxyCredentials is called, then it should update the credentials")
    public void setProxyCredentials() {
        ProxyCredentials newCredentials = new ProxyCredentials("newUsername",
                                                               "newPassword");
        holder2.setProxyCredentials(newCredentials);
        assertEquals(newCredentials, holder2.getProxyCredentials());
    }

    @Test
    @DisplayName("Given two ProxyConfigHolder instances with the same network configuration and credentials, when equals is called, then they should be equal")
    public void testEquals() {
        ProxyConfigHolder sameHolder = new ProxyConfigHolder();
        sameHolder.setProxyCredentials(credentials1);
        sameHolder.setProxyNetworkConfig(networkConfig1);
        assertEquals(holder1, sameHolder);
        assertNotEquals(holder1, holder2);
    }

    @Test
    @DisplayName("Given two ProxyConfigHolder instances with the same network configuration and credentials, when hashCode is called, then they should have the same hash code")
    public void testHashCode() {
        ProxyConfigHolder sameHolder = new ProxyConfigHolder(networkConfig1,
                                                             credentials1);
        assertEquals(holder1.hashCode(), sameHolder.hashCode());
    }

    @Test
    @DisplayName("Given a ProxyConfigHolder instance, when toString is called, then it should return the expected string representation")
    public void testToString() {
        String expectedString = "{proxyNetworkConfig={hostname='proxyHost1', port=8080}, proxyCredentials={username='username1', password='password1'}}";
        assertEquals(expectedString, holder1.toString());
    }
}