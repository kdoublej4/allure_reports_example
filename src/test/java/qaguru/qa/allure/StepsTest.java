package qaguru.qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $x("//span[contains(text(), 'Search or jump to...')]").click();
            $x("//input[@id='query-builder-test']").setValue(REPOSITORY).submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $x("//a[@href='/" + REPOSITORY + "']").click();
        });

        step("Открываем таб Issues", () -> {
            $x("//a[@id='issues-tab']").click();
        });

        step("Проверяем наличие Issue с номером " + ISSUE, () -> {
            $x("//span[contains(text(), '#" + ISSUE + "')]").should(exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .clickOnRepository(REPOSITORY)
                .openIssueTab()
                .shouldSeeIssueWithNumber(ISSUE);
    }
}




