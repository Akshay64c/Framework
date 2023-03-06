package Resources;

import Pojo.LoginRequest;

public class ApiTestData {

    LoginRequest loginRequest = new LoginRequest();

    public LoginRequest loginBody(){
        loginRequest.setUserEmail("newfcid1903@gmail.com");
        loginRequest.setUserPassword("Honda@2022");
        return loginRequest;
    }

}
