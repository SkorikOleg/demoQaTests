package guru.qa.allure11.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");

    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
        //$("a[href=*'/eroshenkoam/allure-example']").click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();

    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);

    }

    @Attachment(value = "ScreenShot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot() {//attachment всегда должен возвращать тип данных byte
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
