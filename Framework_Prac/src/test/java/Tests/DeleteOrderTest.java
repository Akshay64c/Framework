package Tests;

import TestComponents.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOrderTest extends Utils {

    @Test
    public void deleteOrder(){
        LoginTest  loginTest= new LoginTest();
        CreateOrderTest createOrderTest = new CreateOrderTest();

        ViewOrderTest viewOrderTest = new ViewOrderTest();
        viewOrderTest.viewOrder();

        Response deleteOrderResponse = deleteOrderRequest(loginTest.token)
                .pathParam("orderId",createOrderTest.orderId)
                .when().delete(getResourceUrl("deleteOrderResourceUrl")+"/{orderId}")
                .then().log().all().extract().response();

        String message = getJsonPath(deleteOrderResponse,"message");
        Assert.assertEquals("Orders Deleted Successfully",message);

        DeleteProductTest deleteProductTest = new DeleteProductTest();
        deleteProductTest.deleteProduct();
    }
}
