package com.segmentfault.springbootlesson19;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.Assert.*;

/**
 * {@link org.springframework.core.env.Environment}
 *
 * @author miaoo
 * @since 2018/11/22
 */
public class EnvironmentTest {

    @Test
    public void testSystemProperties(){
        assertNotNull(System.getProperty("os.arch"));

        MockEnvironment environment = new MockEnvironment();
        environment.setProperty("user.country","EN");
        assertEquals("EN",environment.getProperty("user.country"));
    }

    @Test
    public void testManagementSecurityEnable(){
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty("management.security.enabled","true");
        assertTrue(Boolean.valueOf(environment.getProperty("management.security.enabled")));
    }

    //方法名要语义化
    @Test
    public void testManagementSecurityDisable(){
        MockEnvironment environment = new MockEnvironment();
        environment.setProperty("management.security.enabled","false");
        assertFalse(environment.getProperty("management.security.enabled",Boolean.class));
    }
}
