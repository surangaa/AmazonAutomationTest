package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Test {

   private WebDriver driver;
  public static String browserName=null;
    public static String url=null;

    @BeforeTest
    public void setUp(){
     PropertyFile.getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);


        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(url);

        }
    }

    @org.testng.annotations.Test
    public static void test(){
        System.out.println("hi");
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
        System.out.println("Test is completed");
}

}