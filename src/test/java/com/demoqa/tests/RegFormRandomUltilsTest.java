package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;

public class RegFormRandomUltilsTest extends TestBase {


    @Test
    void fillRegistrationForm() {

        String firstName = getRandomString (10),
                lastName = getRandomString (10),
                userEmail = getRandomEmail(),
                gender = getRandomGender();

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--014:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsContainer input").setValue("Math").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("test.jpg");

        $("#currentAddress").click();
        $("#currentAddress").setValue("Amur region, Lenin str, 270 house");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text("1234567890"));
        $(".table-responsive").shouldHave(text(gender), text("14 June,1992"), text("Maths"), text("Sports"));
        $(".table-responsive").shouldHave(text("test.jpg"), text("Amur region, Lenin str, 270 house"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}