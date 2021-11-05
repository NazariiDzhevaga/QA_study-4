package pageObjects.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
private SelenideElement
        pageHeader = $(".practice-form-wrapper"),
        firstNameInput =$("#firstName") ;



public void checkPageHeader (String headerText){
    pageHeader.shouldHave(text(headerText));
}
public void setFirstName (String nameValue){
    firstNameInput.setValue(nameValue);
}

// $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    //$("#firstName").setValue(firstName);
}

