package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day04_GoogleSearch {
    /*
    Create a new class : GoogleSearchTest
Create main method and complete the following task.
When user goes to https://www.google.com/
Search for “porcelain teapot”
And print how many related results displayed on Google
google.comgoogle.com
Google
Search the world's information,
including webpages, images, videos and more.
Google has many special features to help you find exactly what you're looking for.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //ADDING IMPLICIT WAY
        //WAIT UP TO 30 second WHEN NEEDED
        //This means, if driver needs 1 sc wait, then wait will be only 1 second.
        //Why wait is need?
        //-page is slow because of images, videos, iframe
        //-internet is slow
        //-database is slow
        //local computer is slow
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void teaPotSearch() {
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("porcelain teapot"+ Keys.ENTER);
        String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText().substring(6,17);
        System.out.println(result);//18,800,000


    }
    @After
    public void tearDown(){
        driver.close();
    }
}
