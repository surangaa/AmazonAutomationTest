package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage {
    static WebDriver driver;

    By fourstar_Review = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[3]/ul/li[1]");
    By english_Checkbox = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]");

    By second_Product = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]");

//    By second_Product = By.xpath("//span[contains(text(),'The Robots Are Coming!: The Future of Jobs in the ')]");
    public ProductListPage(WebDriver driver){
        this.driver = driver;
    }


    public void ScrollPageDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    public void Select_Review(){
        driver.findElement(fourstar_Review).click();
    }


    public void Select_Language(){
        driver.findElement(english_Checkbox).click();
    }

    public String Get_SecondElement(){
       String product_title = driver.findElement(second_Product).getText();
       driver.findElement(second_Product).click();
        return product_title;

    }

    public void ScrollPageDown2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
    }

}
