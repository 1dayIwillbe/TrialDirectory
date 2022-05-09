package com.takealot.pages;

import com.takealot.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchItemPage extends Utility {


    public SearchItemPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickSearch;

    @FindBy(id = "_undefined")
    WebElement brandsSearchField;

    @FindBy(xpath = "//div[@id='scroll-container']")
    WebElement brandResult;

    @FindBy(xpath = "//div[@class='grid-container search-listings-module_search-listings_2Lw_d']//div[@class='cell small-3']//div//a/h4")
    List<WebElement> allItems;

    @FindBy(xpath = "//button[contains(text(),'Load More')]")
    WebElement loadMoreButton;

    @FindBy(xpath = "//body/div[@id='shopfront-app']//a[@data-ref='add-to-cart-button']")
    WebElement addCartBtn;

    @FindBy(xpath = "//div[@class='mini-cart mini-cart-module_mini-cart_3_CNC']//button")
    WebElement basketButton;

    public void searchForItemInSearchBar(String searchItem) {
        new HomePage().acceptCookies();
        searchBar.clear();
        searchBar.sendKeys(searchItem);
        clickSearch.click();

    }

    public void searchForBrandInField(String brand) {
        waitUntilVisibilityOfElementLocated(By.id("_undefined"), 10);
        brandsSearchField.sendKeys(brand);
           }

    public void selectBrandNameBox() {
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@id='scroll-container']"), 10);
      brandResult.click();
    }

    public void selectItem(String item) {
        boolean trigger = true;
        while (true) {
            try {
               for (WebElement product : allItems) {
                    if (product.getText().contains(item)) {
                        moveToElementAndClick(product);
                        trigger = false;
                        break;
                    }
                }
                if (!trigger) {
                    break;
                }
               loadMoreButton.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("e");
            }
        }
    }


    public void userClickOnBasketButton() {
        basketButton.click();
    }

}


