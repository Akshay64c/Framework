package Tests;

import Pojo.CreateOrder;
import Pojo.OrderDetails;
import TestComponents.Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderTest extends Utils {
    static String orderId;
    private static boolean initialised = false;
    @Test
    public void createOrder(){

        LoginTest  loginTest= new LoginTest();

        CreateProductTest createProductTest = new CreateProductTest();
        if(!initialised) {
            createProductTest.createProduct();
            initialised = true;
        }

       OrderDetails orderDetails = new OrderDetails();
       orderDetails.setCountry("Austria");
       orderDetails.setProductOrderedId(createProductTest.productId);

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails);

        CreateOrder createOrder = new CreateOrder();
        createOrder.setOrders(orderDetailsList);


        Response responseCreateOrder =createOrderRequest(loginTest.token).body(createOrder)
                .when().post(getResourceUrl("createOrderResourceUrl"))
                .then().log().all().extract().response();

        orderId = getJsonPath(responseCreateOrder,"orders[0]");
    }
}
