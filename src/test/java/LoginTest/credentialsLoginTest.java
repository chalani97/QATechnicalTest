package LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class credentialsLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void commonSetUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://difc.globaltradingnetwork.com/web/login");
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }

    @Test
    public void emptyFieldLoginTest(){
        driver.findElement(By.id("LoginButton")).click();
        String errorEmpty = driver.findElement(By.className("login_error_msg")).getText();
        System.out.println("Empty field error - " + errorEmpty);
    }

    @Test
    public void randomCredentialsTest() throws InterruptedException {
        driver.findElement(By.id("form-input-live-u")).sendKeys("GMT97");
        driver.findElement(By.id("form-input-live-p")).sendKeys("20220426");
        driver.findElement(By.id("LoginButton")).click();
        String randomCredErr1 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        System.out.println("Random Credentials Error 1 - " + randomCredErr1);
        Thread.sleep(5000);
        String randomCredErr2 = driver.findElement(By.xpath("//div[@class='login_error_msg'][1]")).getText();
        System.out.println("Random Credentials Error 2 - " + randomCredErr2);
    }

    @AfterMethod
    public void afterAll() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
