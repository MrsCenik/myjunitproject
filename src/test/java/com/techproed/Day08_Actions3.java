package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions3 {
    /*
        Create a class: Actions3
        Create test method : keysUpDown()
        Go to google/amazon
        Send iPhone X prices => convert small letter capital vice versa.
        Highlight the search box by double clicking
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void keysUpDown(){
       WebElement searchBox= driver.findElement(By.xpath("//input[@name='q']"));
//       searchBox.sendKeys("iPhone X price"); //We normally use that code to send key to the box
        Actions actions = new Actions(driver);
        actions
                .keyDown(searchBox, Keys.SHIFT) //press on shift button
                .sendKeys("iPhone X prices") //type on uppercase in the element
                .keyUp(searchBox, Keys.SHIFT) //unpress on shift button
                .sendKeys(" too expensive"+ Keys.ENTER) //type on lowercase in the element
                .perform();
    }
    @After
    public void tearDown() {
//        driver.close(); //closes only active driver
        driver.quit(); //closes all open drivers
    }
}
