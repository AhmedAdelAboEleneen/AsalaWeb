package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditStorePage extends PageBase {
    @FindBy(id = "edit-360")
    public WebElement clickEditBt;
    @FindBy(id = "error-msg-category_id")
    public WebElement errorCategorySelect;
    @FindBy(id = "error-msg-floor")
    public WebElement errorMsgFloor;
    @FindBy(id = "error-msg-email")
    public WebElement errorMsgEmail;
    @FindBy(id = "input-file-logo")
    public WebElement logoBt;
    @FindBy(id = "phone-1")
    public WebElement phoneNumber2Txt;
    @FindBy(id = "success-msg")
    public WebElement sucessMsg;
    @FindBy(id = "filter-by-mall")
    WebElement mallSelect;
    @FindBy(id = "add-more-phone")
    WebElement addMorePhone;
    @FindBy(id = "remove-more-phone")
    WebElement removePhone;
    @FindBy(id = "form-control-email")
    WebElement addEmailTxt;
    @FindBy(id = "submit-btn")
    WebElement saveBt;

    public EditStorePage(WebDriver driver) {
        super(driver);
    }

    public void SelectMall() {

        Select selectMall = new Select(mallSelect);
        selectMall.selectByValue("1");
    }

    public void CLickToEditStore() {
        clickButton(clickEditBt);
    }

    public void ClickToAddMorePhone() {

        clickButton(addMorePhone);
    }

    public void ClickToRemovePhone() {

        clickButton(removePhone);
    }

    public void AddPhoneTwo(String Value) {

        setTextElementText(phoneNumber2Txt, Value);
    }

    public void ClickToSave() {

        clickButton(saveBt);
    }

    public void UploadPNG() {

        String imageName = "PNG.png";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        logoBt.sendKeys(imagePath);
    }

    public void AddEmail(String Value) {

        setTextElementText(addEmailTxt, Value);
    }
}
