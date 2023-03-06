package Resources.APITests;


public enum EcomAPIResources {
    baseURI("https://rahulshettyacademy.com"),
    loginResourceURL("/api/ecom/auth/login"),
    createProductResourceURL("/api/ecom/product/add-product"),
    deleteProductResourceURL("/api/ecom/product/delete-product"),
    createOrderResourceUrl("/api/ecom/order/create-order"),
    viewOrderResourceUrl("/api/ecom/order/get-orders-details"),
    deleteOrderResourceUrl("/api/ecom/order/delete-order");

    private String resource;

    EcomAPIResources(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }
}
