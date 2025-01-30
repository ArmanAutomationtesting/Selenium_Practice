//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SeleniumGetpriceListiFlipkart {
//
//    @Test
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.flipkart.com/");
//        WebElement element1 = driver.findElement(By.className("Pke_EE"));
//        element1.sendKeys("Iphone 15 pro max");
//        WebElement searchbutton = driver.findElement(By.xpath("//button[@class=\"_2iLD__\"]"));
//        searchbutton.click();
//
//        List<WebElement> prices = driver.findElements(By.xpath("//div[@class=\"Nx9bqj _4b5DiR\"]"));
//         List<Long> pricelist = new ArrayList<>();
//         for(int i = 0; i < prices.size(); i++){
//             System.out.println("Mobile Prices " + prices.get(i).getText());
////             String webElementPrice = prices.get(i).getText().replace("$", "").trim();
//             String prices2 = prices.get(i).getText();
//             String webElementPrice = prices2.replaceAll("[^0-9]", "");
//             pricelist.add(Long.parseLong(webElementPrice));
//         }
//
//         Long min = pricelist.getFirst();
//         Long max = pricelist.getFirst();
//
//         for(Long price1 : pricelist){
//             if(price1 < min){
//                 min = price1;
//             } else if (price1 > max) {
//                 max = price1;
//             }
//         }
//        System.out.println( "Max " + max);
//        System.out.println( "Min " + min);
//
//    driver.quit();
//    }
//}
