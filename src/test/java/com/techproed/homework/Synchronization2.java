package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronization2 {
        /*
        Create a class:Synchronization2.
        Create a method: isEnabled
        Go to https://the-internet.herokuapp.com/dynamic_controls
        Click enable Button
        And verify the message is equal to “It's enabled!”
        And verify the textbox is enabled (I can type in the box)
        And click on Disable button
        And verify the message is equal to “It's disabled!”
        And verify the textbox is disabled (I cannot type in the box)
         */

        WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        }
    @Test
    public void isEnable(){
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement enableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(enableElement.getText().equals("It's enabled!"));
        WebElement enableTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(enableTextBox.isEnabled());

        driver.findElement(By.xpath("//button[.='Disable']")).click();
        WebElement disableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(disableElement.getText().equals("It's disabled!"));
        Assert.assertTrue(enableTextBox.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
