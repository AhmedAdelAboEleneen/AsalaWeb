package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewOfferPage extends PageBase {
    @FindBy(id = "error-msg-offer_name_ar")
    public WebElement errorMsgNameAr;
    @FindBy(id = "error-msg-offer_name_en")
    public WebElement errorMsgNameEn;
    @FindBy(id = "error-msg-offer_description_ar")
    public WebElement errorMsgDescriptionAr;
    @FindBy(id = "error-msg-offer_description_en")
    public WebElement errorMsgDescriptionEn;
    @FindBy(id = "error-msg-photo")
    public WebElement errorMsgPhoto;
    @FindBy(id = "select-start_at")
    public WebElement DateFrom;
    @FindBy(id = "error-msg-start_at")
    public WebElement errorMsgDateFrom;
    @FindBy(id = "select-end_at")
    public WebElement DateTo;
    @FindBy(id = "error-msg-end_at")
    public WebElement errorMsgDateTo;
    @FindBy(id = "error-msg-mall_id")
    public WebElement errorMallSelect;
    @FindBy(id = "error-msg-store_id")
    public WebElement errorstoreSelect;
    @FindBy(id = "success-msg")
    public WebElement sucessMsg;
    @FindBy(id = "offer_name_input_ar")
    WebElement offerNameArTxt;
    @FindBy(id = "offer_name_input_en")
    WebElement offerNameEnTxt;
    @FindBy(id = "offer_description_input_ar")
    WebElement offerDescriptionArTxt;
    @FindBy(id = "offer_description_input_en")
    WebElement offerDescriptionEnTxt;
    @FindBy(id = "input-file-photo")
    WebElement coverPhotoBt;
    @FindBy(id = "select-mall")
    WebElement mallSelect;
    @FindBy(id = "select-store")
    WebElement storeSelect;
    @FindBy(id = "submit-btn")
    WebElement saveBt;

    public AddNewOfferPage(WebDriver driver) {
        super(driver);
    }

    public void AddTextInOfferNameArabic(String Value) {

        setTextElementText(offerNameArTxt, Value);
    }

    public void AddTextInOfferNameEnglish(String Value) {

        setTextElementText(offerNameEnTxt, Value);
    }

    public void AddTextInOfferDescArabic(String Value) {

        setTextElementText(offerDescriptionArTxt, Value);
    }

    public void AddTextInOfferDescEnglish(String Value) {

        setTextElementText(offerDescriptionEnTxt, Value);
    }

    public void UploadLogo() {

        String imageName = "logo.jpg";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadCover() {

        String imageName = "cover.jpg";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadWrong() {

        String imageName = "wrong.docx";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadMore() {

        String imageName = "more.png";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    // calender Here !!!

    // chose current  date in date from
    public void ChoseDateFromCurrent() {
        DateFrom.click();
        DateFrom.sendKeys(Keys.ENTER);
    }

    // chose future date in date from
    public void ChoseDateFromFuture() {
        DateFrom.click();
        DateFrom.sendKeys(Keys.ARROW_DOWN);
        DateFrom.sendKeys(Keys.ENTER);
    }

    // chose current  date in date to
    public void ChoseDateToCurrent() {
        DateTo.click();
        DateTo.sendKeys(Keys.ENTER);
    }

    // chose future date in date to
    public void ChoseDateToFuture() {
        DateTo.click();
        DateTo.sendKeys(Keys.ARROW_DOWN);
        DateTo.sendKeys(Keys.ENTER);
    }

    public void SelectMall() {

        Select selectMall = new Select(mallSelect);
        // stage
        selectMall.selectByValue("10");

        // demo
       // selectMall.selectByValue("72");
    }

    public void SelectStore() {

        Select selectStore = new Select(storeSelect);
        // stage
        selectStore.selectByValue("4587");

        // demo
       // selectStore.selectByValue("553");

    }

    public void ClickToSave() {

        clickButton(saveBt);
    }
}
