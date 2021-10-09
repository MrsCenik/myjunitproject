package com.techproed;

import com.github.javafaker.Faker;
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

public class Day06_IFrame {
        /*
            Create a class: IFrameTest
            Create a method: iframeTest
            Go to https://the-internet.herokuapp.com/iframe
            Verify the Bolded text contains “Editor”
            Locate the text box
            Delete the text in the text box
            Type “This text box is inside the iframe”
            Verify the text Elemental Selenium text is displayed on the page
        */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        //Verify the Bolded text contains “Editor”
        String actualBoldedText = driver.findElement(By.xpath("//h3")).getText();
        String expected = "Editor";
        Assert.assertTrue(actualBoldedText.contains(expected));
        //Locate the text box
            //1.way: Switching to iframe by -index starts from 0
//        driver.switchTo().frame(0);
        /*
        2.way Switching iframe by id/name.
        This iframe has an id, then i canpass value of id and switch to teh iframe
         <iframe
         id="mce_0_ifr"
         frameborder="0"
         allowtransparency="true"
         title="Rich Text Area. Press ALT-0 for help."
         class="tox-edit-area__iframe"></iframe>
          */
        driver.switchTo().frame("mce_0_ifr");
        /*
         * 3.way Switching iframe by WebElement
         * */
//        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
//        driver.switchTo().frame(iframeElement);

        //NOTE: //p element is inside the iframe
        WebElement textBox =  driver.findElement(By.xpath("//p"));
           //clear() => delete existing text
        textBox.clear();
        //Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");
        //Verify the text Elemental Selenium text is displayed on the page
            //it is outside of the iframe
            //Switch to back the parent frame

        driver.switchTo().defaultContent();
        WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
