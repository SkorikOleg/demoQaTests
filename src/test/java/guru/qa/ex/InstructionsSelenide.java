package guru.qa.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class InstructionsSelenide {
    @Test
    void Instructions (){

        //$ ("#output").$ ("#name").shouldHave(text("")); - если нам необходимо использовать локатор
        //внутри родителя, то мы можем добавить вот так
        // $ ("#output #name") а можем через пробел указать

        $("#bumbum").parent(); //нужен для перехода к родителю div добавляем .parent() если нужен еще один переход к родителю
        // $("div").closest("h1")//нужен для поиска близжайшего элемента, если есть похожие выше по ветке
        $("").sibling(0); //нужен для поиска другого child элемента, расчет вправо
        $("").preceding(0); //нужен для поиска другого child элемента, расчет влево
        //cssSelector мы пишем "div" - если хотим смотреть на элемент, "." - если хотим на класс, "#" - если id
        //если пишем "div>div" - это первый ребенок дива, если пишем "div div" - это любой ребенок дива
        //что бы проверить уникальность элемента, нужно в консоли devTools пишу $$ ("") - внутри скобки класс, id, div
        $("#bu").shouldHave(exactText("Новый мир"));//exactText для точного поиска текста, text "Нов ир" - для похожего текста
        //$(".class.class") название класса. Пробелы в class означают подклассы class ="class classes" и в тесте пишем class.class

       // SelenideElement loginButton=$("#id").closest("h1"); когда необходимо дать значемое имя элементу
        // loginButton.click();
        // для конфига Gradle в test {systemProperty "chromeoptions.prefs", intl.accept_languages=en} нужен для правильного отображения языка в браузере
       //$$ команда ищет все элементы, $ - ищет первый
        //$(byTagAndText("strong", "Закрыть")).click(); необходим для поиска тега вместе с текстом
        //requierd - это подсказки в HTML 5, по ним можно проверять типтул
        //$().hover()
    }
}
