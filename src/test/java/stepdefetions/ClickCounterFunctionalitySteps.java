package stepdefetions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ClickCounterFunctionalitySteps {
    WebDriver driver ;
    @Before
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Given("I am on given url")
    public void Iamongivenurl(){
        driver.get("https://qaclickcounter.ccbp.tech/");
    }
    @When("I click on Clickme button")
    public void IclickonClickmebutton(){
        WebElement button = driver.findElement(By.className("button"));
        for (int i = 0; i < 5; i++){
            button.click();
        }
    }
    @Then("I should be get same count as how much i click")
    public void Ishouldbegetsamecountashowmuchiclick(){
        String expectedText = "5";
        String accualtext = driver.findElement(By.className("counter-value")).getText();
        Assert.assertEquals(expectedText,accualtext,"Not match count");
    }
    @After
    public void endup(){
        driver.quit();
    }
}
