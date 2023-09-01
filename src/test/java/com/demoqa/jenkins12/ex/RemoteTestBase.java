package com.demoqa.jenkins12.ex;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.of;


public class RemoteTestBase {

    @BeforeAll //аннотация для запуста теста до все тестов
    static void beforeAll() { // с этой аннотацией всегда используется метод static
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //для того что бы прописать креды, нужно добавить в урл https://наименование пользака:пароль@урл

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Map<String, Object> value = new HashMap<>();
        value.put("enableVNC", true);
        value.put("enableVideo", true);
        capabilities.setCapability("selenoid:options", value);
        Configuration.browserCapabilities = capabilities;
    }
}
