import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
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
    @Test(priority = 1)
    public void HomePage(){

        // Test the heading texts of each section

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link active-nav-link']")));
        driver.findElement(By.xpath("//a[@class='nav-link active-nav-link']")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div[1]/ul/li[2]/a")).isDisplayed();

        // Test whether the play button is displayed or not

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/button")).isEnabled();

        // Test whether the Movies are displayed, in the corresponding movies sections

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/h1")).isDisplayed();

        // Test the Contact Us Section

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/p")).isDisplayed();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
