package Tests;

import Pojo.LoginRequest;
import Pojo.LoginResponse;
import Resources.ApiTestData;
import TestComponents.BaseComponents;
import TestComponents.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class LoginTest extends Utils {

    static  String token;
    static  String userId;

    @Test
    public void loginToApp(){

        Response loginResponse = loginRequest().when().post(getResourceUrl("loginResourceUrl")).then()
                .log().all().extract().response();

        token = getJsonPath(loginResponse,"token");
        userId = getJsonPath(loginResponse,"userId");
    }
}
