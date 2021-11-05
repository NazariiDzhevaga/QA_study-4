package tests.pageObjects.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormPage {

    private SelenideElement
            pageHeader = $(".practice-form-wrapper"),
            firstNameInput =  $("#firstName");

    public void checkHeader(String headerText) {
        pageHeader.shouldHave(text(headerText));
    }

    public void setFirsName(String nameValue) {
        firstNameInput.setValue(nameValue);
    }



}
