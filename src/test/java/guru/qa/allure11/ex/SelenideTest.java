package guru.qa.allure11.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        //$("a[href=*'/eroshenkoam/allure-example']").click();

        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);



    }
}
