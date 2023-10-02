package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public WebElement warning_message_elm;
    public String warning_message_text;
    public String email_limit_string128 = "jsqCT3ltB2Y7mNXAebKyQFDwamRJrBGkWcuRYlsVXVQV8um" +
            "tL26zX9n24Fl058zjsRoKLbPhfS6PvGAKKjQKjgXuC2c3jQMJS5tz1CHdtP4mZmZ6zwga6gM@gmail.com";
    public String password_limit_string256 =
            "YgUiLnJdFmEr9rwKQ8gA6GRyW4tVekJP19IjCWzTwNkE2h5DElYwxN66YQDwzAWWUrt0Sn0dbTC7jelglFb7pLKNXX7Ybtk" +
                    "7D7H3IxEK9ujNWHPVQeUlr08U8RqO16rzYZvCwu0h9YYiTxANY288E8gNKcbQ3QsZw3ungiyXFLKJ9X2YGnUM65n" +
                    "OFffXWQyn4iArfSMcZQU5AaazZ6t65tg3wYscFq3fGsaJfPTnVWMTg6B30cSz5jeJBp309G8z";

    public String phone_number_with_missing_digit = "12345678";
    WebElement username_field = driver.findElement(By.xpath("//input[@name='username']"));
    public void UsernameFieldClick(){
        username_field.click();
    }
    public void UsernameFieldSendKeys(String text){
        username_field.sendKeys(text);
    }

    WebElement password_field = driver.findElement(By.xpath("//input[@name='password']"));
    public void PasswordFieldClick(){
        password_field.click();
    }

    public void PasswordFieldSendKeys(String text) {password_field.sendKeys(text);}

    WebElement submit_button = driver.findElement(By.xpath("//button[@type='submit']"));
    public void LoginSubmitClick(){
        submit_button.click();
    }
}
