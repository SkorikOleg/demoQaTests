package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponents {
    public void setState(String state) {
        $("#stateCity-wrapper").$(byText(state)).click();
    }

    public void setCity(String city) {
        $("#stateCity-wrapper").$(byText(city)).click();
    }
}
