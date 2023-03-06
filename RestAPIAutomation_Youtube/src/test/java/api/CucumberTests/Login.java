package api.CucumberTests;

import api.testComponentsCucumber.Utils;
import io.restassured.response.Response;

public class Login extends Utils {

    public String token;
    public String userID;
    public String loginMessage;

    public void loginToAPITest(String endPoint, String userName, String password){

        Response loginResponse = loginRequest(userName,password).when().post(getResourceURL(endPoint))
                .then().log().all().extract().response();

        token = getJSONPath(loginResponse,"token");
        userID = getJSONPath(loginResponse,"userId");
        loginMessage = getJSONPath(loginResponse,"message");
     }
}
