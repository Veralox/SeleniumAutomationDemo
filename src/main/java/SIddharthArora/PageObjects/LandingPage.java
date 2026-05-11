package SIddharthArora.PageObjects;

import SIddharthArora.AbstractComponemts.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
        //intitilation
    }

    //WebElement userEmail = driver.findElement(By.id("userEmail"));
     //pageFactory
    @FindBy (id="userEmail")
    WebElement userEmail;

    @FindBy (id="userPassword")
    WebElement password;

    @FindBy (id="login")
    WebElement Login;

    @FindBy (xpath="//div[contains(@class,'toast-message')]")
    WebElement errorMessage;
    //ng-tns-c4-30 toast-message ng-star-inserted
    //ng-tns-c4-53 toast-message ng-star-inserted



    public ProductCatalogue loginApplication(String email, String passw)
    {
        userEmail.sendKeys(email);
        password.sendKeys(passw);
        waitForWebElementToBeClickAble(Login);
        Login.click();
        ProductCatalogue pc = new ProductCatalogue(driver);
        return pc;
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");

    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        String errorMsg= errorMessage.getText();
        return errorMsg;
    }
}
