package api.APItests;

import api.testComponentsAPI.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOrderTest extends Utils {

    @Test
    public void deleteOrderTest(){
        ViewOrderDetailsTest viewOrderDetailsTest = new ViewOrderDetailsTest();
        DeleteProductTest deleteProductTest = new DeleteProductTest();

        viewOrderDetailsTest.viewOrderDetails();

        Response deleteOrderResponse = masterRequests("deleteOrder",LoginTest.token)
                .pathParam("orderId", CreateOrderTest.orderID)
                .when().delete(getResourceURL("deleteOrderURL")+"/{orderId}")
                .then().log().all().extract().response();

        String actualMessage = getJSONPath(deleteOrderResponse,"message");
        Assert.assertEquals("Orders Deleted Successfully",actualMessage);

        /*delete the product after deleting the order*/
        deleteProductTest.deleteProductTest();
    }
}
