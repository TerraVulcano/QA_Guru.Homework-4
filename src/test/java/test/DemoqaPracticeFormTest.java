package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageobjects.DemoqaPracticeFormPage;

public class DemoqaPracticeFormTest {

    pageobjects.DemoqaPracticeFormPage DemoqaPracticeFormPage = new DemoqaPracticeFormPage ();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void SimpleFillTest(){
        DemoqaPracticeFormPage.openWebsite();
        DemoqaPracticeFormPage.simpleFillTest();
        DemoqaPracticeFormPage.checkDataInForm();
    }
}
