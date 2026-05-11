package SiddharthAroraTest.StepDefination;

import SIddharthArora.PageObjects.*;
import SiddharthAroraTest.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepdefinationImpl extends BaseTest {

    public LandingPage lpage;
    public ProductCatalogue productCatalogue;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public COnfirmationPage cOnfirmationPage;

    @Given("I landed on Ecommerce Page")
    public void iLandedOnEcommercePage() throws IOException {

        lpage=launchApp();
    }

    @Given("^Logged in with (.+) and (.+)$")
    public void Loggedinwith(String username, String password) {

        productCatalogue = lpage.loginApplication(username,password);
    }

    @When("^I add the product (.+) to the cart$")
    public void iAddTheProductToTheCart(String productName) {
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void iCheckoutAndSubmitOrder(String orderName) {
        cartPage = productCatalogue.goToCart();
        Boolean match =cartPage.verifyCartItems(orderName);
        Assert.assertTrue(match);
        checkoutPage =cartPage.checOut();
        checkoutPage.selectCountry("india");
        cOnfirmationPage =checkoutPage.submitCheckout();
    }

    @Then("Verify the confimation message {string} is displayed")
    public void VerifyTheConfimationMessageIsDisplayed(String message) {

        String confirmMessage= cOnfirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
        driver.quit();
    }

    @Then("{string} message is displayed")
    public void VerifyTheMessageIsDisplayed(String message) {
        String errorMsg=lpage.getErrorMessage();
        Assert.assertEquals(message,errorMsg);
    }
}
