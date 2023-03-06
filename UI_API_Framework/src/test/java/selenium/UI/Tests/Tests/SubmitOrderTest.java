package selenium.UI.Tests.Tests;

import PageObjects.CartPage;
import PageObjects.CatalogPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.UI.Tests.TestComponents.BaseComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseComponents {

    @Test(enabled = false)
    public void submitOrder() throws InterruptedException {
        String productName = "IPHONE 13 PRO";
        String actualMessage = "THANKYOU FOR THE ORDER.";

        CatalogPage catalogPage = landingPage.loginToApp("newfcid1903@gmail.com","Honda@2022");

        List<WebElement> products =  catalogPage.getProductList();
        catalogPage.addProduct(productName);

        CartPage cartPage = catalogPage.goToCart();
        Boolean match = cartPage.verifyProductAdded(productName);
        Assert.assertTrue(match,productName);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry("United States");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String messageCaught = confirmationPage.getMessage();
        Assert.assertTrue(messageCaught.equalsIgnoreCase(actualMessage));
    }

    @Test(dataProvider = "getData")
    public void submitOrderWithData(HashMap<String,String> inputData) throws InterruptedException {
        String userEmail = inputData.get("email");
        String password = inputData.get("password");
        String productName = inputData.get("product");
        String country = inputData.get("country");
        String actualMessage = "THANKYOU FOR THE ORDER.";

        CatalogPage catalogPage = landingPage.loginToApp(userEmail,password);

        List<WebElement> products =  catalogPage.getProductList();
        catalogPage.addProduct(productName);

        CartPage cartPage = catalogPage.goToCart();
        Boolean match = cartPage.verifyProductAdded(productName);
        Assert.assertTrue(match,productName);

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.setCountry(country);

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String messageCaught = confirmationPage.getMessage();
        Assert.assertTrue(messageCaught.equalsIgnoreCase(actualMessage));
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap();
        return new Object[][]{
                {data.get(0)},
                {data.get(1)}
        };

    }
}
