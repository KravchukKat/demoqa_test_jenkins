package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultModalDialogComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            scrollToHobbiesWrapper = $("#hobbiesWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit"),
            modalDialog = $(".modal-dialog"),
            exampleModalSizesTitleLg = $("#example-modal-sizes-title-lg");

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultModalDialogComponent resultModalDialogComponent = new ResultModalDialogComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("document.querySelectorAll('#fixedban, footer, iframe').forEach(el => el.remove())");
        waitUntilIframesGone();

        return this;
    }

    private void waitUntilIframesGone() {
        for (int i = 0; i < 10; i++) {
            if ($$("iframe").isEmpty()) break;
            sleep(1000);
            executeJavaScript("document.querySelectorAll('iframe').forEach(el => el.remove())");
        }
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage scrollToElement() {
        scrollToHobbiesWrapper.scrollTo();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String img) {
        uploadPicture.uploadFromClasspath(img);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage submit() {
        submit.click();

        return this;
    }

    public RegistrationPage checkFormAppears() {
        modalDialog.should(appear);
        exampleModalSizesTitleLg.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage checkFormNotAppears() {
        modalDialog.shouldNot(appear);

        return this;
    }

    public RegistrationPage checkResultValue(String key, String value) {

        resultModalDialogComponent.checkResultValue(key, value);

        return this;
    }
}
