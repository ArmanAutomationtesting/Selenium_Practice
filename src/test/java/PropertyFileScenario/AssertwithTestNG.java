package PropertyFileScenario;

import com.aventstack.extentreports.utils.FileUtil;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.io.FileUtils;
import org.assertj.core.util.Streams;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AssertwithTestNG {
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fil = new FileInputStream("C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\java\\Test.properties");
        prop.load(fil);

        IntStream.rangeClosed(1, 3).forEach(i -> {
            String name = prop.getProperty("user" + i + ".name");
            String dep = prop.getProperty("user" + i + ".dep");
            System.out.println("Name" + i + ": " + name + ", Dep: " + dep);
        });
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
//        driver.findElement(By.name("pass")).sendKeys(prop.getProperty("password"));
////        Thread.sleep(5000);
//        driver.findElement(By.name("login")).click();
//
//        TakesScreenshot TS = (TakesScreenshot) driver; // Connverting WebDriver in to TakeScreenshot Interface
//        File fileSC = TS.getScreenshotAs(OutputType.FILE);
//
//        File file = new File("C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\Screenshot\\TestSS.png");
//        FileUtils.copyFile(fileSC,file);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scroll(0,1000)");






    }
}
