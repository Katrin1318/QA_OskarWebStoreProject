package com.telran.oskar.tests;

import com.telran.oskar.pages.HomePage;
import com.telran.oskar.pages.RegisterPage;
import com.telran.oskar.utils.DataProviders;
import com.telran.oskar.utils.PropertiesLoader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTests extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;

    public static String password = PropertiesLoader.loadProperty("valid.password");

    @BeforeMethod
    public void pageInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
    }

    @BeforeMethod
    public void preconditions() {
        homePage.clickOnLoginAndRegisterLink();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationWithInvalidEmail")
    public void newUserRegistrationWithInvalidEmailTest(String email) {
        homePage.clickOnLoginAndRegisterLink();
        registerPage.fillRegisterForm(email, password, password);
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }
}
