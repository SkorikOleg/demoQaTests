package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll //аннотация для запуста теста до все тестов
    static void beforeAll() { // с этой аннотацией всегда используется метод static
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
