import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PopularPageTest {
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
    public void  PopularPageUI() {

        // Test whether the movies are displayed

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        Actions action = new Actions(driver);
        WebElement mouseover = driver.findElement(By.linkText("Popular"));
        mouseover.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        List<WebElement> movielistitems = driver.findElements(By.className("movie-icon-item"));
        int count = movielistitems.size();
        int expectedcount = 30 ;
        System.out.println(count);
        Assert.assertEquals(count, expectedcount);

    }
    @AfterMethod
    public void ending(){
        driver.quit();
    }
}
