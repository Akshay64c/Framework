//package API.Tests;
//
//import POJO.CreateOrder;
//import POJO.LoginRequest;
//import POJO.OrderBody;
//import Resources.APITests.APITestData;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//import selenium.UI.Tests.TestComponents.Utils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CreateOrderTest extends Utils {
//
//    static String orderId;
//
//    @Test
//    public void createOrderTest() throws IOException {
//
//        CreateProductTest createProductTest = new CreateProductTest();
//        createProductTest.createProductTest();
//
//        OrderBody orderBody = new OrderBody();
//        orderBody.setCountry(APITestData.country);
//        orderBody.setProductOrderedId(createProductTest.productId);
//
//        List<OrderBody> orderList = new ArrayList<>();
//        orderList.add(orderBody);
//
//        CreateOrder createOrder = new CreateOrder();
//        createOrder.setOrders(orderList);
//
//        Response createOrderResponse = createOrderRequest(LoginTest.token)
//                .body(createOrder)
//                .when().post(getResourceURL("createOrderResourceUrl"))
//                .then().log().all().extract().response();
//
//        orderId = getJsonPath(createOrderResponse,"orders[0]");
//    }
//}
