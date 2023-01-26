import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

class GmailTest extends BrowserSetup {

    private final static String URL = "https://gmail.com/";
    private final static String LOGIN = "test1337073@gmail.com";
    private final static String PASSWORD = "Test1337073tes";

    @Test
    public void checkGmail() {
        open(URL);
        $x("//input[@type='email']").shouldBe(visible).setValue(LOGIN);
        $(byText("Далее")).click();
        $x("//input[@type='password']").shouldBe(visible).setValue(PASSWORD);
        $(byText("Далее")).click();
        step("Проверка наличия активных ссылок \"Входящие, Отложенные, Черновики\"", () -> {
            $x("//a[@aria-label='Входящие']").shouldBe(enabled);
            $x("//a[@aria-label='Отложенные']").shouldBe(enabled);
            $x("//a[@aria-label='Черновики']").shouldBe(enabled);
        });
    }
}

