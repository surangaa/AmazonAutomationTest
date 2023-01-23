package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AmazonHomePage;



public class BaseTest {

   public static WebDriver driver;
  public static String browserName=null;
    public static String url=null;

    @BeforeTest
    public void setUp(){
     PropertyFile.getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();



        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(url);
        }
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
        System.out.println("Test is completed");

}

}