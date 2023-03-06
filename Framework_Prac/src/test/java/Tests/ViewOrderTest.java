package Tests;

import TestComponents.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewOrderTest extends Utils {

    static String productName;
    static String orderId;

    @Test
    public void viewOrder(){
        LoginTest  loginTest= new LoginTest();

        CreateOrderTest createOrderTest = new CreateOrderTest();
        createOrderTest.createOrder();

        Response viewOrderResponse = viewOrderRequest(loginTest.token)
                .queryParam("id",createOrderTest.orderId)
                .when().get(getResourceUrl("viewOrderResourceUrl"))
                .then().log().all().extract().response();

         productName =getJsonPath(viewOrderResponse,"data.productName");
         orderId = getJsonPath(viewOrderResponse,"data._id");
        Assert.assertEquals("One Plus 7T",productName);
    }
}
