package com.demoqa.jenkins12.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.demoqa.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormRemoteTest extends RemoteTestBase {


    @Tag("remote")
    @Test
    void fillRegistrationForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Skorik");
        $("#userEmail").setValue("g@gmail.com");


        $("#genterWrapper").$(byText("Male")).click();


        $("#userNumber").setValue("1234567890");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--014:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsContainer input").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("filesForUtils/test.jpg");

        $("#currentAddress").click();
        $("#currentAddress").setValue("Amur region, Lenin str, 270 house");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Oleg Skorik"), text("g@gmail.com"), text("1234567890"));
        $(".table-responsive").shouldHave(text("Male"), text("14 June,1992"), text("Maths"), text("Sports"));
        $(".table-responsive").shouldHave(text("test.jpg"), text("Amur region, Lenin str, 270 house"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}