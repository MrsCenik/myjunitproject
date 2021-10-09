package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
        /*
        Create a class: ActionClass4
        Create test method : scrollUpDown()
        Go to amazon
        Scroll the page down
        Scroll the page up
         */

public class Day08_Actions4 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void scrollUpDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        /*
        PAGE_DOWN ==> scroll down the page
        ARROW_DOWN ==> scroll down the page

        PAGE_UP ==> scroll UP the page
        ARROW_UP ==> scroll UP the page
        */
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        /*ARROW_DOWN scrolls the page down less than PAGE_DOWN*/
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        /*PAGE_UP*/
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        /*ARROW_UP moves the page up a little bit*/
        actions.sendKeys(Keys.ARROW_UP).perform();
    }
    @After
    public void tearDown() {
//        driver.close(); //closes only active driver
        driver.quit(); //closes all open drivers
    }
}
