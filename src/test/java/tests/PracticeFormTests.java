package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Bobkov");
        $("#userEmail").setValue("abobkov@dnomads.pro");
        $("#userNumber").setValue("1234567899");
        $("#currentAddress").setValue("Moscow");

        // Subject
        $("#subjectsInput").sendKeys("Physics");
        $("#subjectsInput").pressEnter();

        // Filling date
        $("#dateOfBirthInput").click();
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
        $("#uploadPicture").uploadFromClasspath("example.png");

        // Submit
        $("#submit").click();

        // Should have
        $(".table-responsive").find(byText("Student Name")).closest("tr").shouldHave(
                text("Student Name"),
                text("Artem Bobkov")
        );
        $(".table-responsive").find(byText("Student Email")).closest("tr").shouldHave(
                text("Student Email"),
                text("abobkov@dnomads.pro")
        );
        $(".table-responsive").find(byText("Gender")).closest("tr").shouldHave(
                text("Gender"),
                text("Male")
        );
        $(".table-responsive").find(byText("Mobile")).closest("tr").shouldHave(
                text("Mobile"),
                text("1234567899")
        );
        $(".table-responsive").find(byText("Date of Birth")).closest("tr").shouldHave(
                text("Date of Birth"),
                text("14 October,1997")
        );
        $(".table-responsive").find(byText("Subjects")).closest("tr").shouldHave(
                text("Subjects"),
                text("Physics")
        );
        $(".table-responsive").find(byText("Hobbies")).closest("tr").shouldHave(
                text("Hobbies"),
                text("Sports, Reading, Music")
        );
        $(".table-responsive").find(byText("Picture")).closest("tr").shouldHave(
                text("Picture"),
                text("example.png")
        );
        $(".table-responsive").find(byText("Address")).closest("tr").shouldHave(
                text("Address"),
                text("Moscow")
        );
        $(".table-responsive").find(byText("State and City")).closest("tr").shouldHave(
                text("State and City"),
                text("Rajasthan Jaiselmer")
        );
    }
}