import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginPageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeMethod
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @Test(priority = 1)
    public void LoginPageUI(){

        // Test whether the Website logo image is displayed,

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-website-logo")));
        WebElement logo = driver.findElement(By.className("login-website-logo"));
        logo.isDisplayed();

        // Test whether the Heading text is "Login"

        WebElement heading = driver.findElement(By.className("sign-in-heading"));
        String requriedHeading = "Login" ;
        String acctualHeading = heading.getText();
        Assert.assertEquals(requriedHeading, acctualHeading,"Heading Not Matched");

        // Test whether the Username label text is "USERNAME"

        WebElement Username = driver.findElement(By.className("input-label"));
        String requriedUsername = "USERNAME" ;
        String acctualUsername = Username.getText();
        Assert.assertEquals(requriedUsername, acctualUsername,"Username Not Matched");

        // Test whether the Password label text is "PASSWORD"

        WebElement Password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[2]/label"));
        String requriedPassword = "PASSWORD" ;
        String acctualPassword = Password.getText();
        Assert.assertEquals(requriedUsername, acctualUsername,"Password Not Matched");

        // Test the "Login" button

        WebElement Buttun = driver.findElement(By.className("login-button"));
        Buttun.isDisplayed();
    }
    @Test(priority = 2)
    public void LoginPageFunctionalities()  {

        //Test the login functionality with empty input fields

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p")));
        WebElement EroorMsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p"));
        String AcctualMsg = EroorMsg.getText();
        Assert.assertEquals(AcctualMsg, "*Username or password is invalid", "Error Msg Not Matching");

        // Test the login functionality with empty USERNAME
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2442");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p")));
        WebElement EroorMsg1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p"));
        String AcctualMsg1 = EroorMsg.getText();
        Assert.assertEquals(AcctualMsg, "*Username or password is invalid", "Error Msg Not Matching");

        // Test the login functionality with an empty PASSWORD

        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p")));
        WebElement EroorMsg3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p"));
        String AcctualMsg3 = EroorMsg.getText();
        Assert.assertEquals(AcctualMsg, "*Username or password is invalid", "Error Msg Not Matching");

        // Test the login functionality with Invalid Credentials (correct username and wrong password),
        //Correct Login Credentials: Username: "rahul", Password: "rahul@2021"

        driver.findElement(By.id("usernameInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@24423");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p")));
        WebElement EroorMsg4 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/p"));
        String AcctualMsg4 = EroorMsg.getText();
        Assert.assertEquals(AcctualMsg4, "*username and password didn't match", "Error Msg Not Matching");

        // Test the login functionality with Valid Credentials
        driver.findElement(By.id("usernameInput")).clear();
        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
        String expectedURL = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,currentUrl, "Faild to Navigate");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
