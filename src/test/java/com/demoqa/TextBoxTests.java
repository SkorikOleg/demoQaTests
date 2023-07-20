package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll //аннотация для запуста теста до все тестов
    static void beforeAll() { // с этой аннотацией всегда используется метод static
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest (){
        open ("/text-box");

        $ ("#userName").setValue("Oleg Skorik");
        $ ("#userEmail").setValue("new@one.com");
        $ ("#currentAddress").setValue("Amur Region, Blago city");
        $ ("#permanentAddress").setValue("Moscow, Never sleeps");
        $ ("#submit").click();

        //$ ("#output").$ ("#name").shouldHave(text("")); - если нам необходимо использовать локатор
        //        // внутри родителя, то мы можем добавить вот так

        $ ("#output #name").shouldHave(text("Oleg Skorik")); // а можем через пробел указать
        $ ("#output #email").shouldHave(text("new@one.com"));
        $ ("#output #currentAddress").shouldHave(text("Amur Region, Blago city"));
        $ ("#output #permanentAddress").shouldHave(text("Moscow, Never sleeps"));
    }
}
