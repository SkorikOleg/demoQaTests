package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage
                .openPage()
                .setUserNameInput("Oleg Skorik")
                .setUserEmailInput("new@one.com")
                .setCurrentAddressInput("Amur Region, Blago city")
                .setPermanentAddressInput("Moscow, Never sleeps")
                .clickSubmit()


        /*$("#userName").setValue("Oleg Skorik");
        $("#userEmail").setValue("new@one.com");
        $("#currentAddress").setValue("Amur Region, Blago city");
        $("#permanentAddress").setValue("Moscow, Never sleeps");
        $("#submit").click();
        */
        /*$ ("#output").$ ("#name").shouldHave(text("")); - если нам необходимо использовать локатор
        внутри родителя, то мы можем добавить вот так*/

                .checkResult("Oleg Skorik")
                .checkResult("new@one.com")
                .checkResult("Amur Region, Blago city")
                .checkResult("Moscow, Never sleeps");

        /*$("#output #name").shouldHave(text("Oleg Skorik")); // а можем через пробел указать
        $("#output #email").shouldHave(text("new@one.com"));
        $("#output #currentAddress").shouldHave(text("Amur Region, Blago city"));
        $("#output #permanentAddress").shouldHave(text("Moscow, Never sleeps"));*/
    }
}
