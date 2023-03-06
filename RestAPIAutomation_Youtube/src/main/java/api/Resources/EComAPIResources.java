package api.Resources;

public enum EComAPIResources {
    baseURI("https://rahulshettyacademy.com"),
    loginURL("/api/ecom/auth/login"),
    createProductURL("/api/ecom/product/add-product"),
    createOrderURL("/api/ecom/order/create-order"),
    viewOrderDetailsURL("/api/ecom/order/get-orders-details"),
    deleteOrderURL("/api/ecom/order/delete-order"),
    deleteProductURL("/api/ecom/product/delete-product");

    private String resource;

    EComAPIResources(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
