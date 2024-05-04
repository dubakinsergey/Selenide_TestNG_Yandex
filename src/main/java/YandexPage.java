import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexPage {

    private SelenideElement searchInput = $(byXpath("//input[@aria-label='Запрос']"));
    private SelenideElement searchButton = $(byXpath("//button[@type='submit']"));
    private final String URL = "https://ya.ru/";

    public void openPage() {
        open(URL);
    }

    public void enterSearchText(String text) {
        searchInput.setValue(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchLinkSite(String site) {
        $(byAttribute("href", site)).click();
    }

    public void checkEnteredText(String expectedText) {
        searchInput.shouldHave(value(expectedText));
    }
}