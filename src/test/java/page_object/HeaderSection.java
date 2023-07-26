package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderSection extends BasePage{

    //Q: In the next line we are basically inherit driver value from Base Page, am I right?
    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    //WebElement login_button = driver.findElement(By.id("topLoginLink")); Q: What is better to use?
    WebElement login_button = driver.findElement(By.xpath("//a[@href='https://www.olx.ua/uk/myaccount/']"));

    public void click_login(){
        login_button.click();
    }
}