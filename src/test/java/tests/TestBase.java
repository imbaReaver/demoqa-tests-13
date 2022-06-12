package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.AutomationPracticeFormPage;

public class TestBase {

    AutomationPracticeFormPage  automationPracticeFormPage = new AutomationPracticeFormPage();

    // Browser configuration
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
