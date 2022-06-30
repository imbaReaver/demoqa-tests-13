package tests;

import com.codeborne.selenide.Configuration;
import data.TestData;
import org.junit.jupiter.api.BeforeAll;
import pages.AutomationPracticeFormPage;

public class TestBase {

    AutomationPracticeFormPage  automationPracticeFormPage = new AutomationPracticeFormPage();
    TestData testData = new TestData();
    // Browser configuration
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
