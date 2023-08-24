package guru.qa.hw;

import guru.qa.ex.WebSmokeTest;
import org.junit.jupiter.api.*;

public class Simple9ExcTest {

    @Tag("smoke")//одиночный тэг
    @DisplayName("Positive login")
    @Test
    void loginTest() {
        System.out.println("Smoke Run");

    }

    @Disabled("Cause has bug")
    @Test
    void profileTest() {

    }

    @WebSmokeTest/*создание своей аннотации. @НаименованиеАннотации. Мет аннотация, позволяет прятать
 в кастомную анноатцию другие аннотации*/
    void simpleTest() {

        Assertions.assertTrue(3 > 2);
    }
}
