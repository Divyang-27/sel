import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BruteForceLoginTest {

    public static String van = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;

    @BeforeTest
    public void bt() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(van);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "credentialsProvider")
    public void tc(String username, String password) throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        
        Thread.sleep(2000);  // Pause to see the input before submission
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        
        // Wait and refresh after submission to test the next set of credentials
        Thread.sleep(3000); 
        driver.navigate().refresh();
    }

    @DataProvider
    public Object[][] credentialsProvider() {
        return new Object[][] {
            // Add more credentials to attempt brute force login
            new Object[] { "Admin", "admin123" },
            new Object[] { "User1", "wrongPassword" },
            new Object[] { "User2", "pass123" },
            new Object[] { "Admin", "wrongPass" }
            // Continue adding as many combinations as necessary
        };
    }
}

