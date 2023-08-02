package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    WebElement username_field = driver.findElement(By.xpath("//input[@name='username']"));

    public void LoginFormUsername(){
        username_field.click();
    }

    WebElement password_field = driver.findElement(By.xpath("//input[@name='password']"));

    public void LoginFormPassword(){
        password_field.click();
    }
}
