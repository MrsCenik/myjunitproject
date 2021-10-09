package realestate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Realtor {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void xpathTest() {
        driver.get("https://www.realtor.com/");

        driver.findElement(By.xpath("//*[@id=\"searchbox-input\"]")).sendKeys("Houston, TX");
        driver.findElement(By.xpath("//button[@aria-label=\"Search\"][1]")).click();
        driver.findElement(By.xpath("//button[@class=\"rui__aq1664-1 iSEbxY rui-patterns__sc-qdt2qz-2 crPIXE\"][1]")).click();

    }
}
