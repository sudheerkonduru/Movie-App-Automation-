import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {
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
    public void TesttheMovieDetailsPage(){

        // Test the Search functionality by searching with some movie names and the count of movies displayed

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[2]/div/a/div/img")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[2]/div/a/div/img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[1]/button")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/button")).isDisplayed();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/h1")).isDisplayed();
    }
    @AfterMethod
    public void ending(){
        driver.quit();
    }
}
