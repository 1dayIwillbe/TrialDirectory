package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[contains(text(),'Got it')]")
    WebElement cookiesButton;

    @FindBy(xpath = "//span[@class='heading icon-banner-module_heading_M8TlN']")
    WebElement textVerify;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registrationLink;

    @FindBy(xpath = "//div[@class='department-dropdown-module_dropdown-container_3fOaJ']//ul//li")
    List<WebElement> listOFDepartment;

    @FindBy(xpath = "//span[normalize-space()='All Books']")
    WebElement allBooks;

    public void clickOnRegisterLink() {
        registrationLink.click();
    }

    public String acceptCookies() {
        cookiesButton.click();
        return driver.getTitle();
    }

    public String verifyLink() {
        return textVerify.getText();
    }

    public void getListOfDept() {

        for (WebElement dept : listOFDepartment) {
            if (dept.getText().equals("Books & Courses")) ;
            dept.click();
            break;
        }
        moveToElementAndClick(allBooks);
    }


}
