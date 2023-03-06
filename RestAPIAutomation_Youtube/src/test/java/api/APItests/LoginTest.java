package api.APItests;

import api.testComponentsAPI.Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginTest extends Utils {

    static String token;
    static String userID;
    static String loginMessage;

    @Test
    public void loginToAPITest(){

        Response loginResponse = loginRequest().when().post(getResourceURL("loginURL"))
                .then().log().all().extract().response();

        token = getJSONPath(loginResponse,"token");
        userID = getJSONPath(loginResponse,"userId");
        loginMessage = getJSONPath(loginResponse,"message");
 }
}
