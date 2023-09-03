package com.demoqa.jenkins.hw12_13.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    void systemPropertyTest (){
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemPropertyTest1 (){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
    @Test
    void systemPropertyTest2 (){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }
    @Test
    @Tag("property")
    void systemPropertyTest3 (){
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }
}
