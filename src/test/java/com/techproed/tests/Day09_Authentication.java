package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day09_Authentication extends TestBase {


    @Test
    public void authTest(){
//        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //https://username:password@URL
        //username: admin
        //password: admin
        //url: "https://the-internet.herokuapp.com/basic_auth"

        //URL FOR AUTH:
        //https://admin:admin@https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        boolean isDisplayed = driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).isDisplayed();

        Assert.assertTrue(isDisplayed);
    }
}
