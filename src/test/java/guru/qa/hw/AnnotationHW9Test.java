package guru.qa.hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AnnotationHW9Test {

    static {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void beforeEach() {
        open("https://github.com/");
    }

    @CsvSource(value = {
            "Selenide,   selenide/selenide",
            "JUnit 5,    junit-team/junit5"
    })
    @ParameterizedTest(name = "В результате поиска отображен {1} по тексту запроса {0}")
    void successSearchInGithubJunitSelenide(String value, String searchQuery) {
        $(".search-input").click();
        $("#query-builder-test").setValue(value).pressEnter();
        $$("[data-testid=results-list]").first().shouldHave(text(searchQuery));
    }
    @ValueSource(strings = {"java-faker",   "Selenide"})
    @ParameterizedTest(name = "В результате поиска отображен {0}")
    void successSearchInGithubJavaFaker(String value) {
        $(".search-input").click();
        $("#query-builder-test").setValue(value).pressEnter();
    }
    @CsvFileSource(resources = "/filesEx9/AnnotationHW9Test.csv")
    @ParameterizedTest(name = "В результате поиска отображен результат {1} по тексту запроса {0}")
    void successSearchInGithubUseCsvFileSource(String value, String searchQuery) {
        $(".search-input").click();
        $("#query-builder-test").setValue(value).pressEnter();
        $$("[data-testid=results-list]").first().shouldHave(text(searchQuery));
    }
}
