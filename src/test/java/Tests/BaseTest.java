package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {

   public static WebDriver driver;
  public static String browserName=null;
    public static String url=null;

    @BeforeTest
    public void setUp(){
     PropertyFile.getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            //download the webdriver binary for Chrome
            WebDriverManager.chromedriver().setup();
            //instiate the webdriver instance with the Chromedriver
            driver = new ChromeDriver();
            //navigate to URL
            driver.get(url);
            //maximize the browser window
            driver.manage().window().maximize();



        } else if (browserName.equalsIgnoreCase("firefox")) {


            //download the webdriver binary for Firefox
            WebDriverManager.firefoxdriver().setup();
            //instiate the webdriver instance with the firefoxdriver
            driver = new FirefoxDriver();
            //maximize the browser window
            driver.get(url);
        }
    }


    @AfterTest
    public void tearDown(){
        //close all browser windows
        driver.quit();
        System.out.println("Test is completed");

}

}