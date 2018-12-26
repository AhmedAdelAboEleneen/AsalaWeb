package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangeOfferPage extends PageBase {
    @FindBy(id = "addNew-btn")
    WebElement addNewOfferBt;
    @FindBy(id = "edit-2179")
    WebElement editOfferNumber4;

    public MangeOfferPage(WebDriver driver) {
        super(driver);
    }

    public void ClickToAddNewOffer() {

        clickButton(addNewOfferBt);
    }

    public void ClickToEditOffer() {

        clickButton(editOfferNumber4);
    }
}
