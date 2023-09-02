package com.demoqa.jenkins12.hw;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.jenkins12.hw.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


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

    @BeforeEach
    void addListenerAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
