package com.demoqa.tests;

import com.demoqa.pages.RegFormPage;
import com.demoqa.utils.UserVariables;
import org.junit.jupiter.api.Test;

public class RegFormHW8Tests extends TestBase {

    RegFormPage regFormPage = new RegFormPage();
    UserVariables userVariables = new UserVariables();

    @Test
    void fillRegistrationForm() {
        regFormPage.openPage()
                .setFirstNameInput(userVariables.userFirstName)
                .setLastNameInput(userVariables.userLastName)
                .setUserEmailInput(userVariables.userEmail)
                .setUserNumberInput(userVariables.userPhone)
                .setGender(userVariables.userGender)
                .setBirthDate(userVariables.userDay, userVariables.userMonth, userVariables.userYear)
                .setSubjectInput(userVariables.userSubjects)
                .setHobbiesInput(userVariables.userHobby)
                .uploadPicture(userVariables.userPicture)
                .setAddressInput(userVariables.userAdress)
                .setStateCityInput(userVariables.userState, userVariables.userCity)
                .clickSubmit()
                .checkResultTable(userVariables.userFirstName + " " + userVariables.userLastName)
                .checkResultTable(userVariables.userEmail)
                .checkResultTable(userVariables.userPhone)
                .checkResultTable(userVariables.userGender)
                .checkResultTable(userVariables.userDay
                        + " " + userVariables.userMonth
                        + "," + userVariables.userYear)
                .checkResultTable(userVariables.userSubjects)
                .checkResultTable(userVariables.userHobby)
                .checkResultTable(userVariables.userPicture)
                .checkResultTable(userVariables.userAdress)
                .checkResultTable(userVariables.userState + " " + userVariables.userCity);
    }
}