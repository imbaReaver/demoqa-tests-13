package tests;

import org.junit.jupiter.api.Test;

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
                .setHobbies("Sports")
                .setStateAndCity("Rajasthan", "Jaiselmer")
                .setPicture("example.png")
                .clickSubmit()
                .checkResult("Student Name", "Artem Bobkov")
                .checkResult("Student Email", "abobkov@dnomads.pro")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567899")
                .checkResult("Date of Birth", "14 October,1997")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "example.png")
                .checkResult("Address", "Moscow")
                .checkResult("State and City", "Rajasthan Jaiselmer");
    }
}