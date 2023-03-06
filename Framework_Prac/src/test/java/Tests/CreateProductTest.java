package Tests;

import TestComponents.Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateProductTest extends Utils {
    static String productId;
    static boolean initialised = false;

    @Test
    public void createProduct(){
        LoginTest  loginTest= new LoginTest();
        if(!initialised) {
            loginTest.loginToApp();
            initialised = true;
        }

        Response product =  createProductRequest(loginTest.token,loginTest.userId)
                .when().post(getResourceUrl("createProductResourceUrl"))
                .then().log().all().extract().response();

        productId = getJsonPath(product,"productId") ;
    }
}
