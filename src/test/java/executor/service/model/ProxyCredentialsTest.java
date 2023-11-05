package executor.service.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProxyCredentialsTest {

    private ProxyCredentials jack;
    private ProxyCredentials bob;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        jack = new ProxyCredentials("Jack", "sparrow");
        bob = new ProxyCredentials("Bob", "marley");
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when getUsername is called, then it should return the username")
    void getUsername() {
        assertEquals("Jack", jack.getUsername());
        assertEquals("Bob", bob.getUsername());
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when setUsername is called, then it should update the username")
    void setUsername() {
        jack.setUsername("dawson");
        assertEquals("dawson", jack.getUsername());
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when getPassword is called, then it should return the password")
    void getPassword() {
        assertEquals("sparrow", jack.getPassword());
        assertEquals("marley", bob.getPassword());
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when setPassword is called, then it should update the password")
    void setPassword() {
        bob.setPassword("newPassword");
        assertEquals("newPassword", bob.getPassword());
    }

    @Test
    @DisplayName("Given two ProxyCredentials instances with the same username and password, when equals is called, then they should be equal")
    void testEquals() {
        ProxyCredentials credentials = new ProxyCredentials("Jack", "sparrow");
        assertEquals(jack, credentials);
        assertNotEquals(jack, bob);
    }

    @Test
    @DisplayName("Given two ProxyCredentials instances with the same username and password, when hashCode is called, then they should have the same hash code")
    void testHashCode() {
        ProxyCredentials credentials = new ProxyCredentials("Jack", "sparrow");
        assertEquals(jack.hashCode(), credentials.hashCode());
    }

    @Test
    @DisplayName("Given a JSON file with ProxyNetworkConfig data, when parsing it into a list, then it should match the expected list")
    void testParsingJson() throws IOException {
        List<ProxyNetworkConfig> expected = new ArrayList<>();
        expected.add(new ProxyNetworkConfig("host1", 8080));
        expected.add(new ProxyNetworkConfig("host2", 8088));
        expected.add(new ProxyNetworkConfig("host3", 8089));
        List<ProxyNetworkConfig> actualConfigs = objectMapper.readValue(
                getClass().getClassLoader().getResource(
                        "json/ProxyNetwork.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ProxyNetworkConfig.class)
        );

        assertEquals(expected, actualConfigs);
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when default constructor is called, then username and password should be null")
    void testDefaultConstructor() {
        ProxyCredentials emptyCredentials = new ProxyCredentials();
        assertNull(emptyCredentials.getUsername());
        assertNull(emptyCredentials.getPassword());
    }

    @Test
    @DisplayName("Given ProxyCredentials instances, when equals is called with the same username and password, then they should be equal")
    void testEquals_EqualCredentials() {
        ProxyCredentials sameCredentials =
                new ProxyCredentials("Jack", "sparrow");
        assertEquals(jack, sameCredentials);
    }

    @Test
    @DisplayName("Given ProxyCredentials instances, when equals is called with different username and password, then they should not be equal")
    void testEquals_DifferentCredentials() {
        assertNotEquals(jack, bob);
    }

    @Test
    @DisplayName("Given ProxyCredentials instance, when hashCode is called, then it should return the expected hash code")
    void testHashCodes() {
        ProxyCredentials jack = new ProxyCredentials("Jack", "sparrow");
        int expectedHashCode = jack.hashCode();
        assertEquals(expectedHashCode, jack.hashCode());
    }
}
