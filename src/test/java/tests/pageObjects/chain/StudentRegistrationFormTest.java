package tests.pageObjects.chain;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void successfulFillFormTest() {

        studentRegistrationFormPage
                .openPage()
                .fillForm()
                .checkData();

    }
}
