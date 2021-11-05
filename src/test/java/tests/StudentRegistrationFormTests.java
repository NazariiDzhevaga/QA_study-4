package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests  {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    String firstName = "Samuel",
            lastName = "Pitt",
            email = "aa@rr.com",
            number = "1234567890",
            gender = "Male",
            dateOfBirth = "23.10.1998",
            monthOfBirth = "May",
            yearOfBirth = "1988",
            dayOfBirth = "10",
            dayOfWeekOfBirth = "Tuesday",
            subject1 = "Chemistry",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            pictureName = "1.png",
            picturePath = "img/" + pictureName,
            currentAddress = "Montenegro 123",
            state = "Uttar Pradesh",
            city = "Merrut";

    @Test
    void successfulRefistationTest() {
        //Arrange / Given/ Open site
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //Act / When / Fill the form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        //$(byText(gender)).click();
        // $("[for=gender-radio-1]").click();
        //$("#gender-radio-1").doubleClick;

        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format("[aria-label='Choose %s, %s %sth, %s']",
                dayOfWeekOfBirth, monthOfBirth, dayOfBirth, yearOfBirth)).click();
//        $$(String.format(".react-datepicker__day--0%s", dayOfBirth))
//                .filter(not(cssClass("react-datepicker__day--outside-month")))
//                .first().click();
//        $$(".react-datepicker__day--0" + dayOfBirth)
//                .filter(not(cssClass("react-datepicker__day--outside-month")))
//                .first().click();
//        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
//        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").val(subject1).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();

        $("#uploadPicture").uploadFromClasspath(picturePath);
//        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));

        $("#currentAddress").val(currentAddress);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();


        //Assert / Then / verify successful form submit
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // $("#output").shouldHave(text(FirstName), text("aa@aa.com"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(number));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[text()='Picture']").parent().shouldHave(text(pictureName));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
        $x("//td[text()='State and City']").parent().shouldBe();

    }
}