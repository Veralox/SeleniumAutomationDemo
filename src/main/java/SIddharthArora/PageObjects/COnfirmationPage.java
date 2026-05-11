package SIddharthArora.PageObjects;

import SIddharthArora.AbstractComponemts.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COnfirmationPage extends AbstractComponent {

    WebDriver driver;
    public COnfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".hero-primary")
    WebElement confirmationMessage;

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }
}
