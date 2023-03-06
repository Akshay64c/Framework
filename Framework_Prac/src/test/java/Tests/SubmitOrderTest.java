package Tests;

import PageObjects.*;
import TestComponents.BaseComponents;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseComponents {

    @Test(dataProvider = "getData")
    public void submitOrder (HashMap<String,String> inputData) throws InterruptedException {

        String email = inputData.get("email");
        String password = inputData.get("password");
        String productName = inputData.get("product");
        String countryName = inputData.get("country");
        String actualMessage = "THANKYOU FOR THE ORDER.";

        CatalogPage catalogPage = landingPage.loginApplication(email,password);

        List<WebElement> products =catalogPage.getProductList();
        catalogPage.addProduct(productName);

        CartPage cartPage = catalogPage.goToCart();
        Boolean match = cartPage.verifyProductAdded(productName);
        Assert.assertTrue(match,productName);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry(countryName);

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String messageCaught = confirmationPage.getMessage();
        Assert.assertTrue(messageCaught.equalsIgnoreCase(actualMessage));
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap();
        return new Object[][]{
                {data.get(1)},
                {data.get(0)}
        };
    }
}
