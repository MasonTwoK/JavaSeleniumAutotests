package org.autotests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginTest extends BaseTest {
    @Test
    void test_open_website(){
        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.ua");
    }
}