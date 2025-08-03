package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By eyeIcon = By.xpath("//img[@class='passowrd-visible']");
    private By loginButton = By.xpath("//button[@class='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement emailInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));

       
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", passwordInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", passwordInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", passwordInput, password);
    }



    public void clearEmail() {
        driver.findElement(emailField).clear();
    }

    public void clearPassword() {
        driver.findElement(passwordField).clear();
    }

    public String getEmailText() {
        return driver.findElement(emailField).getAttribute("value");
    }

    public String getPasswordText() {
        return driver.findElement(passwordField).getAttribute("value");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void togglePasswordVisibility() {
        WebElement eye = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(eyeIcon));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eye);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", eye);
    }


    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }
    public boolean isPasswordUnmasked() {
        return driver.findElement(passwordField).getAttribute("type").equals("text");
    }

    public boolean isPasswordMasked() {
        return driver.findElement(passwordField).getAttribute("type").equals("password");
    }

   

    public boolean isEyeIconVisible() {
        return driver.findElement(eyeIcon).isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
