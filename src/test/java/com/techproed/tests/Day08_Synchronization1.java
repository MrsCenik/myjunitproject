package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day08_Synchronization1 extends TestBase {
    /*
    Create a class:Synchronization1. Create a method: synchronization1
    Go to https://the-internet.herokuapp.com/dynamic_controls
    Click on remove button
    And verify the message is equal to “It's gone!”
    Then click on Add button
    And verify the message is equal to “It's back!”
     */
    @Test
    public void synchronization1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //  Click on remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        //And verify the message is equal to “It's gone!”
//        WebElement goneElement= driver.findElement(By.xpath("//p[@id='message']"));
//        Assert.assertTrue(goneElement.isDisplayed());
        /*
        USING EXPLICIT WAIT
        1. Create a WebDriverWait object
        WebDriverWait  wait= new EsDriverWait(driver,10);

        2. Use wait object to wait for element
         */

        WebDriverWait wait = new WebDriverWait(driver,10);
        /*
        Explicit wait does the followings:
        1. Wait for By.xpatch("//p[@id='message']") up to 10 seconds
        2. If the xpath found in 10 seconds. the it is returned as WEBELEMENT
        3. If the element cannot be found in 10 seconds. step will fail.
         */

        WebElement goneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(goneElement.getText().equals("It's gone!"));

        // Then click on Add button
        driver.findElement(By.xpath("//button[.='Add']")).click();

        //And verify the message is equal to “It's back!”
//        WebElement goneElement1 =driver.findElement(By.xpath("//p[@id='message']"));
//        Assert.assertTrue(goneElement1.isDisplayed());

        WebElement addText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(addText.getText().equals("It's back!"));



    }
}
