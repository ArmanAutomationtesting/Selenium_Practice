package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class priceListandModelname {

    @Test
    public void new1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/search?q=Iphone+15+pro+max&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY&as-backfill=on");
//        driver.get("https://www.makemytrip.com/flight/search?itinerary=DEL-BLR-15/02/2025&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng");
        driver.manage().window().maximize();

        List<WebElement> modelname = driver.findElements(By.xpath("//*[@class=\"KzDlHZ\"]"));
       int modelSize = modelname.size();
                //(//*[@class="KzDlHZ"])[1]/parent::div/parent::div//div[@class="cN1yYO"]
        int count = 1;
        for(WebElement singleModelname : modelname){
            String first = "(//*[@class=\"KzDlHZ\"])[";
            String dynamicXpath = "(//*[@class=\"KzDlHZ\"])[" + count + "]/parent::div/parent::div//div[@class=\"Nx9bqj _4b5DiR\"]";
            WebElement mobileprice = driver.findElement(By.xpath(dynamicXpath));
            System.out.println(singleModelname.getText() + "---->" + mobileprice.getText());
            count++;
        }


    }
}
