package TestComponents;

import PageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseComponents {

    public static Properties properties;
    public static String propertyFilePath;
    public static String dataFilePath;
    public static FileInputStream fis;
    public static WebDriver driver;
    public static String url;
    public LandingPage landingPage;


    public void loadPropertiesFile() throws IOException {
        propertyFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties";
        properties = new Properties();
        fis = new FileInputStream(propertyFilePath);
        properties.load(fis);
    }

    public WebDriver initializeDriver() throws IOException {

        loadPropertiesFile();
        String browser =properties.getProperty("browser");
        url = properties.getProperty("url");

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        dataFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\EcomApp.json";
        // read json to string
        String jsonContent = FileUtils.readFileToString(new File(dataFilePath),StandardCharsets.UTF_8);

        // convert string to hashmap
        // use JacksonData bind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }


    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        driver.get(url);
        landingPage = new LandingPage(driver);
        return landingPage;
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
