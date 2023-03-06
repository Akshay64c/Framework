package API.Tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import selenium.UI.Tests.TestComponents.Utils;

import java.io.IOException;

public class CreateProductTest extends Utils {

    static boolean initialised = false;
   public  static String productId;
  public  static String message;
    static String token;
    static String userId;
    static String name;
    static String desc;


    // Normal test
//    @Test
//    public void createProductTest() throws IOException {
//        LoginTest loginTest = new LoginTest();
//        if(!initialised){
////            loginTest.loginToApp();
//            initialised = true;
//        }
//
//        String token = loginTest.token;
//        String productName = "One Plus 11";
//        String userId = loginTest.userId;
//        String desc = "Mobile Phone";
//
//        Response createProductResponse = createProductRequest(token,productName,userId,desc)
//                .when().post(getResourceURL("createProductResourceURL"))
//                .then().log().all().extract().response();
//
//        productId = getJsonPath(createProductResponse,"productId");
//        message = getJsonPath(createProductResponse,"message");
////        System.out.println(message + " === " + productId);
//    }

    // Cucumber Test
    public void createProductTest(String productName, String description) throws IOException {
//        LoginTest loginTest = new LoginTest();
//        loginTest.loginToApp("loginResourceURL", "newfcid1903@gmail.com", "Honda@2022");

        token = LoginTest.token;
        userId = LoginTest.userId;
        name = productName;
        desc = description;
    }
    public void setCreateProductResponse(String endPoint){
        Response createProductResponse = createProductRequest(token,name,userId,desc)
                .when().post(getResourceURL(endPoint))
                .then().log().all().extract().response();

        productId = getJsonPath(createProductResponse,"productId");
        message = getJsonPath(createProductResponse,"message");
//        System.out.println(message + " === " + productId);
    }

}
