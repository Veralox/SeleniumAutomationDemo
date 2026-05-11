package SiddharthAroraTest.Test;

import SIddharthArora.PageObjects.*;
import SiddharthAroraTest.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData",groups="Purchase")
    public void SubmitOrderTest(HashMap<String,String> input) throws IOException {

        ProductCatalogue pc = lpage.loginApplication(input.get("UserName"),input.get("Password"));
        pc.addProductToCart(input.get("ProductName"));
        CartPage cartPage = pc.goToCart();
        Boolean match =cartPage.verifyCartItems(input.get("ProductName"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage =cartPage.checOut();
        checkoutPage.selectCountry("india");
        COnfirmationPage cp =checkoutPage.submitCheckout();
        String confirmMessage= cp.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

    }
    @Test(dependsOnMethods = {"SubmitOrderTest"} , dataProvider = "getData")
    public void orderValidation(HashMap<String,String> input)
    {

        ProductCatalogue pc = lpage.loginApplication(input.get("UserName"),input.get("Password"));
        OrderPage orperpage= pc.goToOrders();
        Assert.assertTrue(orperpage.verifyOrderedItems(input.get("ProductName")));
    }


    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/SiddharthAroraTest/Data/PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};

    }
}
