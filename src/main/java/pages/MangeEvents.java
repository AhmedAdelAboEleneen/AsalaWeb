package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangeEvents extends PageBase {
    @FindBy(id = "addNew-btn")
    WebElement addNewEventBt;
    @FindBy(id = "edit-2179")
    WebElement editEventNumber4;

    public MangeEvents(WebDriver driver) {
        super(driver);
    }

    public void ClickToAddNewEvent() {

        clickButton(addNewEventBt);
    }

    public void ClickToEditOffer() {

        clickButton(editEventNumber4);
    }
}
