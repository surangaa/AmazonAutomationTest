package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCartPage {
    WebDriver driver;

    By CP_Product_Title = By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/ul[1]/li[1]/span[1]/a[1]/span[1]/span[1]");

    By CP_Product_Qty = By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[2]");

    By Cart_Total_Price = By.xpath("//body[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/span[2]/span[1]");

    By Delete_Link = By.xpath("//body/div[@id='a-page']/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]");

    By Cart_TotalPrice = By.xpath("//body[1]/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/span[2]/span[1]");

    //Constructor that will be automatically called as soon as the object of the class is created
    public ProductCartPage(WebDriver driver){
        this.driver = driver;
    }

    public String validateProductname(){
        String CP_Product_title = driver.findElement(CP_Product_Title).getText();
        return CP_Product_title;

    }

    public String validateProductqty(){
        String CP_Product_qty = driver.findElement(CP_Product_Qty).getText();
        return CP_Product_qty;

    }

    public Double validateTotalprice(){
        String Cart_TotalPrice = driver.findElement(Cart_Total_Price).getText();
        Cart_TotalPrice = Cart_TotalPrice.replace("$","");
        Double finalPrice= Double.parseDouble(Cart_TotalPrice);

        return finalPrice;

    }

    public void clearCart(){
         driver.findElement(Delete_Link).click();

    }

    public String VerifyEmptyCart(){
        String Cart_Total_Price = driver.findElement(Cart_TotalPrice).getText();
        return Cart_Total_Price;

    }
}
