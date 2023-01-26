import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BrowserStart {
    /**
     * Настройки браузера и селенида
     */
    public void start() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 6000;
    }

    /**
     * Метод, который выполняется перед каждым тестом
     */
    @BeforeEach
    public void openBrowser() {
        start();
    }

    /**
     * Метод, который выполняется после каждого теста
     */
    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}

