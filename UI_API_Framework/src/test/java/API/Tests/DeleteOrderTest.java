//package API.Tests;
//
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import selenium.UI.Tests.TestComponents.Utils;
//
//import java.io.IOException;
//
//public class DeleteOrderTest extends Utils {
//
//    @Test
//    public void deleteOrder() throws IOException {
//    ViewOrderTest viewOrderTest = new ViewOrderTest();
//    DeleteProductTest deleteProductTest = new DeleteProductTest();
//
//    viewOrderTest.viewOrder();
//
//    Response deleteOrderResponse = deleteOrderRequest(LoginTest.token)
//            .pathParam("orderId", CreateOrderTest.orderId)
//            .when().delete(getResourceURL("deleteOrderResourceUrl")+"/{orderId}")
//            .then().log().all().extract().response();
//
//    String message = getJsonPath(deleteOrderResponse,"message");
//
////        System.out.println(message);
//        Assert.assertEquals(message,"Orders Deleted Successfully");
//
//        /** delete the product created after order is delete */
//        deleteProductTest.deleteProductTest();
//    }
//}
