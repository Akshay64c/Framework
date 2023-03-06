package api.APItests;

import api.Pojo.CreateOrder;
import api.Pojo.OrderDetails;
import api.testComponentsAPI.Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderTest extends Utils {

    static String orderID;
    @Test
    public void createOrderTest(){
        CreateProductTest createProductTest = new CreateProductTest();
        if(!CreateProductTest.initialised) {
            createProductTest.createProductTest();
        }

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCountry("India");
        orderDetails.setProductOrderedId(createProductTest.productID);

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(orderDetails);

        CreateOrder createOrder = new CreateOrder();
        createOrder.setOrders(orderDetailsList);

        Response createOrderResponse = masterRequests("createOrder",LoginTest.token)
                .body(createOrder)
                .when().post(getResourceURL("createOrderURL"))
                .then().log().all().extract().response();

        orderID = getJSONPath(createOrderResponse,"orders[0]");
    }

}
