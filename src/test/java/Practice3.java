import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3 {
    public static void main(String arg[]){
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).submit();

    }
}
