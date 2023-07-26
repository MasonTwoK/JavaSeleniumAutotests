package org.autotests;

import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseTest {
    WebDriver driver; //Q: We declare driver value as WebDriver data type. Am I right?
    //WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

    @BeforeAll
    static void setupClass(){
        // Q: Commenting this next line does not affect anything, why does it need it?
        // WebDriverManager.chromedriver().setup();
    }


    //Precondition
    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Q: Why do we not use driver.get("https://www.olx.ua/"); in the next line
        driver.navigate().to("https://www.olx.ua/");
    }


    //Post-condition
    @AfterEach
    void teardown(){
        driver.quit();
    }
}