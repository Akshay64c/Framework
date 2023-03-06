package StepDefinition;

import PageObjects.CartPage;
import PageObjects.CatalogPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import TestComponents.BaseComponents;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SubmitOrderStep extends BaseComponents {
    public CatalogPage catalogPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;

    @Given("user has opened the ECommerce Website")
    public void launchApplicationUrl() throws IOException {
        landingPage = launchApplication();
    }
    @Given("^user has logged in with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void loginToApplication(String email,String password) {
        catalogPage = landingPage.loginApplication(email, password);
    }

    @When("^user adds the product \"([^\"]*)\" to cart$")
    public void addProduct(String productName) throws InterruptedException {
        List<WebElement> products =catalogPage.getProductList();
        catalogPage.addProduct(productName);
    }

    @When("^submits the order for the product \"([^\"]*)\" for country \"([^\"]*)\"$")
    public void submitOrder(String productName,String countryName) throws InterruptedException {
        cartPage = catalogPage.goToCart();
        Boolean match = cartPage.verifyProductAdded(productName);
        Assert.assertTrue(match,productName);

        checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry(countryName);
    }
    @Then("^\"([^\"]*)\" message is displayed on the confirmation page$")
    public void confirmation_page(String expectedMessage) throws InterruptedException {
        confirmationPage = checkoutPage.submitOrder();
        String messageCaught = confirmationPage.getMessage();
        Assert.assertTrue(messageCaught.equalsIgnoreCase(expectedMessage));
    }

    @After
    public void quitBrowser(){
        tearDown();
    }
}
