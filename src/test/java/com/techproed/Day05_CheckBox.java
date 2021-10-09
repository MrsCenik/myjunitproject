package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_CheckBox {
    /*
    Create a class : CheckBox
        Create test method and complete the following task.
        Go to https://the-internet.herokuapp.com/checkboxes
        Locate the elements of checkboxes
        Then click on checkbox1 if box is not selected
        Then click on checkbox2 if box is not selected
        Then verify that checkbox1 is checked.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void checkBox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
       //Then click on checkbox1 if box is not selected
       //isSelected() is used to check if checkbox or radio button is checked or unchecked.
       //returns true if checkbox os already selected. Returns false if it is not selected.
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
       // Then click on checkbox2 if box is not selected

        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
       // Then verify that checkbox1 is checked.
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

        }
    @After
    public void tearDown(){
        driver.close();
    }
}
