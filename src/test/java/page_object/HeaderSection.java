package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSection extends BasePage{

    public HeaderSection(WebDriver driver){
        super(driver);
    }
    private WebElement login_button = driver.findElement(By.id("topLoginLink"));

    public void click_login(){
        login_button.click();
    }
}