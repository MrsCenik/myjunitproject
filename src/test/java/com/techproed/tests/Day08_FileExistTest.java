package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest{
    /*
    Class: FileExistTest
    Method: isExist
    Pick a file on your desktop
    And verify if that file exist on your computer or not
     */

    @Test
    public void isExist(){
        /*
        Selenium has liomitation with destop application
        With Java we can check if a file exist in our local computer

         */
       String homePath = System.getProperty("user.home");//Users/ismailcenik
        String pathOfFlower = homePath+"/Desktop/flower.jpeg";
        System.out.println(pathOfFlower);

        //This code checks if pathOfFlower is exist or not
        //If it exists, this returns true; otherwise, this returns false

        boolean isExist = Files.exists(Paths.get(pathOfFlower));
        Assert.assertTrue(isExist);
    }
}
