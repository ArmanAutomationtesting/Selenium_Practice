package Selenium_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class selenium_Action1 {

    WebDriver driver;

    @BeforeTest
    public void webtable() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

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
        List<WebElement> elements =  driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
        System.out.println(elements.size());
        for( WebElement element : elements){
            if (element.getText().contains("New Delhi")){
//                System.out.println(element.getText());
                element.click();
                break;
            }
        }
    }

    @Test
    public void drop_Down() throws InterruptedException{
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


    @AfterTest
    public void Close_browser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
