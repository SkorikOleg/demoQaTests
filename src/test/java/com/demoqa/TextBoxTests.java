package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    void fillFormTest (){
        open ("/text-box");

        $ ("#userName").setValue("Oleg Skorik");
        $ ("#userEmail").setValue("new@one.com");
        $ ("#currentAddress").setValue("Amur Region, Blago city");
        $ ("#permanentAddress").setValue("Moscow, Never sleeps");
        $ ("#submit").click();

        //$ ("#output").$ ("#name").shouldHave(text("")); - если нам необходимо использовать локатор
        //внутри родителя, то мы можем добавить вот так
        $ ("#output #name").shouldHave(text("Oleg Skorik")); // а можем через пробел указать
        $ ("#output #email").shouldHave(text("new@one.com"));
        $ ("#output #currentAddress").shouldHave(text("Amur Region, Blago city"));
        $ ("#output #permanentAddress").shouldHave(text("Moscow, Never sleeps"));
    }
}
