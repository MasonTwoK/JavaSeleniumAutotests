package org.autotests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LocalTest {
    ChromeOptions options = new ChromeOptions();
    //options.addArgument("no-sandbox");
    //options.addArgument("headless");

    WebDriver driver = new ChromeDriver(options);

    @Test
    void test() throws InterruptedException {

        driver.get("https://www.google.com.ua");

        assertThat(driver.getTitle()).contains("Google");

        Thread.sleep(5000);
        driver.quit();
    }
}