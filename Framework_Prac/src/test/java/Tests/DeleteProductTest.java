package Tests;

import TestComponents.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProductTest extends Utils {

    @Test
    public void deleteProduct(){
    LoginTest  loginTest= new LoginTest();

    CreateProductTest createProductTest = new CreateProductTest();
        if(!(createProductTest.initialised)) {
            createProductTest.createProduct();
            createProductTest.initialised = false;
        }

    Response deleteProductResponse = deleteProductRequest(loginTest.token)
            .pathParam("orderId",createProductTest.productId)
            .when().delete(getResourceUrl("deleteProductResourceUrl")+"/{orderId}")
            .then().log().all().extract().response();

    String message = getJsonPath(deleteProductResponse,"message");
    Assert.assertEquals("Product Deleted Successfully",message);

    }

}
