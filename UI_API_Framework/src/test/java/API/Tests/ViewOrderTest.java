//package API.Tests;
//
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//import selenium.UI.Tests.TestComponents.Utils;
//
//import java.io.IOException;
//
//public class ViewOrderTest extends Utils {
//
//    @Test
//    public void viewOrder() throws IOException {
//
//        CreateOrderTest createOrderTest = new CreateOrderTest();
//        createOrderTest.createOrderTest();
//
//        Response viewOrderResponse = viewOrderRequest(LoginTest.token)
//                .queryParam("id",createOrderTest.orderId)
//                .when().get(getResourceURL("viewOrderResourceUrl"))
//                .then().log().all().extract().response();
//
//        String user = getJsonPath(viewOrderResponse,"data.orderBy");
//        String productId = getJsonPath(viewOrderResponse,"data.orderById");
//
//        System.out.println(user + " ===== "+productId);
//
//    }
//}
