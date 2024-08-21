package qaguru.qa.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue в репозитории") // <== Определяет функциональность, к которой относится тест
    @Story("Создание Issue") // <== Описывает поведение или сценарий использования, который проверяет тест
    @Owner("eroshenkoam") // <== Указывает автора теста (кто его написал).
    @Severity(SeverityLevel.BLOCKER) // <== Указывает критичность теста
    @Link(value = "Testing", url = "https://testing.github.com") // <== Добавляет ссылку на внешний ресурс, например, на задачу или документацию.
    @DisplayName("Создание Issue для авторизованного пользователя") // <== Устанавливает понятное и человекочитаемое имя для теста, отображаемое в отчетах.
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );

        if (true) {
            Allure.feature("Issue в репозитории");
        } else {
            Allure.feature("Issue не в репозитории");
        }

        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner", "eroshenkoam");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}




