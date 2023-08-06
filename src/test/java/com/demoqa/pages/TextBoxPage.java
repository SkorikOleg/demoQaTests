package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitClick = $("#submit"),
            checkResultTable = $(".border");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserNameInput(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmit() {
        submitClick.click();

        return this;
    }
    public TextBoxPage checkResult(String value) {
        checkResultTable.shouldHave(text(value));

        return this;
    }
}
