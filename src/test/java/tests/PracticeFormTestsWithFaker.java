package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTestsWithFaker extends TestBase {

    @Test
    void successfulTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setPhoneNumber(testData.phone)
                .setAddress(testData.currentAddress)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setGender(testData.gender)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setStateAndCity(testData.state, testData.city)
                .setPicture(testData.picture)
                .clickSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
}