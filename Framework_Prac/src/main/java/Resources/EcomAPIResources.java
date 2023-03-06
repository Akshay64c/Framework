package Resources;

public enum EcomAPIResources {
    baseURI("https://rahulshettyacademy.com"),
    loginResourceUrl("/api/ecom/auth/login"),
    createProductResourceUrl("/api/ecom/product/add-product"),
    createOrderResourceUrl("/api/ecom/order/create-order"),
    viewOrderResourceUrl("/api/ecom/order/get-orders-details"),
    deleteProductResourceUrl("/api/ecom/product/delete-product"),
    deleteOrderResourceUrl("/api/ecom/order/delete-order");

    private String resource;

    EcomAPIResources(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
