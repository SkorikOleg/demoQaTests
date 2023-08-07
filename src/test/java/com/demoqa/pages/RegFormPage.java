package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.StateCityComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegFormPage {

    CalendarComponent calendar = new CalendarComponent();
    StateCityComponents stateCity = new StateCityComponents();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectName = $("#subjectsContainer input"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressClick = $("#currentAddress"),
            addressInput = $("#currentAddress"),
            stateClick = $("#state"),
            cityClick = $("#city"),
            submitClick = $("#submit"),
            resultTable = $(".table-responsive");

    public RegFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegFormPage setFirstNameInput(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegFormPage setLastNameInput(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegFormPage setUserEmailInput(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegFormPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegFormPage setUserNumberInput(String value){
        userNumber.setValue(value);

        return this;
    }
    public RegFormPage setBirthDate(String day, String month, String year){
        birthDateInput.click();
        calendar.setDate (day, month, year);

        return this;
    }
    public RegFormPage setSubjectInput(String value){
        subjectName.setValue(value).pressEnter();

        return this;
    }
    public RegFormPage setHobbiesInput(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegFormPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    public RegFormPage setAddressInput(String value){
        addressClick.click();
        addressInput.setValue(value);

        return this;
    }
    public RegFormPage setStateCityInput(String state, String city){
        stateClick.click();
        stateCity.setState(state);
        cityClick.click();
        stateCity.setCity(city);

        return this;
    }
    public RegFormPage clickSubmit(){
        submitClick.click();

        return this;
    }

    public RegFormPage checkResultTable(String value){
        resultTable.shouldHave(text(value));

        return this;
    }
}
