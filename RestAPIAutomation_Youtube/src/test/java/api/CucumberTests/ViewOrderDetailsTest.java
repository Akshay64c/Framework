//package api.CucumberTests;
//
//import api.testComponents.Utils;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class ViewOrderDetailsTest extends Utils {
//
//    static String productName;
//    static String orderID;
//    public void viewOrderDetails(){
//        CreateOrderTest createOrderTest = new CreateOrderTest();
//        createOrderTest.createOrderTest();
//
//        Response viewOrderDetailsResponse = viewOrderDetailsRequest(LoginTest.token)
//                .queryParam("id",createOrderTest.orderID)
//                .when().get(getResourceURL("viewOrderDetailsURL"))
//                .then().log().all().extract().response();
//
//        productName = getJSONPath(viewOrderDetailsResponse,"data.productName");
//        orderID = getJSONPath(viewOrderDetailsResponse,"data._id");
//        Assert.assertEquals("One Plus 9T",productName);
//    }
//}
