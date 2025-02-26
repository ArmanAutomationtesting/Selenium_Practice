package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Static.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//div[@class=\"col-xs-10 col-xs-offset-2\"]//img[@id= \"angular\"]"));
        WebElement element2 = driver.findElement(By.xpath("//div[@class=\"dragged\"]"));
        actions.dragAndDrop(element1,element2).perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
