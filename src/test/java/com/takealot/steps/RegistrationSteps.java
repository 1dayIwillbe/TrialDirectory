package com.takealot.steps;

import com.takealot.pages.HomePage;
import com.takealot.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegistrationSteps {

    @Given("^User is on homepage and click on register button$")
    public void Userisonhomepageandclickonregisterbutton() {
        String expected = "Takealot.com: Online Shopping | SA's leading online store";
        String actual = new HomePage().acceptCookies();
        Assert.assertEquals(actual, expected);
        new HomePage().clickOnRegisterLink();
    }

    @When("^User fill registration page details$")
    public void userFillRegistrationPageDetails() {
        new RegisterPage().registrationPageFilling();
    }

    @And("^User clicks on Register Button$")
    public void userClicksOnRegisterButton() {
        new RegisterPage().clickOnRegisterButton();

    }

    @And("^User should continue shopping on user account page$")
    public void userShouldContinueShoppingOnUserAccountPage() {
        new RegisterPage().clickOnHereLink();
    }

    @Then("^User should get welcome text$")
    public void userShouldGetWelcomeText() {
        String exp = "Welcome to the TAKEALOT.com family!";
        String act = new RegisterPage().getConfirmationText();
        Assert.assertEquals(exp, act);
    }
}
