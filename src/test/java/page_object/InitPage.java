package page_object;

import org.openqa.selenium.WebDriver;

public class InitPage extends BasePage{

    public InitPage (WebDriver driver){
        super(driver);
    }

    public HeaderSection header = new HeaderSection(driver);
}