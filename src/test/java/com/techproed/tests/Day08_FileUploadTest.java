package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_FileUploadTest extends TestBase {
    /*
    Class Name: FileUploadTest
    Method Name: fileUploadTest
    When user goes to https://the-internet.herokuapp.com/upload
    When user selects an image from the desktop
    And click on the upload button
    Then verify the File Uploaded!  Message displayed
     */

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //Choose the file button
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));//We use sendKeys because this element is an 'input'

        //Getting the path of the home directory with JAVA
        String homePath = System.getProperty("user.home");//Users/ismailcenik
        String pathOfFlower = homePath+"/Desktop/flower.jpeg";

        Thread.sleep(5000);

        //Sending the path of the file
        chooseFileButton.sendKeys(pathOfFlower);
        //Click the upload button
        driver.findElement(By.id("file-submit")).click();

        //Then verify the File Uploaded!  Message displayed
        Assert.assertTrue(driver.findElement(By.xpath("//h3[. = 'File Uploaded!']")).getText().equals("File Uploaded!"));
    }
}
