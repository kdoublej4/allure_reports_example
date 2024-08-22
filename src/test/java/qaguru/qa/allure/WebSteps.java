package qaguru.qa.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps extends BaseTest {
    @Step("Открываем главную страницу")
    public WebSteps openMainPage() {
        open("https://github.com");
        return this;
    }
    @Step("Ищем репозиторий")
    public WebSteps searchForRepository(String repo) {
        $x("//span[contains(text(), 'Search or jump to...')]").click();
        $x("//input[@id='query-builder-test']").setValue(repo).submit();
        return this;
    }
    @Step("Кликаем по ссылке репозитория")
    public WebSteps clickOnRepository(String repo) {
        $x("//a[@href='/" + repo + "']").click();
        return this;
    }
    @Step("Открываем таб Issues")
    public WebSteps openIssueTab() {
        $x("//a[@id='issues-tab']").click();
        return this;
    }
    @Step("Проверяем наличие Issue с номером")
    public WebSteps shouldSeeIssueWithNumber(int issue) {
        $x("//span[contains(text(), '#" + issue + "')]").should(exist);
        return this;
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}





