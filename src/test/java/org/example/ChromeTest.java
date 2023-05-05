package org.example; // What is it for?

import static org.assertj.core.api.Assertions.assertThat; // Why is it static?

// Why we cannot just import org.junit.jupiter.api ???
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Why we cannot just import org.openqa.selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class ChromeTest {

    WebDriver driver; // We declare driver value as WebDriver data type. Am I right?
    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupTest(){
        //Local call of Chrome browser
        //driver = new ChromeDriver();
        driver = wdm.create();
    }


    @AfterEach
    void teardown(){
        driver.quit();
    }


    @Test
    void test(){
        // Exercise
        driver.get("https://google.com.ua");
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("Google");

    }
}