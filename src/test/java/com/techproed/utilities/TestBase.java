package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //Making TestBase abstract because we do not want to create an object of TestBase class
    //We want to use the objects or methods in this class by extending it

    protected WebDriver driver; //it should be protected or public to be accessible from different packages

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);//This must be used.This is better
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//for page load. Optional. Just to wait for page load.more specific.

    }
    @After
    public void tearDown(){
        driver.close();
    }


}
