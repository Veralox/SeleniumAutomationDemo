package SiddharthAroraTest.Test;

import SIddharthArora.PageObjects.CartPage;
import SIddharthArora.PageObjects.ProductCatalogue;
import SiddharthAroraTest.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    String userName ="arorasiddharth9@gmail.com";
    String password ="Siddharth@Astha0512";
    String productName= "ZARA COAT 3";
    @Test
    public void LoginErroValidation() throws IOException {


        String inValidpassword ="Astha0512";
        lpage.loginApplication(userName,inValidpassword);
        String errorMsg=lpage.getErrorMessage();
        Assert.assertEquals("Incorrect email or password.",errorMsg);

    }

    @Test
    public void ProductErrorValidation() throws IOException {


        String invalidProductName= "ZARA COATE 3343";
        ProductCatalogue pc = lpage.loginApplication(userName,password);
        pc.addProductToCart(productName);
        CartPage cartPage = pc.goToCart();
        Boolean match =cartPage.verifyCartItems(invalidProductName);
        Assert.assertFalse(match);
    }


}
