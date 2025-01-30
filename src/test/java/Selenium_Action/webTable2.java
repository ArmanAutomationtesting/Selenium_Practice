package Selenium_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class webTable2 {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }


    @Test
    public void webtable2method() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
//        driver.manage().window().maximize();
        int result = 0;
        List<WebElement> element1 = driver.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]/tbody/tr/td[1]"));
        System.out.println(element1.size());
        for (int i = 1; i <= element1.size(); i++) {
            result++;
        }
        assert result == 4;
    }

    @Test
    public void webtablemethod2(){
        List<WebElement> elements =  driver.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]/tbody/tr/th"));
        for(WebElement element : elements ){
            if(element.getText().equals("Burj Khalifa")){
               String element2 =  driver.findElement(By.xpath("//table[@class=\"tsc_table_s13\"]/tbody/tr[1]/td[3]")).getText();
                System.out.println(elements.get(0).getText() + "-->" + element2);
            }
        }

    }
}
