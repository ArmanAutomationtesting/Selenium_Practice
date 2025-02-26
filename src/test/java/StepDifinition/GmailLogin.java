package StepDifinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GmailLogin {

    WebDriver driver;

    @Given("User is on gmail log in")
    public void user_is_on_gmail_log_in() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("User enter {string}")
    public void user_enter_username(String username) {
        driver.findElement(By.id("email")).sendKeys(username);

    }
    @Then("User enter a password {string}")
    public void user_enter_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("pass")).sendKeys(password);
    }
    @When("User clicked on the Login button")
    public void user_clicked_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("login")).click();
    }
    @Then("User should properly landed on the Home page")
    public void user_should_properly_landed_on_the_home_page() throws InterruptedException {
        Thread.sleep(2000);
        // Write code here that turns the phrase above into concrete actions
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Facebook");
    }


    @After
    public void teardown(){
        driver.quit();
    }

}

