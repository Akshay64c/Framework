package StepDefinition;

import API.Tests.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.io.IOException;

public class MyStepDefinition {

    LoginTest login = new LoginTest();
    CreateProductTest createProduct = new CreateProductTest();
//    CreateOrderTest createOrder = new CreateOrderTest();
//    DeleteProductTest deleteProduct = new DeleteProductTest();
//    DeleteOrderTest deleteOrder = new DeleteOrderTest();
//    ViewOrderTest viewOrder = new ViewOrderTest();


    @Given("user logins to ECOM app via API")
    public void loginAPI() {
    }
    @When("^user (?:hits the|logins to ECOM app with) \"([^\"]*)\" endpoint with userName \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_hits_the_endpoint_with_user_name_and_password(String endPoint, String userName, String password) throws IOException {
        System.out.println("when");
        login.loginToApp(endPoint,userName,password);
    }
    @Then("^\"([^\"]*)\" message is received at backend for \"([^\"]*)\"$")
    public void validateMessage(String expectedMessage, String testType) {
        String actualMessage = null;

        switch (testType){
            case "loginTest":
                actualMessage = login.message;
                break;

            case "createProductTest":
                actualMessage = createProduct.message;
                break;

            default:
                System.out.println("Invalid test type");
        }
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Given("^user wants to create a new product \"([^\"]*)\",\"([^\"]*)\"$")
    public void createProduct(String productName, String description) throws IOException {
        createProduct.createProductTest(productName,description);
    }
    @When("^user hits the \"([^\"]*)\" endpoint$")
    public void user_hits_the_endpoint(String endpoint) {
        createProduct.setCreateProductResponse(endpoint);
    }

//    @Given("user logins to ECOM app with {string} endpoint with userName {string} and password {string}")
//    public void user_logins_to_ecom_app_with_endpoint_with_user_name_and_password(String string, String string2, String string3) {
//        System.out.println("given");
//    }
//    @When("^user (?:hits the|logins to ECOM app with) \"([^\"]*)\" endpoint with userName \"([^\"]*)\" and password \"([^\"]*)\"$")
//    public void user_hits_the_endpoint_with_user_name_and_password(String endPoint, String userName, String password) throws IOException {
//        System.out.println("when");
//        login.loginToApp(endPoint,userName,password);
//    }

}
