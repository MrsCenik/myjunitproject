package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_FileDownloadTest extends TestBase {
    /*
    We can't test windows application with selenium. But we can use JAVA to test.
    We can use Java to check if a file exist on our computer or not
    System.getProperty("user.dir"); =>gives the path of the current folder
    System.getProperty("user.home"); =>gives you the user folder
    Files.exists(Paths.get(“path of the file”)); =>Checks if a file path exist on your computer or not
    We can use this Java concept to check if a downloaded file is in our download folder
     */

    /*
    Create a class:FileDownloadTest
    downloadTest()
    In the downloadTest() method, do the following test:
    Go to https://the-internet.herokuapp.com/download
    Download flower.png file
    Then verify if the file downloaded successfully
     */
    @Test
    public void fileDownloadTest(){
    driver.get("https://the-internet.herokuapp.com/download");
    driver.findElement(By.linkText("flower.jpeg")).click();
    }
}
