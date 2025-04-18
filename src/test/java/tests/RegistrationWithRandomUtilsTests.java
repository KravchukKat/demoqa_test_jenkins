package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class RegistrationWithRandomUtilsTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @Tag("demoqa")
    @Owner("KravchukK")
    void successfulRegistrationTest() {

        step("Open page", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });

        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDay(day, month, year)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    .setPicture(picture)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .submit();
        });
        step("Verify results", () -> {
            registrationPage.checkFormAppears()
                    .checkResultValue("Student Name", firstName + " " + lastName)
                    .checkResultValue("Student Email", userEmail)
                    .checkResultValue("Gender", gender)
                    .checkResultValue("Mobile", userNumber)
                    .checkResultValue("Date of Birth", day + " " + month + "," + year)
                    .checkResultValue("Subjects", subjects)
                    .checkResultValue("Hobbies", hobbies)
                    .checkResultValue("Picture", picture)
                    .checkResultValue("Address", address)
                    .checkResultValue("State and City", state + " " + city);
        });
    }

    @Test
    @Tag("demoqa")
    @Owner("KravchukK")
    void successRegistrationRequiredFieldsTest() {

        step("Open page", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDay(day, month, year)
                    .setHobbies(hobbies)
                    .setAddress(address)
                    .submit();
        });
        step("Verify results", () -> {
            registrationPage.checkFormAppears()
                    .checkResultValue("Student Name", firstName + " " + lastName)
                    .checkResultValue("Student Email", userEmail)
                    .checkResultValue("Gender", gender)
                    .checkResultValue("Mobile", userNumber)
                    .checkResultValue("Date of Birth", day + " " + month + "," + year)
                    .checkResultValue("Hobbies", hobbies)
                    .checkResultValue("Address", address);
        });
    }

    @Test
    @Tag("demoqa")
    @Owner("KravchukK")
    void unsuccessfulRegistrationWithoutRequiredFieldsTest() {

        step("Open page", () -> {
            registrationPage.openPage()
                    .removeBanners();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .submit();
        });
        step("Open page", () -> {
            registrationPage.checkFormNotAppears();
        });
    }
}

