package PageObjects;

import AbstractComponents.AbstractComponents;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By header = By.cssSelector("div.heading h1");

    @FindBy(css = "div.cartSection h3")
    List<WebElement> productAdded;

    @FindBy(css=".totalRow button")
    WebElement checkoutButton;


    public Boolean verifyProductAdded(String productName){

        waitForElementToAppear(header);
        Boolean match = productAdded.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckoutPage goToCheckout() throws InterruptedException {
            waitForElementToDisappear();
            checkoutButton.click();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            return checkoutPage;
        }
    }


