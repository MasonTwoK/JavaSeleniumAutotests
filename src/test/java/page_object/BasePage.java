package page_object;

import org.openqa.selenium.WebDriver;


public class BasePage{
    protected static WebDriver driver;

    public BasePage(WebDriver webDriver){
        driver = webDriver;
    }

    //Q: difference between this type of constructor
//    protected WebDriver driver;
//    public BasePage(WebDriver driver){
//        this.driver = driver;
//    }

}