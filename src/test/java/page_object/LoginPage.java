package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

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
