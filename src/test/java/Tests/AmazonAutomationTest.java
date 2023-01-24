package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.ProductCartPage;
import pages.ProductDetailsPage;
import pages.ProductListPage;


public class AmazonAutomationTest extends BaseTest{


    @Test
    @Parameters({"searchtext","itemqty","category"})
    public static void testCase1(String searchtext, String itemqty, String category){

//Amazon Home page workflow
        AmazonHomePage AHP = new AmazonHomePage(driver);
        Reporter.log("Amazon Home page is opened now");
        //select Books from Category list
        AHP.Select_Categorylist(category);
        PropertyFile.getImplicitlyWait();

        //Search for "Automation" in search box
        AHP.Select_Searchinput(searchtext);
        AHP.PressEnter();

        PropertyFile.getImplicitlyWait();

//Product List page workflow
        ProductListPage PLP = new ProductListPage(driver);
        Reporter.log("Amazon Product list page is opened now");
        //scroll page down
        PLP.ScrollPageDown();
        PropertyFile.getImplicitlyWait();

        //Select fourstar review filter
        PLP.Select_Review();
        PropertyFile.getImplicitlyWait();

        //Select language as "English"
        PLP.ScrollPageDown2();
        PLP.Select_Language();
        PropertyFile.getImplicitlyWait();

        //Get Book title of the second element in the list view and go to PDP page
       String product_title = PLP.Get_SecondElement();
       System.out.println(product_title);


//Product Detials page workflow

        ProductDetailsPage PDP = new ProductDetailsPage(driver);
        Reporter.log("Amazon Product detial page is opened now");
        if(PDP.page_load()){
            //Get unitprice
            System.out.println(PDP.Get_UnitPrice());
            Double UnitPrice = PDP.Get_UnitPrice();

            //Get the book title in PDP page
            String PDPage_Prod_title = PDP.Get_Title();
            //Verify the book title
            Assert.assertEquals(PDPage_Prod_title, product_title);

            //Select 2 items to buy
            PDP.Select_quantity(itemqty);

            //click "Add to cart" btn
            PDP.click_Addtocart();
            PropertyFile.getImplicitlyWait();

            //click "go to cart" btn
            PDP.click_Gottocart();
            PropertyFile.getImplicitlyWait();


//Product Cart Page workflow
            ProductCartPage PCP = new ProductCartPage(driver);
            Reporter.log("Amazon Product cart page is opened now");
            String PCP_Prod_title = PCP.validateProductname();
            //verify the book title
            Assert.assertEquals(PCP_Prod_title,product_title );

            PropertyFile.getImplicitlyWait();
            //verify the product Qty
            String Productcart_qty = PCP.validateProductqty();
            Assert.assertEquals(Productcart_qty,itemqty);

            //get total Price
            PropertyFile.getImplicitlyWait();
            Double productcart_total = PCP.validateTotalprice();

            //verify cart total price
            Double Expected_totalprice;
            Expected_totalprice = UnitPrice * 2;
            System.out.println(productcart_total);
            Assert.assertEquals(productcart_total,Expected_totalprice);

            //clear the cart
            PropertyFile.getImplicitlyWait();
            PCP.clearCart();

            //verify whether the cart is empty
            String Totalpriceafterdelete = PCP.VerifyEmptyCart();
            System.out.println(Totalpriceafterdelete);
            Assert.assertEquals(Totalpriceafterdelete,"$0.00");


        }

        else{
            Assert.fail("Page did not load");
            driver.quit();
           System.out.println("Test Aborted");
        }


    }
}
