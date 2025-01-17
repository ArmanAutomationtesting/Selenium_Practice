import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class seleniumSwitchTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        WebElement element1 = driver.findElement(By.className("Pke_EE"));
        element1.sendKeys("Iphone 15 pro max");
        WebElement searchbutton = driver.findElement(By.xpath("//button[@class=\"_2iLD__\"]"));
        searchbutton.click();

        String mainPage = driver.getWindowHandle();
        System.out.println(mainPage);

        WebElement iphoneLink = driver.findElement(By.xpath("//div[text()=\"Apple iPhone 16 Pro Max (White Titanium, 256 GB)\"]"));
        iphoneLink.click();

        Set<String> pages = driver.getWindowHandles();
        for(String page : pages){
            if(!page.equals(mainPage)){
                driver.switchTo().window(page);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        List<WebElement> element = driver.findElements(By.xpath("//li[@class=\"g11wDd\"]"));
        for(WebElement points : element){
            System.out.println(points.getText());
        }
        driver.quit();

    }

}

