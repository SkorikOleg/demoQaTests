package guru.qa.allure11.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;
import static org.openqa.selenium.By.linkText;

public class AttachmentsStepsTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void stepLambdaAttachmentsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void annotatedStepsAttachmentsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());


        WebStepsTest webStepsTest = new WebStepsTest();

        webStepsTest.openMainPage();
        webStepsTest.takeScreenShot();
    }
}
