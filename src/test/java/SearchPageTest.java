import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest {
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
    public void SearchFunctionality(){

        // Test the Search functionality by searching with some movie names and the count of movies displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/nav/div[2]/button[1]")));
        driver.findElement(By.xpath("/html/body/div/div/div/nav/div[2]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        WebElement Searchbox = driver.findElement(By.id("search"));
        Searchbox.sendKeys("Avatar");
        driver.findElement(By.xpath("/html/body/div/div/nav/div[2]/div/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        driver.findElement(By.className("movie-image")).isDisplayed();
    }
    @AfterMethod
    public void ending() {
        driver.quit();
    }
}
