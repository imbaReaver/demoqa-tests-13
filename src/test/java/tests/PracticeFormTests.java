package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    // Browser configuration
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        open("/automation-practice-form");

        // Remove ads and footer
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Filling textboxes
        $("[id = firstName]").setValue("Artem");
        $("[id = lastName]").setValue("Bobkov");
        $("[id = userEmail]").setValue("abobkov@dnomads.pro");
        $("[id = userNumber]").setValue("1234567899");
        $("[id = currentAddress]").setValue("Moscow");

        // Subject
        $("#subjectsInput").sendKeys("Physics");
        $("#subjectsInput").pressEnter();

        // Filling date
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1997");
        $(byText("14")).click();

        // Gender radio
        $("#genterWrapper").$(byText("Male")).click();

        // Checkboxes
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        // State and city
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaiselmer").pressEnter();

        // State and city
        //$("[id=uploadPicture]").uploadFile(new File("src/test/resources/example.png"));
        $("#uploadPicture").uploadFile(new File ("src/test/resources/example.png"));

        // Submit
        $("#submit").click();

        // Should have
        $(".modal-body").shouldHave(
                text("Artem Bobkov"),
                text("abobkov@dnomads.pro"),
                text("Male"),
                text("1234567899"),
                text("14 October,1997"),
                text("Physics"),
                text("Sports, Reading, Music"),
                text("example.png"),
                text("Moscow"),
                text("Rajasthan Jaiselmer")
        );
    }
}