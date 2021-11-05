package tests.pageObjects.scenarios;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void successfulFillFormTest() {

        studentRegistrationFormPage.openPage();
        studentRegistrationFormPage.fillForm();
        studentRegistrationFormPage.checkData();
    }
}
