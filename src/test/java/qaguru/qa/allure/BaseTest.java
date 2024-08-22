package qaguru.qa.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }
}
