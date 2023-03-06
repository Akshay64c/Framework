package api.APItests;

import api.testComponentsAPI.Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateProductTest extends Utils {
    static String productID;
    static boolean initialised = false;

    @Test
    public void createProductTest(){
        LoginTest loginTest = new LoginTest();
        if(!initialised) {
            loginTest.loginToAPITest();
            initialised = true;
        }
        Response createProductResponse = createProductRequest(loginTest.token,loginTest.userID)
                .when().post(getResourceURL("createProductURL"))
                .then().log().all().extract().response();

        productID = getJSONPath(createProductResponse,"productId");
    }
}
