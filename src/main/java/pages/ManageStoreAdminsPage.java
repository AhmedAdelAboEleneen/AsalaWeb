package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageStoreAdminsPage extends PageBase {
    @FindBy(id = "addNew-btn")
    WebElement addNewAdminBt;


    public ManageStoreAdminsPage(WebDriver driver) {
        super(driver);
    }

    public void ClickAddNewAdmin() {

        clickButton(addNewAdminBt);
    }
}
