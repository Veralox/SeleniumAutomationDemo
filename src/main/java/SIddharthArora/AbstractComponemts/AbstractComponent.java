package SIddharthArora.AbstractComponemts;

import SIddharthArora.PageObjects.CartPage;
import SIddharthArora.PageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cart;
    @FindBy (xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement myOrders;


    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }


    public void waitForWebElementToBeClickAble(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));

    }

    public void waitForElementToDisaapear(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public CartPage goToCart()
    {
        cart.click();
        CartPage cartPage =new CartPage(driver);

        return cartPage;
    }
    public OrderPage goToOrders()
    {
        myOrders.click();
        OrderPage orderPage =new OrderPage(driver);

        return orderPage;
    }
}
