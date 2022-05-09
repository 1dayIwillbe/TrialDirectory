package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class ItemDescriptionPage extends Utility {


    public ItemDescriptionPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='shopfront-app']//a[@data-ref='add-to-cart-button']")
    WebElement addToCart;

    public void addToCart() {

        String parentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                moveToElementAndClick(addToCart);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentHandle);
    }


}
