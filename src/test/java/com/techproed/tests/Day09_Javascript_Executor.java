package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day09_Javascript_Executor extends TestBase {

        /*
        JavaScript Executor can be used to handle some browser events
        -scroll up/down/right/left
        -scroll into in element
        -click
        -generate alert
        -change the color
        -...
         */
    //Creating javascript executor object
    JavascriptExecutor je = (JavascriptExecutor) driver;

    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
        //Given user is on the application url
        //Then verify the text "Recent Blog" is on the page

        //We will scroll down to this element
        WebElement resentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));

        //Creating javascript executor object
        JavascriptExecutor je = (JavascriptExecutor) driver;

        //Scrolling down to the element using scrollIntoView(true) method
        je.executeScript("arguments[0].scrollIntoView(true);",resentBlog);
        //Waiting for 3 second for the element text
        Thread.sleep(3000);
        Assert.assertEquals(resentBlog.getText(),"Recent Blog");



    }
}
