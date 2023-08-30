package guru.qa.allure11.hw;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsHWTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String nameRepo = "qa-guru/niffler";
    private static final int NumberIssue = 70;

    @Test
    public void searchIssueWithAnnotatedStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        StepsForAnnotatedSteps steps = new StepsForAnnotatedSteps();

        steps.openMainPageWithSearch();
        steps.searchForRepo(nameRepo);
        steps.chooseFoundRepo();
        steps.clickOnIssueTab();
        steps.searchOurIssueNumber(NumberIssue);


    }
}
