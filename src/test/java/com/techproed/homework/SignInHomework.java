package com.techproed.homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class SignInHomework {
            /**
           ENTER ALL REQUIRED FIELDS AND VERIFY THE ACCOUNT CREATION IS SUCCESSFUL
                1. Create a class SignInHomework +
                2. Go to http://automationpractice.com/index.php +
                3. Click on sign in link +
                4.Send your email and click on create an account button +
                5.Verify the Text : CREATE AN ACCOUNT +
                6. Verify the Text : YOUR PERSONAL INFORMATION +
                7. Verify the Text : Title +
                8. Select your title +
                9. Enter your first name +
                10. Enter your last name +
                11. Enter your email +
                12. Enter your password +
                13. ENTER DATE OF BIRTH +
                14. Click on Sign up for our newsletter! +
                15. Enter your first name +
                16. Enter your last lane +
                17. Enter your company +
                18. Enter your Address +
                19. Enter your City +
                20. SELECT STATE +
                21. Enter Postal Code +
                22.SELECT COUNTRY +
                23. Enter additional information +
                24. Enter home phone +
                25. Enter mobile phone +
                26. Enter reference name +
                27. Click Register +
                28. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGEecked+
             */

            WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }
    @Test
    public void signIn(){
        Faker faker =new Faker();
        driver.findElement(By.xpath("//a[@class= 'login']")).click();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@data-validate= 'isEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//button[@id= 'SubmitCreate']")).click();
        String actualHl1 = driver.findElement(By.xpath("//h1[.='Create an account']")).getText();
        Assert.assertEquals("CREATE AN ACCOUNT",actualHl1);
        String actualHl3 = driver.findElement(By.xpath("//h3[.='Your personal information']")).getText();
        Assert.assertEquals("YOUR PERSONAL INFORMATION", actualHl3);
        String actualTitle = driver.findElement(By.xpath("//label[.='Title']")).getText();
        Assert.assertEquals("Title", actualTitle);
        WebElement genderMrs =driver.findElement(By.xpath("//label[@for ='id_gender2']"));
        if(!genderMrs.isSelected()){
            genderMrs.click();
        }
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        driver.findElement(By.xpath("//input[@id ='customer_firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id ='customer_lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id ='email']")).clear();
        driver.findElement(By.xpath("//input[@id ='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id ='passwd']")).sendKeys(faker.internet().password());
        WebElement day = driver.findElement(By.id("days"));
        Select select = new Select(day);
        select.selectByValue("3");
        WebElement month = driver.findElement(By.id("months"));
        Select select1 = new Select(month);
        select1.selectByIndex(5);
        WebElement year = driver.findElement(By.id("years"));
        Select select2 = new Select(year);
        select2.selectByValue("1999");
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select3 = new Select(state);
        select3.selectByVisibleText(faker.address().state());
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");
        WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select select4 = new Select(country);
        select4.selectByVisibleText("United States");
        driver.findElement(By.xpath("//textarea[@cols='26']")).sendKeys("Type extra information here");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@id='alias']")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Home");
        driver.findElement(By.xpath("//span[.='Register']")).click();
        Assert.assertEquals("MY ACCOUNT", driver.findElement(By.xpath("//h1[@class='page-heading']")).getText());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
