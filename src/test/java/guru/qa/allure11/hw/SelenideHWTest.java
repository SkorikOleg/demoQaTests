package guru.qa.allure11.hw;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHWTest {
    static {
        Configuration.pageLoadStrategy = "eager";
    }
@Test
    public void checkIssueInRepository() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue("qa-guru/niffler").pressEnter();
        $("a[href='/qa-guru/niffler']").click();
        $("#issues-tab").click();
        $(withText("#70")).should(Condition.exist);
    }
}
