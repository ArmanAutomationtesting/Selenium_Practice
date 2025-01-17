import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumAlerts {


    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Alert with OK ']")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();


        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
        WebElement element = driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']"));

        element.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.alertIsPresent());

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();


        Assert.assertEquals(driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText(),"You pressed Ok");

        driver.quit();
    }
}
