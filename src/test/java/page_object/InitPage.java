package page_object;

import org.openqa.selenium.WebDriver;

public class InitPage extends BasePage{

    public InitPage (WebDriver driver){
        super(driver);
        header = new HeaderSection(driver); //Q: How does this initialization works?
    }

    public HeaderSection header;
    //Q: I do we just do not do the next:
    // public HeaderSection header = new HeaderSection(driver);
}