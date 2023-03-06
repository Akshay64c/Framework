package API.Tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import selenium.UI.Tests.TestComponents.Utils;

import java.io.IOException;

public class LoginTest extends Utils {

    public static String token;
    public static String userId;
    public static String message;

    // Normal test
//    @Test
//    public void loginToApp() throws IOException {
//        Response loginResponse =loginRequest().when()
//                .post(getResourceURL("loginResourceURL")).then().log().all()
//                .extract().response();
//
//        token = getJsonPath(loginResponse,"token");
//        userId = getJsonPath(loginResponse,"userId");
//
////        System.out.println("Extracted -> ");
////        System.out.println(token);
////        System.out.println(userId);
//    }


    // Cucumber Test
    public void loginToApp(String endPoint, String userName, String password) throws IOException {
        Response loginResponse = loginRequest(userName, password).when()
                .post(getResourceURL(endPoint)).then().log().all()
                .extract().response();

        token = getJsonPath(loginResponse, "token");
        userId = getJsonPath(loginResponse, "userId");
        message = getJsonPath(loginResponse,"message");

//        System.out.println("Extracted -> ");
//        System.out.println(token);
//        System.out.println(userId);
//        System.out.println(message);
    }

}
