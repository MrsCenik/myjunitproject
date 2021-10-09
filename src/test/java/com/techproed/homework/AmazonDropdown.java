package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AmazonDropdown {
            /*
            Create a method dropdownTest
            Go to https://wwww.amazon.com
            Find the element of the dropdown element. Hint: By.id("searchDropdownBox")
            Print the first selected option and assert if it equals "All Departments"
            Select the 4th option by index (index of 3) and assert if the name is "Amazon Devices" .(after you select you need to use get first option method)
            Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options
            Print the total number of options in the dropdown
            Check if 'Appliances' is a dropdown options. Print true if "Appliances is an option. Print false otherwise
            BONUS: Check if the dropdown is in Alphabetical Order

             */
            WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.amazon.com/");
    }
    @Test
    public void dropdownTest(){
        WebElement dropdown = driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"));
        Select select = new Select(dropdown);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());



    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }
}
