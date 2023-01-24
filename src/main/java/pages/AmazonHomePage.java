package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AmazonHomePage {

     WebDriver driver;
     By category_dropdown = By.id("searchDropdownBox");
     By search_input = By.id("twotabsearchtextbox");

    public AmazonHomePage(WebDriver driver){
       this.driver = driver;
   }
   //To select category
   public void Select_Categorylist(String category){

       WebElement ele = driver.findElement(category_dropdown);
       Select drop = new Select(ele);
       drop.selectByVisibleText(category);

}
    //To send keys to search box
    public void Select_Searchinput(String searchtext){
        driver.findElement(search_input).sendKeys(searchtext);


    }
    //To press Enter Key
    public void PressEnter(){
        driver.findElement(search_input).sendKeys(Keys.ENTER);

    }



}
