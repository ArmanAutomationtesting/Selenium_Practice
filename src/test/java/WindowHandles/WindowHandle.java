package WindowHandles;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class WindowHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        driver.findElement(By.id("newTabBtn")).click();
       String main_Window = driver.getWindowHandle();
        System.out.println(main_Window);

        Set<String> windows = driver.getWindowHandles();
        for(String current_window : windows){
            if(!current_window.equals(main_Window))
                driver.switchTo().window(current_window);
        }

        driver.findElement(By.id("alertBox")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();


        driver.close();


        driver.switchTo().window(main_Window);
        System.out.println(driver.getTitle());

    }
}
