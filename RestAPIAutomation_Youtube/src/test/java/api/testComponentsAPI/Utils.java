package api.testComponentsAPI;

import api.Resources.APILogin;
import api.Resources.EComAPIResources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;


public class Utils extends APILogin {

    public static RequestSpecification requestSpecification;
    public RequestSpecification reqLogin;
    public RequestSpecification createProduct;
    public RequestSpecification deleteProduct;
    public RequestSpecification createOrder;
    public RequestSpecification viewOrderDetails;
    public RequestSpecification deleteOrder;
    public RequestSpecification masterRequests;

    public String getResourceURL(String resourceName){

        return EComAPIResources.valueOf(resourceName).getResource();
    }

    public String getJSONPath(Response response, String key){
        String resp =response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public RequestSpecification requestSpecification(String testType,String token){

        switch(testType){
            case "login":
                requestSpecification =new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Content-Type","application/json ").build();
                break;

            case "createProduct":
                requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Authorization",token).build();
                break;

            case "deleteProduct":
            case "createOrder":
            case "viewOrderDetails":
            case "deleteOrder":
                requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Content-Type","application/json")
                        .addHeader("Authorization",token)
                        .build();
                break;

            default:
                System.out.println("Invalid test type passed");
        }
        return requestSpecification;
    }
    public RequestSpecification loginRequest(){
        reqLogin = given().log().all().spec(requestSpecification("login","")).body(loginBody());
        return reqLogin;
    }

    public RequestSpecification createProductRequest(String token, String userID){
        createProduct = given().log().all()
                .spec(requestSpecification("createProduct", token))
                .param("productName","One Plus 9T")
                .param("productAddedBy",userID)
                .param("productCategory","Electronics")
                .param("productSubCategory","Mobile")
                .param("productPrice","8899")
                .param("productDescription","OPPO")
                .param("productFor","unisex")
                .multiPart("productImage",new File("C:\\Users\\002QSQ744\\Downloads\\IMG_0361.png"));

        return createProduct;
    }

    public RequestSpecification masterRequests(String requestType,String token){
        masterRequests = given().log().all().spec(requestSpecification(requestType,token));
        return masterRequests;
    }

    public RequestSpecification deleteProductRequest(String token){
        deleteProduct = given().log().all().spec(requestSpecification("deleteProduct",token));
        return deleteProduct;
    }

    public RequestSpecification createOrderRequest(String token){
        createOrder = given().log().all().spec(requestSpecification("createOrder",token));
        return createOrder;
    }

    public RequestSpecification viewOrderDetailsRequest(String token){
        viewOrderDetails = given().log().all().spec(requestSpecification("viewOrderDetails",token));
        return viewOrderDetails;
    }

    public RequestSpecification deleteOrderRequest(String token){
        deleteOrder = given().log().all().spec(requestSpecification("deleteOrder",token));
        return deleteOrder;
    }

}
