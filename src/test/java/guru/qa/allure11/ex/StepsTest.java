package guru.qa.allure11.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void stepLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            //$("a[href=*'/eroshenkoam/allure-example']").click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();

        });

        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void annotatedStepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());


        WebStepsTest webStepsTest = new WebStepsTest();

        webStepsTest.openMainPage();
        webStepsTest.searchForRepository(REPOSITORY);
        webStepsTest.clickOnRepositoryLink(REPOSITORY);
        webStepsTest.openIssuesTab();
        webStepsTest.shouldSeeIssueWithNumber(ISSUE);

    }
}
