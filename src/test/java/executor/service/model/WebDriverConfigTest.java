package executor.service.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WebDriverConfigTest {

    private WebDriverConfig config1;
    private WebDriverConfig config2;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        config1 = new WebDriverConfig("path", "userAgent", 10L, 20L);
        config2 = new WebDriverConfig("path2", "userAgent2", 15L, 25L);
    }

    @Test
    @DisplayName("Given WebDriverConfig instances with different values, when using getters, then they should return the correct values")
    public void testGetters() {
        assertEquals("path", config1.getWebDriverExecutable());
        assertEquals("userAgent", config1.getUserAgent());
        assertEquals(10L, (long) config1.getPageLoadTimeout());
        assertEquals(20L, (long) config1.getImplicitlyWait());

        assertEquals("path2", config2.getWebDriverExecutable());
        assertEquals("userAgent2", config2.getUserAgent());
        assertEquals(15L, (long) config2.getPageLoadTimeout());
        assertEquals(25L, (long) config2.getImplicitlyWait());
    }

    @Test
    @DisplayName("Given equal WebDriverConfig instances, when testing equality, then they should be considered equal")
    public void testEquals_EqualConfigs() {
        WebDriverConfig config1 = new WebDriverConfig("path",
                "userAgent",
                10L,
                20L);
        WebDriverConfig config1Clone = new WebDriverConfig("path",
                "userAgent",
                10L,
                20L);
        assertTrue(config1.equals(config1Clone));
    }

    @Test
    @DisplayName("Given different WebDriverConfig instances, when testing equality, then they should not be considered equal")
    public void testEquals_DifferentConfigs() {
        assertFalse(config1.equals(config2));
    }

    @Test
    @DisplayName("Given equal WebDriverConfig instances, when calculating the hash code, then it should be the same")
    public void testHashCode() {
        WebDriverConfig config1Clone = new WebDriverConfig("path",
                "userAgent",
                10L,
                20L);
        assertEquals(config1.hashCode(), config1Clone.hashCode());
    }

    @Test
    @DisplayName("Given a WebDriverConfig instance, when calling toString, then it should return the expected JSON string")
    public void testToString()
            throws IOException {
        WebDriverConfig expected = objectMapper.readValue(getClass()
                .getClassLoader()
                .getResource("WebDriverConfig.json"), WebDriverConfig.class);
        String expectedString = expected.toString();
        String actual = config1.toString();
        assertEquals(actual, expectedString);
    }

    @Test
    @DisplayName("Test WebDriverConfig setters and getters")
    public void testSettersAndGetters() {
        WebDriverConfig config = new WebDriverConfig();
        config.setWebDriverExecutable("path");
        config.setUserAgent("userAgent");
        config.setPageLoadTimeout(10L);
        config.setImplicitlyWait(20L);

        assertEquals("path", config.getWebDriverExecutable());
        assertEquals("userAgent", config.getUserAgent());
        assertEquals(10L, (long) config.getPageLoadTimeout());
        assertEquals(20L, (long) config.getImplicitlyWait());
    }

}
