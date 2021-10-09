package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstMavenClass {
    public static void main(String[] args) {
        //No longer System.setProperty("webdriver.chrome.driver" , "path of driver")

        //1.Step: Set up the chrome driver
        WebDriverManager.chromedriver().setup();

        //2.Step: Create driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3.Step: get to url
        driver.get("https://www.amazon.com");
        driver.close();
    }
}
