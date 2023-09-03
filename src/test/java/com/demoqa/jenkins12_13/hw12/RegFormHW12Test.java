package com.demoqa.jenkins12_13.hw12;

import com.demoqa.pages.RegFormPage;
import com.demoqa.utils.UserVariables;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("remote")
public class RegFormHW12Test extends RemoteTestBase {

    RegFormPage regFormPage = new RegFormPage();
    UserVariables userVariables = new UserVariables();

    @Test
    @Story("Проверка заполнения регистрационной формы")
    @Owner("Skorik Oleg")
    @DisplayName("Успешная регистрация")
    void fillRegistrationForm() {

        step("Открываем регистрационную форму", () -> {
            regFormPage.openPage();
        });

        step("Заполняем поля", () -> {
            regFormPage
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
                    .setStateCityInput(userVariables.userState, userVariables.userCity);
        });

        step("Подтверждаем заполнение формы", () -> {

            regFormPage.clickSubmit();
        });

        step("Проверяем введенные значения", () -> {
            regFormPage
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
        });
    }
}