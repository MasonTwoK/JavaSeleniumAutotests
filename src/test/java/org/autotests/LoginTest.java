package org.autotests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_object.InitPage;
import page_object.LoginPage;


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
        initPage.header.ClickLogin();

        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.UA - Увійти");
    }

    @Test
    public void test_login_with_empty_fields(){ //Q: What is the difference between public void and void method?
        InitPage initPage = new InitPage(driver);
        initPage.header.ClickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.UsernameFieldClick();
        loginPage.PasswordFieldClick();

        loginPage.LoginSubmitClick();


        // Needed to be improved and initialize in Login Page.
        WebElement missing_username_msg_elm = driver.findElement(By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']"));
        String missing_username_message = missing_username_msg_elm.getText();
        assertThat(missing_username_message).contains("Не забудьте ввести електронну пошту чи телефон");

        // Needed to be improved and initialize in Login Page
        WebElement missing_password_msg_elm = driver.findElement(By.xpath("//div[@class='css-jl1cuj']//div[@class='css-2t3wbf']"));
        String missing_password_message = missing_password_msg_elm.getText();
        assertThat(missing_password_message).contains("Не забудьте ввести пароль");

    }

    @Test
    public void test_login_incorrect_email_in_field() throws InterruptedException{ //Q: What is the difference between public void and void method?
        InitPage initPage = new InitPage(driver);
        initPage.header.ClickLogin();

        LoginPage loginPage = new LoginPage(driver);

        //loginPage.UsernameFieldClick();
        loginPage.UsernameFieldSendKeys("email_with_out_dot_sign");



        sleep(5000);
    }
}