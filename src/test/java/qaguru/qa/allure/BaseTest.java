package qaguru.qa.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("latest");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

//        Configuration.headless = false;
//        Configuration.browserSize = "1920x1080";
    }
}
