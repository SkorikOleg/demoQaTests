package selenide.hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHW1Test {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void lookForSomeInGit() {

        // - Откройте страницу Selenide в Github
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".Box-sc-g0xbh4-0.kzrAHr").first().$("a").click();

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        //$("#wiki-pages-box").scrollIntoView("false");

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("@Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }"));
    }
}
