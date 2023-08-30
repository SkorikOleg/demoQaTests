package guru.qa.allure11.ex;

import com.codeborne.selenide.Configuration;

import io.qameta.allure.*;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.story;


public class LabelsTest {

    static {
        Configuration.pageLoadStrategy = "eager";
    }
//Для новичков
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")//пользовательская история
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void labelsStaticTest() {

    }
//Для опытных
    @Test
    public void labelsDynamicTest() {
        Allure.getLifecycle().updateTestCase(t ->
                t.setName("Создание Issue для авторизованного пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
