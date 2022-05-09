package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends Utility {

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "surname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "email2")
    WebElement reEnterEmail;

    @FindBy(id = "password")
    WebElement pssWordField;

    @FindBy(id = "password2")
    WebElement reEnterPassWordField;

    @FindBy(id = "telno1")
    WebElement mobileNoField;

    @FindBy(xpath = "//input[@name='registerButton']")
    WebElement registerButton;

    @FindBy(xpath ="//div[@id='welcome']/h3[contains(text(),'Welcome to the TAKEALOT.com family!')]")
    WebElement confirmationTextMessage;

    @FindBy(xpath = "//a[contains(text(),'here')]")
    WebElement clickOnHereLink;

    public String fName = getRandomString(7);
    public String lName = getRandomString(5);
    public String email = getRandomString(4) + "@hotmail.com";
    public String password = "Password234@";
    public String mobileNo= "07725843548";

    public void registrationPageFilling() {
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        emailField.sendKeys(email);
        reEnterEmail.sendKeys(email);
        pssWordField.sendKeys(password);
        reEnterPassWordField.sendKeys(password);
        mobileNoField.sendKeys(mobileNo);
    }
    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void clickOnHereLink() {
        clickOnHereLink.click();
    }

    public String getConfirmationText() {
        System.out.println(confirmationTextMessage.getText());
        return confirmationTextMessage.getText();
    }

}
