package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day07_WindowHandleExample {
    /*
        Create a new Class Tests package: Day08_WindowHandleExample
        Method name:windowHandle
        Given user is on the https://the-internet.herokuapp.com/windows
        Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the “Click Here” link
        Then user verifies the new window title is “New Window”
        Then user verifies the text:  “New Window”
        When user goes back to the previous window and then verifies the title : “The Internet”
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
    public void windowHandle() {
        // Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        // Then user verifies the text : “Opening a new window”
        WebElement firstWindow = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        Assert.assertEquals("Opening a new window", firstWindow.getText());
        //Then user verifies the title of the page is “The Internet”
        String windowtitle = driver.getTitle();
        Assert.assertEquals("The Internet", windowtitle);
        //When user clicks on the “Click Here” link
        driver.findElement(By.linkText("Click Here")).click();
        //Then user verifies the new window title is “New Window”
        //DRIVER IS STILL ON THE WINDOW1

        //1. GET THE WINDOW 1 HANDLE
        String window1Handle = driver.getWindowHandle();

        //2. GET ALL WINDOWS HANDLES
        Set<String> allWindowsHandles = driver.getWindowHandles(); //allWindowsHandles has window1 and window2(This is the one I want to switch)

        //3. Switch to the window2 using window handle
        for (String eachWindowHandle : allWindowsHandles) {
            if (!eachWindowHandle.equals(window1Handle)) {
                driver.switchTo().window(eachWindowHandle);
                break;
            }
        }
        // Then user verifies the new window title is “New Window”
        Assert.assertEquals("New Window", driver.getTitle());
        // DRIVER IS NOW ON WINDOW2
        // DRIVER CAN SEE ALL ELEMENTS ON WINDOW2
        // BUT DRIVER CANNOT SEE WINDOW1 ELEMENTS NOW
        /*
         * driver.getWindowHandle();  ->>>>> returns the existing window
         * driver.getWindowHandles(); ->>>>> returns all windows
         * Note that we can not switch the specific window using index,...
         * Logic: Change the window if driver is not on window1
         * if driver is not on window1 : if (!eachWindowHandle.equals(window1Handle))
         * Then switch the other window : driver.switchTo().window(eachWindowHandle);
         */
       //Then user verifies the new window title is “New Window”
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window", window2Title);
       //Then user verifies the text: “New Window”
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3[.='New Window']")).getText());

       //GETTING WINDOW 2 HANDLE. SINCE DRIVER IS ON WINDOW2, THIS RETURNS WINDOW2 HANDLE
        String window2Handle = driver.getWindowHandle();

        //When user goes back to the previous window1 and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
        //Go back to window2
        driver.switchTo().window(window2Handle);
    }

    @After
    public void tearDown() {
//        driver.close(); //closes only active driver
        driver.quit(); //closes all open drivers
    }
}