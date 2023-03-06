package TestComponents;

import Resources.ApiTestData;
import Resources.EcomAPIResources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.bouncycastle.cert.ocsp.Req;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Utils extends ApiTestData {

    public static RequestSpecification requestSpecification;
    public RequestSpecification reqLogin;
    public RequestSpecification createProduct;
    public RequestSpecification createOrder;

    public RequestSpecification viewOrder;
    public RequestSpecification deleteOrder;
    public RequestSpecification deleteProduct;

    public String getResourceUrl(String resourceName){
        return EcomAPIResources.valueOf(resourceName).getResource();
    }

    public String getJsonPath(Response response, String key){
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public RequestSpecification requestSpecification(String testType,String token){

        if(testType.equalsIgnoreCase("login")){
            requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceUrl("baseURI"))
                    .addHeader("Content-Type","application/json").build();
        }
        else if (testType.equalsIgnoreCase("createProduct")) {
            requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceUrl("baseURI"))
                    .addHeader("Authorization",token)
                    .build();
        }
        else{
            requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceUrl("baseURI"))
                    .addHeader("Content-Type","application/json")
                    .addHeader("Authorization",token)
                    .build();
        }
        return requestSpecification;
    }

     public RequestSpecification loginRequest(){
        reqLogin = given().log().all().spec(requestSpecification("login","")).body(loginBody());
        return reqLogin;
    }

    public RequestSpecification createProductRequest(String token,String userId){

        createProduct=  given().log().all()
                .spec(requestSpecification("createProduct",token))
                .param("productName","One Plus 7T")
                .param("productAddedBy",userId)
                .param("productCategory","Electronics")
                .param("productSubCategory","Mobile")
                .param("productPrice","8899")
                .param("productDescription","One Plus")
                .param("productFor","unisex")
                .multiPart("productImage",new File("C:\\Users\\002QSQ744\\Downloads\\image (1).png"));

        return createProduct;
    }

    public RequestSpecification createOrderRequest(String token){
        createOrder = given().log().all().spec(requestSpecification("createOrder",token));
        return createOrder;
    }

    public RequestSpecification viewOrderRequest(String token){
        viewOrder = given().log().all().spec(requestSpecification("viewOrder",token));
        return viewOrder;
    }

    public RequestSpecification deleteOrderRequest(String token){
        deleteOrder = given().log().all().spec(requestSpecification("deleteOrder",token));
        return deleteOrder;
    }

    public RequestSpecification deleteProductRequest(String token){
        deleteProduct =given().log().all().spec(requestSpecification("deleteProduct",token));
        return deleteProduct;
    }

}
