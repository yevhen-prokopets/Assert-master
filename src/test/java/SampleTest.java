import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


import java.util.concurrent.TimeUnit;

public class SampleTest {
    WebDriver driver = new ChromeDriver();
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromdriver.exe");
        driver = new ChromeDriver();
    }

    public void login(){
        String login_url = "https://moodle.chnu.edu.ua/login/index.php";
        driver.get(login_url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"region-main\"]/div/div/div/div/div/div/div[2]/div[1]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("prokopets.yevhen@chnu.edu.ua");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Toradora1");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button")).click();
    }

    @Test
    public void dashboard(){
        driver.findElement(By.xpath("//*[@id=\"block-myoverview-60c625df4b2fd60c625ded344a6\"]/div[1]/div[1]/ul/li[4]/a"));
    }

    
    @AfterTest
    public void tearDown() {
        driver.quit();


    }

}
