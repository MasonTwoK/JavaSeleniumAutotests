package org.autotests; // What is it for (package)?

import static org.assertj.core.api.Assertions.assertThat; // Why is it static?

// Why we cannot just import org.junit.jupiter.api ???
import org.junit.jupiter.api.*;

// Why we cannot just import org.openqa.selenium
//import org.openqa.selenium.chrome.ChromeDriver;


class SomePageTest extends BaseTest{
    @Test
    void test(){
        // Exercise
        driver.get("https://olx.ua");
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.ua");
    }
}