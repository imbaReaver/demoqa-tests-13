package pages;

import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public AutomationPracticeFormPage openPage() {
       open("/automation-practice-form");
       // Remove ads and footer
       executeJavaScript("$('footer').remove()");
       executeJavaScript("$('#fixedban').remove()");
       return this;
   }
   public AutomationPracticeFormPage setFirstName(String value) {
       $("#firstName").setValue(value);
       return this;
   }
   public AutomationPracticeFormPage setLastName(String value) {
       $("#lastName").setValue(value);
       return this;
   }
   public AutomationPracticeFormPage setEmail(String value) {
       $("#userEmail").setValue(value);
       return this;
   }
   public AutomationPracticeFormPage setPhoneNumber(String value) {
       $("#userNumber").setValue(value);
       return this;
   }
    public AutomationPracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }
   public AutomationPracticeFormPage setGender(String value) {
       $("#genterWrapper").$(byText(value)).click();
       return this;
   }
   public AutomationPracticeFormPage setSubject(String value) {
       $("#subjectsInput").sendKeys(value);
       $("#subjectsInput").pressEnter();
       return this;
   }
   public AutomationPracticeFormPage setHobbies(String firstValue, String secondValue, String thirdValue) {
       $("#hobbiesWrapper").$(byText(firstValue)).click();
       $("#hobbiesWrapper").$(byText(secondValue)).click();
       $("#hobbiesWrapper").$(byText(thirdValue)).click();
       return this;
   }
    public AutomationPracticeFormPage setStateAndCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }
   public AutomationPracticeFormPage setPicture(String value) {
       $("#uploadPicture").uploadFromClasspath(value);
       return this;
   }
   public AutomationPracticeFormPage clickSubmit() {
       $("#submit").click();
       return this;
   }
   public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
       $("#dateOfBirthInput").click();
       calendarComponent.setDate(day, month, year);
       return this;
   }
    public AutomationPracticeFormPage checkResult (String label, String value) {
        resultsTableComponent.checkResult(label, value);
        return this;
    }

}
