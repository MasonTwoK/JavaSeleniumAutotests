package org.autotests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class LocalTest {
    WebDriver driver = new ChromeDriver();

    @Test
    void test() throws InterruptedException {

        driver.get("https://www.google.com.ua");

        assertThat(driver.getTitle()).contains("Google");

        Thread.sleep(5000);
        driver.quit();
    }
}