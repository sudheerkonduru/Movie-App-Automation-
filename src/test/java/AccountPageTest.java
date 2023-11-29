import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    @BeforeMethod
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();

    }
    @Test
    public void UIelementsPresentOntheWebpage()   {

        // Test all the UI elements present on the web page.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/nav/div[2]/button[2]")));
        driver.findElement(By.xpath("/html/body/div/div/div/nav/div[2]/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-heading"))).isDisplayed();
        driver.findElement(By.className("logout-button")).isEnabled();
        driver.findElement(By.className("plan-paragraph")).isDisplayed();

        // Test the Logout functionality

        driver.findElement(By.className("logout-button")).click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String AcctualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,AcctualUrl,"Faild to navigate to Login page");

    }
    @AfterMethod
    public void ending(){
        driver.quit();
    }
}
