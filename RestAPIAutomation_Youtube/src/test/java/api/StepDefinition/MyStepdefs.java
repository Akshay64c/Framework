package api.StepDefinition;


import api.CucumberTests.CreateProduct;
import api.CucumberTests.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.atp.Switch;
import org.testng.Assert;

public class MyStepdefs {
    Login login = new Login();
    CreateProduct createProduct = new CreateProduct();

    @Given("user logins to ECOM app via API")
    public void login() {
    }

    @When("^user hits the \"([^\"]*)\" endpoint with userName \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void loginAPI(String endPoint, String userName, String password ){
        login.loginToAPITest(endPoint,userName,password);
    }
    @Then("^\"([^\"]*)\" message is received at backend for \"([^\"]*)\"$")
    public void assertMessage(String expectedMessage, String testType) {
        String actualMessage = null ;

        switch(testType){
            case "loginTest":
                actualMessage = login.loginMessage;
                break;

            case "createProductTest":
                actualMessage = createProduct.message;
                break;

            default:
                System.out.println("Invalid test type");
        }

        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Given("^user wants to add new product \"([^\"]*)\" ,\"([^\"]*)\" ,\"([^\"]*)\"$")
    public void addNewProduct(String name,String desc, String endPoint) {
        loginAPI("loginURL","newfcid1903@gmail.com","Honda@2022");
        createProduct.createProductTest(login.token,login.userID,endPoint,name,desc);
    }
}
