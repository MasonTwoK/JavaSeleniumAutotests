package org.autotests;

import org.junit.jupiter.api.Test;
import page_object.InitPage;


import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

class LoginTest extends BaseTest {

    @Test
    public void test_open_website(){
        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.ua");
    }

    @Test
    public void test_open_login_page(){
        InitPage initPage = new InitPage(driver);
        initPage.header.click_login();

        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.UA - Увійти");
    }

    @Test
    public void test_login_with_empty_fields() throws InterruptedException{ //Q: What is the difference between public void and void method?
        sleep(1000);
    }
}