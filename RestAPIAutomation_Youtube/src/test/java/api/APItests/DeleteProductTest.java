package api.APItests;

import api.testComponentsAPI.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteProductTest extends Utils {

    @Test
    public void deleteProductTest(){
        CreateProductTest createProductTest = new CreateProductTest();
        if(!CreateProductTest.initialised){
            createProductTest.createProductTest();
        }


        Response deleteProductResponse = masterRequests("deleteProduct",LoginTest.token)
                .pathParam("productID", createProductTest.productID)
                .when().delete(getResourceURL("deleteProductURL")+"/{productID}")
                .then().extract().response();

        String message = getJSONPath(deleteProductResponse,"message");
        Assert.assertEquals("Product Deleted Successfully",message);

    }

}
