package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Utility {


    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='grid-x']//h3")
    List<WebElement> totalItemInCart;

    public boolean basketCheck(String item) {
        boolean contains = false;
        for (WebElement e : totalItemInCart) {
            if (e.getText().contains(item)) {
                contains = true;
            }
        }
        return contains;
    }


}
