package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Day08_TestBaseDemo extends TestBase {
    /*
    Create a class:TestBaseDemo
    Create two methods: test1, test2
    test1 search “porcelain teapot” on google
    Then verify page contains “porcelain teapot”
    ——————————-
    test2 search “porcelain teapot” on amazon
    Then verify page contains “porcelain teapot”
     */
    @Test
    public void test1(){
        driver.get("https://www.google.com");
//        If you see cookies then add this line
//        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
}
