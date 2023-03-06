package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".action__submit")
    WebElement placeOrderButton;

    @FindBy(css= "input[placeholder='Select Country']")
    WebElement countryInputBox;

    @FindBy(css ="button.ta-item")
    List<WebElement> countryList;

    By countryResults = By.cssSelector(".ta-results");

    public void setCountry(String countryName){
        countryInputBox.click();
        countryInputBox.sendKeys(countryName);
        waitForElementToAppear(countryResults);
        for (WebElement e : countryList){
            if(e.getText().equalsIgnoreCase(countryName)){
                e.click();
                break;
            }
        }
    }

    public ConfirmationPage submitOrder() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,400)");
        waitForElementToDissappear();
        placeOrderButton.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }
}
