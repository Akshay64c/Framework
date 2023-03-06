package api.CucumberTests;

import api.testComponentsCucumber.Utils;
import io.restassured.response.Response;

public class CreateProduct extends Utils {
    public String productID;
    public String message;
    static boolean initialised = false;

    public void createProductTest(String token,String userID,String endPoint,String name, String desc){
//        Login login = new Login();
//        if(!initialised) {
//            login.loginToAPITest();
//            initialised = true;
//        }
        Response createProductResponse = createProductRequest(token, userID,name,desc)
                .when().post(getResourceURL(endPoint))
                .then().log().all().extract().response();

        productID = getJSONPath(createProductResponse,"productId");
        message = getJSONPath(createProductResponse,"message");
    }
}
