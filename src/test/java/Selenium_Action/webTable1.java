package Selenium_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class webTable1 {

    WebDriver driver;

    @Test
    public void webtable1() {

        driver = new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();
        List<WebElement> row = driver.findElements(By.xpath("//table[@id=\"countries\"]/tbody/tr"));
        int WebSize = row.size();
        System.out.println(WebSize);


        for (int i = 2; i < WebSize; i++) {
            String first_path = "//table[@id=\"countries\"]/tbody/tr[";
            String second = "]td[";
            String Third = "]";
            String final_path = first_path + i + second + Third;
//            WebElement row1 = driver.findElement(By.xpath(final_path));
//            String column_name = column.getText();
            List<WebElement> column = driver.findElements(By.xpath("//table[@id=\"countries\"]/tbody/tr[2]/td"));
            int column_size = column.size();
//            System.out.println(column_size);
            for (int j = 2; j < column_size; j++) {
                String Column_xpath1st = "//table[@id=\"countries\"]/tbody/tr[";
                String Column_xpath2nd = "]/td[";
                String Third_columnpath = "]";
                String final_column = Column_xpath1st + i + Column_xpath2nd + j + Third_columnpath;
                WebElement columns = driver.findElement(By.xpath(final_column));
                int m = 0;
                if (columns.getText().equals("Antigua & Barbuda")) {
                    List<WebElement> siblings = driver.findElements(By.xpath(final_column + "//following-sibling::td"));
                    System.out.println("*****************************************************");
                    System.out.println(siblings.get(0).getText());
                    System.out.println(siblings.get(1).getText());
                    System.out.println(siblings.get(2).getText());
                    break;
                }
            }

//           // System.out.println(column_name);
        }

        driver.quit();
    }
}
