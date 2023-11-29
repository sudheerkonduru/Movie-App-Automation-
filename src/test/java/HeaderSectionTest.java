import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
public class HeaderSectionTest {
    public WebDriver driver;
    public WebDriverWait wait ;
    @BeforeMethod
    public void startup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qamoviesapp.ccbp.tech");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();
    }
    @Test(priority = 1)
    public void HeaderSectionUI(){
        // Test whether the Website logo is displayed

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div[1]/a/img")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div[1]/a/img")).isDisplayed();

        // Test the Navbar elements
        driver.findElement(By.xpath("//a[@class='nav-link active-nav-link']")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div[1]/ul/li[2]/a")).isDisplayed();

        //

    }
    @Test(priority = 2)
    public void HeaderSectionFunctionalities(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/h1")));
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/h1")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/h1")).isDisplayed();
    }
    @AfterMethod
    public void Teardown(){
        driver.quit();
    }
}
