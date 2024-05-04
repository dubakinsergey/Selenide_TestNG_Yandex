import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TestHomework {

    private YandexPage yandexPage;

    @BeforeClass
    public static void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }

    @Test
    public void userCanSearch() {
        yandexPage = new YandexPage();
        yandexPage.openPage();
        webdriver().shouldHave(url("https://ya.ru/"));
        yandexPage.enterSearchText("ОЦРВ");
        yandexPage.checkEnteredText("ОЦРВ");
        yandexPage.clickSearchButton();
        yandexPage.searchLinkSite("https://www.ocrv.ru/");
        switchTo().window(1);
        webdriver().shouldHave(url("https://www.ocrv.ru/"));
    }
}