package Selenium_Action;

import TestListeners.TestingOnListeners;
//import TestListeners.Testlisteners123;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


@Listeners(TestingOnListeners.class)
public class selenium_Action1 {

    WebDriver driver;

    @BeforeMethod
    public void webtable()  {
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

    }


    @AfterMethod
    public void tdown(){
        driver.quit();
    }





    @Test
    public void TestWebtable_MakeMyTrip() throws InterruptedException {
//        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));

        driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();

        WebElement from_city = driver.findElement(By.id("fromCity"));
        Actions actions = new Actions(driver);
        actions.moveToElement(from_city).click().build().perform();
        Thread.sleep(3000);
       driver.findElement(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li//p[contains(text(),'New Delhi')]"))
               .click();


         driver.quit();
    }

    @Test
    public void drop_Down() throws InterruptedException{
//        driver = new ChromeDriver();
//        driver.get("https://www.makemytrip.com/");
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();


        WebElement fromCity = driver.findElement(By.id("fromCity"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("del").perform();

//        actions.moveToElement(fromCity).contextClick();

//        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
//
//        for(WebElement e : list_auto_complete){
//            if(e.getText().contains("New Delhi")){
//                e.click();
//                break;
//            }
//        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.moveToElement(fromCity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

    }
}
