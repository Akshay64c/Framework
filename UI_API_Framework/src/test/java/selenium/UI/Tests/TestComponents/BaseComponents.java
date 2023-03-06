package selenium.UI.Tests.TestComponents;

import PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseComponents extends Utils{

    public static String propertyFilePath;
    public static Properties properties;
    public static FileInputStream fis;
    public static WebDriver driver;
    public static String url;
    public LandingPage landingPage;


    public void loadPropertiesFile() throws IOException {

        propertyFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UITests\\Data.properties";
        properties = new Properties();
        fis = new FileInputStream(propertyFilePath);
        properties.load(fis);
    }

    public WebDriver initDriver() throws IOException {
        loadPropertiesFile();
        String browser = properties.getProperty("browser");
        url = properties.getProperty("url");

        if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initDriver();
        driver.get(url);
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}
