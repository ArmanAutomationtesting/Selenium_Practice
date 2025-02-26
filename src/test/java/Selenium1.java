import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


    public class Selenium1 {


        @Description("Verify Ebay Print the prices (iMac)")
        @Test
        public void test_verify_print_imac_price() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("--start-maximized");



            ChromeDriver driver = new ChromeDriver(chromeOptions);
            driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // #gh-ac
            // input[id="gh-ac"] -> xpath -> //input[@id="gh-ac"]
            WebElement searchBox = driver.findElement(By.cssSelector("input[id='gh-ac']"));
            searchBox.sendKeys("macmini"); // Find the "macmini"

            WebElement searchBoxButton = driver.findElement(By.cssSelector("button[value='Search']"));
            searchBoxButton.click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Print all the titles
            List<WebElement> searchTitles  = driver.findElements(By.cssSelector(".s-item__title"));
            //div[@class="s-item__title"]/span -> 62
            List<WebElement> searchTitlesPrices = driver.findElements(By.cssSelector(".s-item__price"));
            // //span[@class="s-item__price"] -> 61


            // .s-item__title > 63 , .s-item__price ->
            // max -> loop where
            int size = Math.min(searchTitles.size(),searchTitlesPrices.size()); //61
            List<Double> priceList = new ArrayList<>();
            for(int i = 0; i<size ; i++ ){
                if (i > 4) {
                    System.out.println("Title: " + searchTitles.get(i).getText() + " || " + "Price: " + searchTitlesPrices.get(i).getText());
                    String webElementPrice = searchTitlesPrices.get(i).getText().replace("$", "").trim();
                    if (!webElementPrice.isEmpty()) {
                        priceList.add(Double.parseDouble(webElementPrice));
                        System.out.println("priceList => " + priceList);
                    }
                }
                // Max price or Min Price - Print it
            }
            Double min = priceList.get(0);
            Double max = priceList.get(size-1);

            for( Double price : priceList){
//                System.out.println("element => "+element);
//                String rateText = element.getText().replace("$", "").trim();
//                System.out.println("rateText => "+rateText);
//                double rate123 = Double.parseDouble(rateText);
                System.out.println("1 => "+ price );
                if (price < min){
                    min = price;
                } else if (price > max) {
                    max = price;
                }
            }
            System.out.println("Minimum rate is " + " = " + min);
            System.out.println("MAx rate is " + " = " + max);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            driver.quit();

        }
    }


