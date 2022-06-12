package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
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
        $(".react-datepicker__day--014").click();

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
        $$(".table-responsive tr").filterBy(text("Student Name")).shouldHave(texts(
                "Artem Bobkov"));
        $$(".table-responsive tr").filterBy(text("Student Email")).shouldHave(texts(
                "abobkov@dnomads.pro"));
        $$(".table-responsive tr").filterBy(text("Gender")).shouldHave(texts(
                "Male"));
        $$(".table-responsive tr").filterBy(text("Mobile")).shouldHave(texts(
                "1234567899"));
        $$(".table-responsive tr").filterBy(text("Date of Birth")).shouldHave(texts(
                "14 October,1997"));
        $$(".table-responsive tr").filterBy(text("Subjects")).shouldHave(texts(
                "Physics"));
        $$(".table-responsive tr").filterBy(text("Hobbies")).shouldHave(texts(
                "Sports, Reading, Music"));
        $$(".table-responsive tr").filterBy(text("Picture")).shouldHave(texts(
                "example.png"));
        $$(".table-responsive tr").filterBy(text("Address")).shouldHave(texts(
                "Moscow"));
        $$(".table-responsive tr").filterBy(text("State and City")).shouldHave(texts(
                "Rajasthan Jaiselmer"));
    }
}