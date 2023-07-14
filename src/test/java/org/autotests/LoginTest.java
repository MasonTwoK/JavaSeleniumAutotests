package org.autotests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import page_object.InitPage;


import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

class LoginTest extends BaseTest {
    @Disabled
    @Test
    void test_open_website(){
        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.ua");
    }

    @Disabled
    @Test
    void test_open_login_page() throws InterruptedException{
        InitPage initPage = new InitPage(driver);
        initPage.header.click_login();

        sleep(5000);
    }
}