package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage login = new LoginPage(driver);
        login.clearEmail();
        login.clearPassword();
        Assert.assertTrue(login.getEmailText().isEmpty() && login.getPasswordText().isEmpty());
    }

    @Test
    public void testPasswordMaskedToggle() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("test123");
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked");
        login.togglePasswordVisibility();
        Assert.assertTrue(login.isPasswordUnmasked(), "Password should be unmasked after toggle");
    }


    @Test
    public void testInvalidLoginShowsError() {
        LoginPage login = new LoginPage(driver);
        login.enterEmail("invalid@user.com");
        login.enterPassword("wrongpassword");
        login.clickLogin();
    }

    @Test
    public void testUIElementsPresence() {
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isEyeIconVisible());
        Assert.assertTrue(login.isLoginButtonVisible());
    }
}
