import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Misclennious {
    public static void main(String[] args) throws IOException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/guide/selenium-chrome-options#:~:text=Selenium%20ChromeOptions%20class%20allows%20you%20to%20modify%20and,or%20even%20running%20the%20browser%20in%20headless%20mode.");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scroll(0,100)");

        TakesScreenshot ts = (TakesScreenshot) driver;
       File file = ts.getScreenshotAs(OutputType.FILE);
        File filePaths = new File("C:\\Users\\ahmad\\IdeaProjects\\Selenium_Practice_new\\src\\test\\Screenshot\\Test2.jpg");
        FileUtils.copyFile(file,filePaths);


    }
}
