package executor.service.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreadPoolConfigTest {

    private ThreadPoolConfig config1;
    private ThreadPoolConfig config2;

    @BeforeEach
    void setUp() {
        config1 = new ThreadPoolConfig();
        config1.setCorePoolSize(10);
        config1.setKeepAliveTime(500L);

        config2 = new ThreadPoolConfig();
        config2.setCorePoolSize(15);
        config2.setKeepAliveTime(1000L);
    }

    @Test
    @DisplayName("Given ThreadPoolConfig with core pool size 10, when getCorePoolSize is called, then it should return 10")
    void testGetCorePoolSize() {
        assertEquals(10, (long) config1.getCorePoolSize());
    }

    @Test
    @DisplayName("Given ThreadPoolConfig with core pool size 15, when getCorePoolSize is called, then it should return 15")
    void testGetCorePoolSize2() {
        assertEquals(15, (long) config2.getCorePoolSize());
    }

    @Test
    @DisplayName("Given ThreadPoolConfig, when setCorePoolSize is called with 20, then getCorePoolSize should return 20")
    void testSetCorePoolSize() {
        config1.setCorePoolSize(20);
        assertEquals(20, (long) config1.getCorePoolSize());
    }

    @Test
    @DisplayName("Given ThreadPoolConfig with keep-alive time of 500ms, when getKeepAliveTime is called, then it should return 500")
    void testGetKeepAliveTime() {
        assertEquals(500, (long) config1.getKeepAliveTime());
    }

    @Test
    @DisplayName("Given ThreadPoolConfig with keep-alive time of 1000ms, when getKeepAliveTime is called, then it should return 1000")
    void testGetKeepAliveTime2() {
        assertEquals(1000, (long) config2.getKeepAliveTime());
    }

    @Test
    @DisplayName("Given ThreadPoolConfig, when setKeepAliveTime is called with 600ms, then getKeepAliveTime should return 600")
    void testSetKeepAliveTime() {
        config1.setKeepAliveTime(600L);
        assertEquals(600, (long) config1.getKeepAliveTime());
    }

    @Test
    @DisplayName("Test constructor with core pool size and keep-alive time")
    void testConstructor() {
        assertEquals(10, (long) config1.getCorePoolSize());
        assertEquals(500L, (long) config1.getKeepAliveTime());

        assertEquals(15, (long) config2.getCorePoolSize());
        assertEquals(1000L, (long) config2.getKeepAliveTime());
    }

    @Test
    @DisplayName("Test equals: Equal ThreadPoolConfig objects")
    void testEquals_EqualConfigs() {
        ThreadPoolConfig config1Clone = new ThreadPoolConfig(10, 500L);
        assertTrue(config1.equals(config1Clone));
    }

    @Test
    @DisplayName("Test equals: Different ThreadPoolConfig objects")
    void testEquals_DifferentConfigs() {
        assertFalse(config1.equals(config2));
    }

    @Test
    @DisplayName("Test hashCode")
    void testHashCode() {
        ThreadPoolConfig config1Clone = new ThreadPoolConfig(10, 500L);
        assertEquals(config1.hashCode(), config1Clone.hashCode());
    }

    @Test
    @DisplayName("Test toString")
    void testToString() {
        String expected = "{corePoolSize=10, keepAliveTime=500}";
        assertEquals(expected, config1.toString());
    }
}
