package selenide.hw;

import com.demoqa.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHW2Test extends TestBase {

    @Test
    void useHoverToGit() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
    }

    @Test
    void dragAndDropTest (){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //$("#column-a").dragAndDropTo("#column-b");
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
