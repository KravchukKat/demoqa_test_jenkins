package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @Test
    @Tag("demoqa")
    void successfulRegistrationTest() {
        open("/automation-practice-form");
//        registrationPage.open()
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
//        registrationPage.removeBanners()
        $("#firstName").setValue("Alex");
//        registrationPage.setFirstName()
        $("#lastName").setValue("Egorov");
//        registrationPage.setLastName()
        $("#userEmail").setValue("alex@egorov.com");
//        registrationPage.setUserEmail()
        $("#genterWrapper").$(byText("Other")).click();
//        registrationPage.setGenter()
        $("#userNumber").setValue("8922775126");
//        registrationPage.setUserNumber()
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
//        registrationPage.setBirthDay()
        $("#subjectsInput").setValue("Math").pressEnter();
//        registrationPage.setSubjects()
        $("#hobbiesWrapper").$(byText("Sports")).click();
//        registrationPage.setHobbies()
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
//        registrationPage.setPicture()
        $("#currentAddress").setValue("Some street 1");
//        registrationPage.setAddress()
        $("#react-select-3-input").setValue("NCR").pressEnter();
//        registrationPage.setState()
        $("#react-select-4-input").setValue("Noida").pressEnter();
//        registrationPage.setCity()
        $("#submit").click();
//        registrationPage.submit()

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        registrationPage.checkFormAppears()
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alex Egorov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("alex@egorov.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8922775126"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 January,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Math"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("cat.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
//        registrationPage.checkResultValue()
    }
}

