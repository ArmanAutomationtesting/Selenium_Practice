package MakemyTrip;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class findPriceOfAirline {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://makemytrip.com");
//        driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-15/02/2025&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
        driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();

//        driver.findElement(By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]")).clear();

       WebElement element = driver.findElement(By.xpath("//input[@id=\"fromCity\"]"));

       element.click();
       Thread.sleep(2000);
       WebElement element2 = driver.findElement(By.xpath("//div[@role=\"combobox\"]/input"));
       Thread.sleep(2000);
       element2.sendKeys("Chennai");
       Thread.sleep(2000);
       element2.sendKeys(Keys.ARROW_DOWN);
       element2.sendKeys(Keys.ENTER);
//      Actions actions = new Actions(driver);
//      actions.moveToElement((WebElement) By.xpath("//div[@role=\"combobox\"]/input")).click().sendKeys((WebElement) By.xpath("//div[@role=\"combobox\"]/input"),"Chennai").keyDown(Keys.ARROW_DOWN).build().perform();






        Thread.sleep(5000);
//      WebElement element =  driver.findElement(By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"]"));

//        element.click();



//        Thread.sleep(5000);
        driver.quit();

    }
}
