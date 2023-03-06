//package API.Tests;
//
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import selenium.UI.Tests.TestComponents.Utils;
//
//import java.io.IOException;
//
//public class DeleteProductTest extends Utils {
//    @Test
//    public void deleteProductTest() throws IOException {
//        CreateProductTest createProductTest = new CreateProductTest();
//
//        if(!CreateProductTest.initialised){
//        createProductTest.createProductTest();
//        }
//
//
//        String token = LoginTest.token;
//        String productId = CreateProductTest.productId;
//
//        Response deleteProductResponse = deleteProductRequest(token)
//                .pathParam("productId" , productId)
//                .when().delete(getResourceURL("deleteProductResourceURL")+"/{productId}")
//                .then().log().all().extract().response();
//
//        String message = getJsonPath(deleteProductResponse,"message");
//        Assert.assertEquals("Product Deleted Successfully",message);
//    }
//}
