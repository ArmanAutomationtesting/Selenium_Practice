package Iframe;

//import com.codoid.products.fillo.Select;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class iFrame1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        driver.manage().window().maximize();

        int sizeFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println(sizeFrame);


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name=\"globalSqa\"]")));
       WebElement element =  driver.findElement(By.xpath("(//img[@class=\"attachment-portfolio-medium size-portfolio-medium wp-post-image jetpack-lazy-image jetpack-lazy-image--handled\"])[1]"));
       element.click();


//        Select drop = new Select(element);
//        drop.selectByIndex(0);

        System.out.println( driver.getTitle());

        driver.switchTo().defaultContent();

        System.out.println( driver.getTitle());
        String text = driver.findElement(By.xpath("//h1[text() = 'Frames And Windows']")).getText();
        System.out.println(text);


        Thread.sleep(5000);

        driver.quit();
    }
}
