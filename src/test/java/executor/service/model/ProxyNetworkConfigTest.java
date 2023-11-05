package executor.service.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
class ProxyNetworkConfigTest {

    private ObjectMapper objectMapper;
    private ProxyNetworkConfig config1;
    private ProxyNetworkConfig config2;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        config1 = new ProxyNetworkConfig("hostname1", 8080);
        config2 = new ProxyNetworkConfig("hostname2", 9090);
    }

    @Test
    @DisplayName("Given a JSON file, when parsing it into a ProxyNetworkConfig instance, then it should match the expected configuration")
    void testParsingJson()
            throws Exception {
        ProxyNetworkConfig expected =
                new ProxyNetworkConfig("example.com", 8080);
        ProxyNetworkConfig actual = objectMapper.readValue(getClass()
                .getClassLoader()
                .getResource("json/Network.json"), ProxyNetworkConfig.class);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when getHostname is called, then it should return the hostname")
    void getHostname() {
        assertEquals("hostname1", config1.getHostname());
        assertEquals("hostname2", config2.getHostname());
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when setHostname is called, then it should update the hostname")
    void setHostname() {
        config1.setHostname("newHostname");
        assertEquals("newHostname", config1.getHostname());
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when getPort is called, then it should return the port as expected")
    void getPort() {
        assertEquals(8080, (long) config1.getPort());
        assertEquals(9090, (long) config2.getPort());
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when setPort is called, then it should update the port and return the new value as expected")
    void setPort() {
        config2.setPort(8888);
        assertEquals(8888, (long) config2.getPort());
    }

    @Test
    @DisplayName("Given two ProxyNetworkConfig instances with the same hostname and port, when equals is called, then they should be equal")
    void testEquals() {
        ProxyNetworkConfig sameConfig =
                new ProxyNetworkConfig("hostname1", 8080);
        assertEquals(config1, sameConfig);
    }

    @Test
    @DisplayName("Given two ProxyNetworkConfig instances with different hostname and port, when equals is called, then they should not be equal")
    void testEquals_DifferentConfigurations() {
        assertNotEquals(config1, config2);
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when hashCode is called, then it should return the expected hash code")
    void testHashCode() {
        int expectedHashCode = config1.hashCode();
        assertEquals(expectedHashCode, config1.hashCode());
    }

    @Test
    @DisplayName("Given ProxyNetworkConfig instance, when toString is called, then it should return the expected string representation")
    void testToString() {
        String expectedString =
                "{hostname='hostname1', port=8080}";
        assertEquals(expectedString, config1.toString());
    }
}