package stepdefetions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginFunctionalitySteps {
    WebDriver driver;
    @Before
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Given("I am on loginpage")
    public void Iamonloginpage(){
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
    }
    @When("I enter valid user name and password")
    public void Ientervalidusernameandpassword(){
        driver.findElement(By.id("username")).sendKeys("rahul");
        driver.findElement(By.id("password")).sendKeys("rahul@2021");
    }
    @And("I click on login button")
    public void Iclickonloginbutton(){
        driver.findElement(By.className("login-button")).submit();
    }
    @Then("I should be redirected to the homepage")
    public void Ishouldberedirectedtothehomepage(){
        String expectedurl = "https://rahulnxttrendz.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String accualurl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,accualurl,"Something went to worng");
    }
    @After
    public void endup(){
        driver.quit();
    }
}
