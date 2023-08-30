package guru.qa.allure11.hw;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForAnnotatedSteps {

    @Step("Открываем страницу с поиском")
    public void openMainPageWithSearch() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepo(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Выбираем найденный репозиторий {repo}")
    public void chooseFoundRepo() {
        $("a[href='/qa-guru/niffler']").click();
    }

    @Step("Нажимаем на Issue")
    public void clickOnIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Находим нужный Issue {issue}")
    public void searchOurIssueNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}
