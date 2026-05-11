package SIddharthArora.PageObjects;

import SIddharthArora.AbstractComponemts.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//*[@class='cartSection']/h3")
    List<WebElement> cartItems;
    @FindBy (css = ".totalRow button")
    WebElement checkOut;


    public Boolean verifyCartItems(String productName)
    {
         Boolean match=cartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
         return match;
    }

    public CheckoutPage checOut(){
        Actions action = new Actions(driver);
        action.moveToElement(checkOut).click().perform();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

}
