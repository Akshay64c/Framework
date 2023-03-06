package Resources.APITests;

import POJO.LoginRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class APITestData  {

    LoginRequest loginRequest = new LoginRequest();
    static String userEmail;
    static String userPassword;
   public static String country;
    public static List<HashMap<String, String>> getJsonDataToMap1() throws IOException {

        String dataFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\UITests\\Login.json";
        String jsonData = FileUtils.readFileToString(new File(dataFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    // Normal Test
//    public LoginRequest loginBody() throws IOException {
//        List<HashMap<String,String>> data = getJsonDataToMap1();
//        userEmail = data.get(0).get("email");
//        userPassword = data.get(0).get("password");
//        country = data.get(0).get("country");
//
//        loginRequest.setUserEmail(userEmail);
//        loginRequest.setUserPassword(userPassword);
//        return loginRequest;
//    }

    // CucumberTest
    public LoginRequest loginBody(String userEmail,String userPassword) throws IOException {
       loginRequest.setUserEmail(userEmail);
        loginRequest.setUserPassword(userPassword);
        return loginRequest;
    }

}
