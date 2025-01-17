import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebtable {

    WebDriver driver;

    @BeforeTest
    public void webtable() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }


    @Test
    public void open_Web_Table() throws InterruptedException{
//        driver = new ChromeDriver();
        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
        System.out.println(row);
      String first_part = "//table[@id=\"customers\"]/tbody/tr[";
      String second_part = "]/td[";
      String Third_part = "]";

      for(int i = 2; i<=row; i++){
          for (int j =2; j <=col; j++){
              String dynamic_Xpath = first_part + i + second_part + j + Third_part;
              String data = driver.findElement(By.xpath(dynamic_Xpath)).getText();
              System.out.println(data);
              if(data.contains("Helen Bennett")){
                  String Company_name = driver.findElement(By.xpath(dynamic_Xpath+"/preceding-sibling::td")).getText();
                  String Company_country = driver.findElement(By.xpath(dynamic_Xpath+"/following-sibling::td")).getText();

                  System.out.println("-------------------------");
                  System.out.println("Contact  == " + data);
                  System.out.println("company name === " + Company_name);
                  System.out.println("company country ===" + Company_country);
              }
          }
      }

    }

    @Test
    public void TestWebtable_Orange_HRM() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"]"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Thread.sleep(3000);
        int row = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"]")).size();
        System.out.println(row);
        int col = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"][1]//div[@class=\"oxd-table-cell oxd-padding-cell\"]")).size();
        System.out.println(col);
        String first = "//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"][";
        String second = "]//div[@class=\"oxd-table-cell oxd-padding-cell\"][";
        String third = "]";
        for(int i = 1; i<=row; i ++){
            for(int j = 1; j <= col; j++){
                String dynamic_Xpath = first + i + second + j + third;
                String data = driver.findElement(By.xpath(dynamic_Xpath)).getText();
                System.out.println(data);

                if(data.contains("Terminated")){
                   WebElement button =  driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']"));
                   Thread.sleep(2000);
                   button.click();
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("++++++++++++++++++Terminated is CLICKED+++++++++++++++++++++");

                   WebElement no_cancel = driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin\"]"));
                   no_cancel.click();
                    Thread.sleep(2000);
                    break;
                }
            }
        }
    }

    @AfterTest
    public void Close_browser(){
        driver.quit();
    }
}
