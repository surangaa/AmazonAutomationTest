package pages;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    WebDriver driver;

    By Unit_Price = By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[1]/div[5]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h5[1]/div[1]/div[1]/div[2]");

    By DetailsPage_title = By.id("productTitle");
    By Qty_dropdown = By.id("quantity");

    By BtnAddtoCart = By.xpath("//span[@id='submit.add-to-cart']");

    By BtnGotoCart = By.xpath("//span[@id='sw-gtc']");

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public Double Get_UnitPrice() {
        String unit_price = driver.findElement(Unit_Price).getText();
        unit_price = unit_price.replace("$","");
        Double finalNextPrice= Double.parseDouble(unit_price);

        return finalNextPrice;
    }

    public String Get_Title(){
        String PDPage_Prod_title = driver.findElement(DetailsPage_title).getText();
        return PDPage_Prod_title;
    }

//select product quantity as 2
    public void Select_quantity(String itemqty){
        WebElement ele1 = driver.findElement(Qty_dropdown);
        Select qty_dropdown = new Select(ele1);
        qty_dropdown.selectByVisibleText(itemqty);
    }

    //select "add to cart" button
    public void click_Addtocart(){
        driver.findElement(BtnAddtoCart).click();
    }

    //select "go to cart" button
    public void click_Gottocart(){
        driver.findElement(BtnGotoCart).click();
    }

    //handle the page not loading exception
    public boolean page_load(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(BtnAddtoCart));
            return true;
        }
        catch (TimeoutException ex){
            System.out.println("Product Details page is not loaded completely");
            return false;
        }
    }
}
