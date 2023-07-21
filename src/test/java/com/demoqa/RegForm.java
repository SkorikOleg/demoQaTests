package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.demoqa.TestBase;

public class RegForm {

    @Test
    void fillRegistrationForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Skorik");
        $("#userEmail").setValue("g@gmail.com");


        $("#genterWrapper").$(byText("Male")).click();
        //$("#gender-radio-1").selectRadio(".custom-control-label"); - можно использовать для радио батн
        // ,но надо разобраться, что будет лежать в value


        $("#userNumber").setValue("1234567890");


        $("#dateOfBirthInput").click();
        //$("#dateOfBirthInput").clear(); - разобраться, как очищать поле, что бы ввести свое значение
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--014").click();

        $("#subjectsContainer input").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("test.jpg"); // нужно добавить файл

        $("#currentAddress").click();
        $("#currentAddress").setValue("Amur region, Lenin str, 270 house");


        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Oleg Skorik"));
        $(".table-responsive").shouldHave(text("g@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("14 June,1992"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Amur region, Lenin str, 270 house"));
        $(".table-responsive").shouldHave(text("NCR Noida"));

    }
}
