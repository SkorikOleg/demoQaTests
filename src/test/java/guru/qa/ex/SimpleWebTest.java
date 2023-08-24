package guru.qa.ex;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWebTest {
    static {
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        open("https://www.google.com/");
    }

    @ValueSource(//аннотация для простых/одиночных параметров с 1 аргументом
            strings = {"Selenide", "JUnit 5"}
    )

    /*@CsvSource(value = {//dataProvider для указания параметров с более 1 аргументом
            "selenide.org,    Selenide",
            "junit.org,       JUnit 5"
    },
            delimiter = '|')// это параметр разделителя для возможного использования запятой в качестве значения*/
    // @CsvFileSource (resources = "/AnnotationHW9Test.csv")//можно вынести в отдельный файл csv в resources
    @Tag("Блокер")
    @ParameterizedTest(name = "В поисковой выдачи в гугл присутствует урл {0} для запроса {1}")
        //параметризованный тест
    void successfulSearchTest(String url, String searchQuery) {
        $("[name=q]")
                .setValue(searchQuery)
                .pressEnter();
        $("[id=search]").shouldHave(text(url));
    }
}
