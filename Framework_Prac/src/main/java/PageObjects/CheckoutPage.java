package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    WebElement submitButton;

    @FindBy(css ="input[placeholder='Select Country']")
    WebElement countryInputBox;

    @FindBy(xpath = "//button[contains(@class,'ta-item')]")
    List<WebElement> selectCountry;

    By countryResults = By.cssSelector(".ta-results");

    public void selectCountry(String countryName){
        countryInputBox.click();
        countryInputBox.sendKeys(countryName);
        waitForElementToAppear(countryResults);
        for(WebElement e:selectCountry){
            if(e.getText().equalsIgnoreCase(countryName)){
                e.click();
                break;
            }
        }
    }

    public ConfirmationPage submitOrder() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        Thread.sleep(2000);
        submitButton.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }

}
