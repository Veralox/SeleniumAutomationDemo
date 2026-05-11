package SIddharthArora.PageObjects;

import SIddharthArora.AbstractComponemts.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@placeholder='Select Country']")
    WebElement country;

    @FindBy (xpath = "//div[@class='actions']/a")
    WebElement submit;

    @FindBy (xpath = "//section[contains(@class , 'ta-result')]/button[2]")
    WebElement selectCountry;
//
    By results =By.cssSelector(".ta-results");

    public void selectCountry(String Country){
        country.sendKeys(Country);
        waitForElementToAppear(results);
        Actions action = new Actions(driver);
        action.moveToElement(selectCountry).click().perform();

    }
    public COnfirmationPage submitCheckout(){
        Actions action = new Actions(driver);
        action.moveToElement(submit).click().perform();
        COnfirmationPage cp =new COnfirmationPage(driver);
        return cp;
    }

}
