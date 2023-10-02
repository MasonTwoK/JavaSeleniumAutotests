package org.autotests; //Q: How does "package" works?

import org.junit.jupiter.api.Disabled; // Q: How does import works in Java?
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page_object.InitPage;
import page_object.LoginPage;

import static org.assertj.core.api.Assertions.assertThat; // Q: How does static works?

class LoginTest extends BaseTest {

    @Test
    public void test_website_open(){
        // Execute
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("OLX.ua");
    }

    @Test
    public void test_login_page_open(){
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
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']"));
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Не забудьте ввести електронну пошту чи телефон");

        // Needed to be improved and initialize in Login Page
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-jl1cuj']//div[@class='css-2t3wbf']"));
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Не забудьте ввести пароль");

    }

    @Disabled("[BUG](P4). Actual Result: Це не схоже на електронну пошту, Expected Result: Ця пошта задовга")
    @Test
    public void test_login_username_email_field_validation(){
        InitPage initPage = new InitPage(driver);
        initPage.header.ClickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.UsernameFieldSendKeys("email_with_out_dot_sign");

        // Needed to be improved and initialize in Login Page.
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']")
        );

        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Це не схоже на електронну пошту");


        loginPage.UsernameFieldSendKeys("email_with_@_&_without_dot_sign");

        // Needed to be improved and initialize in Login Page.
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']")
        );

        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Це не схоже на електронну пошту");


        loginPage.UsernameFieldSendKeys(loginPage.email_limit_string128);

        // Needed to be improved and initialize in Login Page.
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']")
        );

        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Ця пошта задовга");


    }


    @Disabled("[BUG](P4) Actual Result: Цей пароль дуже короткий, Expected Result: Цей пароль дуже довгий")
    @Test
    public void test_login_password_field_validation(){
        InitPage initPage = new InitPage(driver);
        initPage.header.ClickLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.PasswordFieldSendKeys("1");

        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-jl1cuj']//div[@class='css-2t3wbf']")
        );
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();

        assertThat(loginPage.warning_message_text).contains("надто короткий.");


        loginPage.PasswordFieldSendKeys(loginPage.password_limit_string256);

        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-jl1cuj']//div[@class='css-2t3wbf']"));
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();
        assertThat(loginPage.warning_message_text).contains("Цей пароль дуже довгий");
    }

    @Test
    public void test_login_username_phone_validation(){
        InitPage initPage = new InitPage(driver);
        initPage.header.ClickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.UsernameFieldSendKeys(loginPage.phone_number_with_missing_digit);

        //Need to be moved to LoginPage
        loginPage.warning_message_elm = driver.findElement(
                By.xpath("//div[@class='css-1a74nwz']//div[@class='css-2t3wbf']"));
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();

        assertThat(loginPage.warning_message_text).contains("не схоже на дійсний номер");

        loginPage.warning_message_elm = driver.findElement(By.xpath("//div[@class='css-jha7bn']"));
        loginPage.warning_message_text = loginPage.warning_message_elm.getText();

        assertThat(loginPage.warning_message_text).contains("+380");
    }
}