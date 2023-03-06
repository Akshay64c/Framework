package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage extends AbstractComponents {

    WebDriver driver;
    public CatalogPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".col-lg-4")
    List<WebElement> productList;
    @FindBy(css= "button[class*='btn-custom'][routerlink*='cart']")
    WebElement cartButton;


    By productsBy = By.cssSelector(".col-lg-4");
    By desiredProductBy = By.cssSelector("b");
    By addToCartButton = By.cssSelector("div.card-body button.w-10");

    By viewButton = By.cssSelector(".card-body button.w-40");
    By toastMessage = By.cssSelector("#toast-container");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return productList;
    }
    public WebElement getDesiredProduct(String productName){
        WebElement desiredProduct = getProductList().stream()
                .filter(product-> product.findElement(desiredProductBy).getText()
                        .equalsIgnoreCase(productName)).findFirst().orElse(null);

        return desiredProduct;
    }

    public void addProduct(String productName) throws InterruptedException {
        WebElement desiredProduct = getDesiredProduct(productName);
        desiredProduct.findElement(addToCartButton).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDissappear();
    }

    public CartPage goToCart(){
        cartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

}
