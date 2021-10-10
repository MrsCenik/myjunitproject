package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day09_Cookies extends TestBase {
    //Go to amazon ad automate the tasks
    //1-find the total number of cookies
    //2-Print all the cookies
    //3-Get the cookies by their names
    //4-Add new cookie
    //5-Delete cookie by name
    //6-Delete all the cookies

    @Test
    public void handleCookies(){
        driver.get("https://www.amazon.com/");

        //getCookies() returns all the cookies in the browser
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("Number of Cookies => "+numOfCookies);

        //Print all the cookies: cookie names and cookie values
        for(Cookie eachCookie : allCookies){
            System.out.println("Cookie Names => "+eachCookie.getName());
            System.out.println("Cookie Values => "+eachCookie.getValue());
        }
        //Get the cookies by their names
        System.out.println("Cookie names i18n-prefs => " +driver.manage().getCookieNamed("i18n-prefs"));

        //Create a new cookie
        Cookie myCookie = new Cookie("My Cookie Monster","Chocolate Chips");
        //Add the cookie to the browser
        driver.manage().addCookie(myCookie);
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookie => " + allCookies.size());

        //Delete cookie by their names
        driver.manage().deleteCookieNamed("ubid-main");
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookie => " + allCookies.size());

        //Delete all cookies
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookie => " + allCookies.size());




    }
}
