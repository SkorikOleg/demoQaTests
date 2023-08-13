package com.demoqa.tests;

import com.demoqa.pages.RegFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.UserVariables.*;

public class RegFormHW8Tests extends TestBase {

    RegFormPage regFormPage = new RegFormPage();

    @Test
    void fillRegistrationForm() {
        regFormPage.openPage()
                .setFirstNameInput(userFirstName)
                .setLastNameInput(userLastName)
                .setUserEmailInput(userEmail)
                .setUserNumberInput(userPhone)
                .setGender(userGender)
                .setBirthDate(userDay, userMonth, userYear)
                .setSubjectInput(userSubjects)
                .setHobbiesInput(userHobby)
                .uploadPicture(userPicture)
                .setAddressInput(userAdress)
                .setStateCityInput(userState, userCity)
                .clickSubmit()
                .checkResultTable(userFirstName + " " + userLastName)
                .checkResultTable(userEmail)
                .checkResultTable(userPhone)
                .checkResultTable(userGender)
                .checkResultTable(userDay + " " + userMonth + "," + userYear)
                .checkResultTable(userSubjects)
                .checkResultTable(userHobby)
                .checkResultTable(userPicture)
                .checkResultTable(userAdress)
                .checkResultTable(userState + " " + userCity);
    }
}