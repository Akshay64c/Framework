package api.Resources;

import api.Pojo.LoginRequest;

public class APILogin {
    LoginRequest loginRequest = new LoginRequest();

    //for api test
    public LoginRequest loginBody(){
        loginRequest.setUserEmail("newfcid1903@gmail.com");
        loginRequest.setUserPassword("Honda@2022");

        return loginRequest;
    }

//    public LoginRequest loginBody(String userName,String password){
//        loginRequest.setUserEmail(userName);
//        loginRequest.setUserPassword(password);
//
//        return loginRequest;
//    }
}
