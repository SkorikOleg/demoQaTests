package com.demoqa.tests;

import com.demoqa.pages.RegFormPage;
import com.demoqa.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormWithPageObjectsTest extends TestBase {

    RegFormPage regFormPage = new RegFormPage();

    @Test
    void fillRegistrationForm() {
        regFormPage.openPage()
                .setFirstNameInput("Oleg")
                .setLastNameInput("Skorik")
                .setLastNameInput("Skorik")
                .setUserEmailInput("g@gmail.com")
                .setGender("Male")
                .setUserNumberInput("1234567890")
                .setBirthDate("14", "June", "1992")
                .setSubjectInput("Math")
                .setHobbiesInput("Sports")
                .uploadPicture("test.jpg")
                .setAddressInput("Amur region, Lenin str, 270 house")
                .setStateCityInput("NCR", "Noida")
                .clickSubmit()
                .checkResultTable("Oleg Skorik")
                .checkResultTable("g@gmail.com")
                .checkResultTable("1234567890")
                .checkResultTable("Male")
                .checkResultTable("14 June,1992")
                .checkResultTable("Maths")
                .checkResultTable("Sports")
                .checkResultTable("test.jpg")
                .checkResultTable("Amur region, Lenin str, 270 house")
                .checkResultTable("NCR Noida");
    }
}