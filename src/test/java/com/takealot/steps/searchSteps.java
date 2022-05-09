package com.takealot.steps;

import com.takealot.pages.CartPage;
import com.takealot.pages.HomePage;
import com.takealot.pages.ItemDescriptionPage;
import com.takealot.pages.SearchItemPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class searchSteps {

    @And("^User select \"([^\"]*)\"$")
    public void userSelect(String item) {
        new SearchItemPage().selectItem(item);
    }

    @And("^User adds product to cart$")
    public void userAddsProductToCart() {
        new ItemDescriptionPage().addToCart();
           }

    @And("^User click on basket button$")
    public void userClickOnCartButtonFromHomepage() {
        new SearchItemPage().userClickOnBasketButton();
    }

    @Then("^User can see the product/s inside the basket/cart$")
    public void userCanSeeTheProductSInsideTheBasketCart(DataTable table) {
        List<String> itemList = table.asList(String.class);
        for (String s : itemList) {
            Assert.assertTrue(new CartPage().basketCheck(s));
        }
    }

    @When("^User search for \"([^\"]*)\" in the search tab$")
    public void userSearchForInTheSearchBar(String item)  {
        new SearchItemPage().searchForItemInSearchBar(item);
    }

    @And("^User select \"([^\"]*)\" brand from list$")
    public void userSelectBrand(String itemName )  {
        new SearchItemPage().searchForBrandInField(itemName);
        new SearchItemPage().selectBrandNameBox();
    }

    @When("^User is on HomePage$")
    public void userIsOnHomePage(){
        String expectedText = new HomePage().verifyLink();
        Assert.assertEquals(expectedText,"Where's my order?");
    }

    @Then("^User can see all department list$")
    public void userCanSeeAllDepartmentList() {
    new HomePage().getListOfDept();
    }
}
