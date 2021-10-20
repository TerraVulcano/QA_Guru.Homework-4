package pageobjects;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaPracticeFormPage {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            userNumber = faker.number().digits(10),
            currentAddress = faker.address().fullAddress(),
            myDay = "11",
            myMonth = "4",
            myYear = "1988",
            subject = "Chemistry",
            hobby = "Music",
            picture = "vulcano.jpg",
            state = "Rajasthan",
            city = "Jaipur";

    public void openWebsite() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void simpleFillTest() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).doubleClick();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(myMonth);
        $(".react-datepicker__year-select").selectOptionByValue(myYear);
        $(".react-datepicker__day--0" + myDay).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
    }

    public void checkDataInForm() {
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text(myDay + " May," + myYear),
                text(subject),
                text(hobby),
                text(picture),
                text(currentAddress),
                text(state + " " + city));
    }
}
