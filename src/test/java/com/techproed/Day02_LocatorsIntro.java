package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
        /*
                    Create a class : LocatorsIntro
                    Create main method and complete the following task.
                    user goes to http://a.testaddressbook.com/sign_in
                    Locate the elements of email textbox, password textbox, and signin button
                    Enter below username and password then click sign in button
                    Username :  testtechproed@gmail.com
                    Password : Test1234!
                    Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
                    Verify the Addresses and Sign Out  texts are displayed
                    Find the number of total link on the page
                    Sign out from the page
         */

public class Day02_LocatorsIntro {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
//        driver.close();
    }
    @Test
    public void locators(){
        driver.get("http://a.testaddressbook.com/sign_in");
//        driver
//                .findElement(By.id("session_email"))//Locating the element by id
//                .sendKeys("testtechproed@gmail.com");//typing in the element
        //OR
        WebElement emailBox=driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");
        //Password Element:
        driver.findElement(By.name("session[password]")).sendKeys("Test1234!");
        //Locationg sign in button and click on it
        driver.findElement(By.name("commit")).click();

        //Then verify that the expected user id  testtechproed@gmail.com (USE getText() method to get the text from the page)
        WebElement userId = driver.findElement(By.className("navbar-text"));
        System.out.println(userId); // [[ChromeDriver: chrome on MAC (b59635767b5be82d8771036691978b77)] -> class name: navbar-text]
        //getText(); returns the text of the web element. Return type is a string
        String userIdText =userId.getText();
        String expectedUseerId = "testtechproed@gmail.com";
        System.out.println(userIdText);//testtechproed@gmail.com

        Assert.assertTrue(userIdText.equals(expectedUseerId));
       //The text of Addresses link is Addresses
        WebElement addressesElement = driver.findElement(By.linkText("Addresses"));
        //isDisplayed() is used to verify if an element is on the page or not
        //Return tyope is boolean
        //Returns true if the element on the page
        Assert.assertTrue(addressesElement.isDisplayed());

        //Sign Out
        WebElement singOut= driver.findElement(By.partialLinkText("gn out"));//Will find Sing out
        Assert.assertTrue(singOut.isDisplayed());

        //What is the differences between linkText and partialLinkText?
        //linkText -> we must the entire text with extra spaces and all
        //partialLinkText -> we can give the entire text or part of the text

        //Find the number of total link on the page\
        //Lionks are created by a tag, so we can find all links by finding elements with a tag
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("The number of the links is "+allLinks.size()); //The number of the links is 3

        //Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

        //verify the sign out is successful
        Boolean isLogOut = driver
                                .getCurrentUrl()
                                .equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLogOut);


        driver.close();

    }
}
