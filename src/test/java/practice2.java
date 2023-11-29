import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class practice2 {
    public static void main(String arg[]){
        WebDriver sasi = new ChromeDriver();
        sasi.manage().window().maximize();
        sasi.get("https://www.google.com/");
        WebDriverWait wait1 = new WebDriverWait(sasi, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
        WebElement searchBox = sasi.findElement(By.id("APjFqb"));
        searchBox.sendKeys("youtube");
        searchBox.submit();
        sasi.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();

        WebDriverWait wait = new WebDriverWait(sasi, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));

        WebElement search = sasi.findElement(By.name("search_query"));
        search.sendKeys("hell boys creations");
        search.submit();
        WebDriverWait wait3 = new WebDriverWait(sasi, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")));
        sasi.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();

    }
}
