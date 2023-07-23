package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class Junit5Expamples {

    @BeforeAll //аннотация для запуста теста до все тестов
    static void beforeAll() { // с этой аннотацией всегда используется метод static
        System.out.println("beforeAll()");
        //new one comment
        Configuration.browser = "chrome"; //указание на конкретный запуск браузера
    }

    @AfterAll    //аннотация для запуска теста после всех тестов
    static void afterAll() {    //используется метод static
        System.out.println("afterAll()");
    }

    @BeforeEach
        //аннотация запука действий для каждого теста до их запуска
    void beforeEach() {
        open("https://www.google.com/");
        System.out.println("    beforeEach()");
    }

    @AfterEach
        //аннотация запука действий для каждого теста после их запуска
    void afterEach() {
        open("https://www.google.com/");
        System.out.println("    afterEach()");
    }


    @Test
    void firstTest() {
        System.out.println("        firstTest()");
    }
}
