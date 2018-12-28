package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewStoreAdminPage extends PageBase {
    @FindBy(id = "error-msg-malls")
    public WebElement errorMsgSelectMall;
    @FindBy(id = "error-msg-stores")
    public WebElement errorMsgSelectStore;
    @FindBy(id = "error-msg-admin_name")
    public WebElement errorMsgAdminName;
    @FindBy(id = "error-msg-email")
    public WebElement errorMsgEmail;
    @FindBy(id = "error-msg-password")
    public WebElement errorMsgPasssword;
    @FindBy(id = "success-msg")
    public WebElement successMsg;
    @FindBy(id = "all_malls")
    WebElement mallSelect;
    @FindBy(id = "all_stores")
    WebElement storeSelect;
    @FindBy(id = "admin_Name_input")
    WebElement adminNameTxt;
    @FindBy(id = "email_input")
    WebElement emailNameTxt;
    @FindBy(id = "password_input")
    WebElement passwordTxt;
    @FindBy(id = "submit-btn")
    WebElement submitBt;

    public AddNewStoreAdminPage(WebDriver driver) {
        super(driver);
    }

    public void SelectMallInAdmin() {

        Select selectMall = new Select(mallSelect);
        selectMall.selectByValue("4");
    }

    public void SelectStoreInAdmin() {

        Select selectStore = new Select(storeSelect);

        // for stage
        //selectStore.selectByValue("293");

        // for demo
        selectStore.selectByValue("440");

    }

    public void AddAddminName(String Value) {

        setTextElementText(adminNameTxt, Value);
    }

    public void AddAdminEmail(String Value) {

        setTextElementText(emailNameTxt, Value);
    }

    public void AddPasswordInAdmin(String Value) {

        setTextElementText(passwordTxt, Value);
    }

    public void ClickToSaveInAdmin() {

        clickButton(submitBt);
    }
}
