package SiddharthAroraTest.Test;

import SIddharthArora.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {

        String userName ="arorasiddharth9@gmail.com";
        String password ="Siddharth@Astha0512";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        LandingPage landingPage = new LandingPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");

        driver.findElement(By.id("userEmail")).sendKeys(userName);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

        List<WebElement> productList = driver.findElements(By.xpath("//div[contains(@class , 'mb-3')]"));
        WebElement prod =productList.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        List<WebElement> cartItems =driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
        Boolean match =cartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
        Assert.assertTrue(match);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'subtotal')]/ul/li[3]/button")));
        driver.findElement(By.xpath("//div[contains(@class, 'subtotal')]/ul/li[3]/button")).click();

        driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("ind");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='actions']/a")));
        driver.findElement(By.xpath("//div[@class='actions']/a")).click();
        String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

        driver.quit();
    }
}
