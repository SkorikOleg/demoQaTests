package guru.qa.allure11.hw;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class LambdaStepsHWTest {
    static {
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String nameRepo = "qa-guru/niffler";
    private static final int NumberIssue = 70;

    @Test
    public void searchIssueWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу с поиском", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + nameRepo, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").click();
            $("#query-builder-test").setValue(nameRepo).pressEnter();
        });

        step("Выбираем найденный репозиторий " + nameRepo, () -> {
            $("a[href='/qa-guru/niffler']").click();
        });

        step("Нажимаем на Issue", () -> {
            $("#issues-tab").click();
        });

        step("Находим нужный Issue # " + NumberIssue, () -> {
            $(withText("#70")).should(Condition.exist);
        });
    }
}
