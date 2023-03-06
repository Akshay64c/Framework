package selenium.UI.Tests.TestComponents;

import Resources.APITests.*;
import Resources.APITests.EcomAPIResources;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.cert.ocsp.Req;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Utils extends APITestData  {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public RequestSpecification reqLogin;
    public RequestSpecification createProduct;
    public RequestSpecification deleteProduct;
    public RequestSpecification createOrder;
    public RequestSpecification viewOrder;
    public RequestSpecification deleteOrder;
    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

        String dataFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\UITests\\Login.json";
        String jsonData = FileUtils.readFileToString(new File(dataFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getResourceURL(String resourceName){
        return EcomAPIResources.valueOf(resourceName).getResource();
    }

    public String getJsonPath(Response response,String key){
        String resp =response.asString();
        JsonPath js =new JsonPath(resp);
        return js.get(key).toString();
    }

    public RequestSpecification requestSpecification(String testType,String token){
        switch (testType){
            case "login":
                requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Content-Type","application/json").build();
                break;

            case "createProduct":
                requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Authorization",token).build();
                break;

            case "deleteProduct":
            case "createOrder":
            case "viewOrder":
            case "deleteOrder":
                requestSpecification = new RequestSpecBuilder().setBaseUri(getResourceURL("baseURI"))
                        .addHeader("Authorization", token)
                        .addHeader("Content-Type","application/json").build();
                break;

            default:
                System.out.println("Invalid test type passed");
        }
        return requestSpecification;
    }

    // Normal
//    public RequestSpecification loginRequest() throws IOException {
//        reqLogin = given().log().all().spec(requestSpecification("login","")).body(loginBody());
//        return reqLogin;
//    }

    //Cucumber
    public RequestSpecification loginRequest(String userName,String password) throws IOException {
        reqLogin = given().log().all().spec(requestSpecification("login","")).body(loginBody(userName,password));
        return reqLogin;
    }

    public RequestSpecification createProductRequest(String token, String name,String userId, String desc){
        createProduct = given().log().all()
                .spec(requestSpecification("createProduct",token))
                .param("productName",name)
                .param("productAddedBy",userId)
                .param("productCategory","Electronics")
                .param("productSubCategory","Mobile")
                .param("productPrice","8899")
                .param("productDescription",desc)
                .param("productFor","unisex")
                .multiPart("productImage",new File("C:\\Users\\002QSQ744\\Downloads\\IMG_0361.png"));

        return createProduct;
    }

    public RequestSpecification deleteProductRequest(String token) {
        deleteProduct = given().log().all().spec(requestSpecification("deleteProduct", token));
        return deleteProduct;
    }

    public RequestSpecification createOrderRequest(String token) {
        createOrder = given().log().all().spec(requestSpecification("createOrder", token));
        return createOrder;
    }

    public RequestSpecification viewOrderRequest(String token){
        viewOrder = given().log().all().spec(requestSpecification("viewOrder", token));
        return viewOrder;
    }

    public RequestSpecification deleteOrderRequest(String token){
        deleteOrder = given().log().all().spec(requestSpecification("deleteOrder", token));
        return deleteOrder;
    }
}
