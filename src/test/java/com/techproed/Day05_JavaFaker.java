package com.techproed;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    //We may need fake data for testing
    //JavaFaket is used to get fake data
    //We need java faker dependency in or pom.xml

    @Test
    public void fakerTest(){
        //1. Create Faker object

        Faker faker =new Faker();

        //2. Now I can generate fake data: firstname, lastname, address, city, state, title

        //Generation fake firstname
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String fullName = faker.name().fullName();
        System.out.println("First name: "+fName);
        System.out.println("Last name: "+lName);
        System.out.println("Full name: "+ fullName);

        //title
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //phone number
        System.out.println(faker.phoneNumber().phoneNumber());

        //random 5 digit number
        System.out.println(faker.number().digits(5));

        //random email
        System.out.println(faker.internet().emailAddress());
    }
}
