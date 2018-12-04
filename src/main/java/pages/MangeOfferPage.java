package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangeOfferPage extends PageBase {
    public MangeOfferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNew-btn")
    WebElement addNewOfferBt;

    @FindBy(id = "edit-4")
    WebElement editOfferNumber4;

    public void ClickToAddNewOffer() {

        clickButton(addNewOfferBt);
    }
    public void ClickToEditOffer() {

        clickButton(editOfferNumber4);
    }
}
