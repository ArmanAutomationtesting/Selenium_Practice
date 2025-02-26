package Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
        driver.manage().window().maximize();

        driver.findElement(By.id("first_date_picker")).click();
        String monthName = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
        String yearName = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();

        while(!(monthName.equals("February") && yearName.equals("2027"))){
            driver.findElement(By.xpath("//span[text()='Next']")).click();
            monthName = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
            yearName = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();

        }
        driver.findElement(By.xpath("//a[text()='14']")).click();
    }
}

