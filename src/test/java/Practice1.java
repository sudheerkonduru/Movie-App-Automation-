import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice1 {
    public static void main(String arg[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/?authuser=0");

//        driver.get("https://www.google.com/?authuser=0");

        WebElement SearchBox = driver.findElement(By.id("APjFqb"));
        SearchBox.sendKeys("Facebook");
        SearchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class= 'LC20lb MBeuO DKV0Md']")));

        driver.findElement(By.xpath("//h3[@class= 'LC20lb MBeuO DKV0Md']")).click();

        driver.findElement(By.id("email")).sendKeys("6304673460");
        driver.findElement(By.id("pass")).sendKeys("Sidhu@2442");

        driver.findElement(By.name("login")).submit();


    }
}
