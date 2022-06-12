package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestsWithPageObjects extends TestBase {

    @Test
    void successfulTest() {
        automationPracticeFormPage.openPage()
                .setFirstName("Artem")
                .setLastName("Bobkov")
                .setEmail("abobkov@dnomads.pro")
                .setPhoneNumber("1234567899")
                .setAddress("Moscow")
                .setDateOfBirth("14", "October", "1997")
                .setGender("Male")
                .setSubject("Physics")
                .setHobbies("Sports", "Reading", "Music")
                .setStateAndCity("Rajasthan", "Jaiselmer")
                .setPicture("example.png")
                .clickSubmit()
                .checkResult("Student Name", "Artem Bobkov")
                .checkResult("Student Email", "abobkov@dnomads.pro")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567899")
                .checkResult("Date of Birth", "14 October,1997")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "example.png")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "Rajasthan Jaiselmer");
    }
}