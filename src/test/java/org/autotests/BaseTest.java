package org.autotests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
class BaseTest {

    WebDriver driver; //Q: We declare driver value as WebDriver data type. Am I right?
    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

    @BeforeAll
    static void setupClass(){
        // Q: Commenting this next line does not affect anything, why does it need it?
        // WebDriverManager.chromedriver().setup();
    }


    //Precondition
    @BeforeEach
    void setupTest(){
        driver = wdm.create(); // Q: What is actually going on here?
        driver.manage().window().maximize();
        // Q: Why do we not use driver.get("https://www.olx.ua/"); in the next line
        driver.navigate().to("https://www.olx.ua/");
    }


    //Post-condition
    @AfterEach
    void teardown(){
        driver.quit();
    }


    @Test
    void test(){

    }
}