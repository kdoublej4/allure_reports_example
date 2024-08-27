package qaguru.qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $x("//span[contains(text(), 'Search or jump to...')]").click(); // Тут ===>
        $x("//input[@id='query-builder-test']").setValue("eroshenkoam/allure-example").submit();

        $x("//a[@href='/eroshenkoam/allure-example']").click();

        $x("//a[@id='issues-tab']").click();
        $x("//span[contains(text(), '#80')]").should(exist);
    }
}
