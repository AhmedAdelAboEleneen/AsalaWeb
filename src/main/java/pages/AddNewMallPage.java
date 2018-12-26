package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewMallPage extends PageBase {

    @FindBy(id = "error-msg-mall_name_ar")
    public WebElement errorMsgNameAr;
    @FindBy(id = "error-msg-mall_name_en")
    public WebElement errorMsgNameEn;
    @FindBy(id = "error-msg-photo")
    public WebElement errorMsgPhoto;
    @FindBy(id = "error-msg-floor")
    public WebElement errorMsgFloor;
    @FindBy(id = "error-msg-city")
    public WebElement errorMsgCity;
    @FindBy(id = "error-msg-address")
    public WebElement errorMsgAddressEn;
    @FindBy(id = "error-msg-address_ar")
    public WebElement errorMsgAddressAr;
    @FindBy(id = "error-msg-website")
    public WebElement errorMsgWebsiteLink;
    @FindBy(id = "error-msg-twitter")
    public WebElement errorMsgeTwitter;
    @FindBy(id = "error-msg-facebook")
    public WebElement errorMsgeFacebook;
    @FindBy(id = "error-msg-instagram")
    public WebElement errorMsgeInstagram;
    @FindBy(id = "success-msg")
    public WebElement sucessMsg;
    @FindBy(id = "mall_name_input_ar")
    WebElement mallNameArTxt;
    @FindBy(id = "mall_name_input_en")
    WebElement mallNameEnTxt;
    @FindBy(id = "input-file-photo")
    WebElement coverPhotoBt;
    @FindBy(id = "mall_floor")
    WebElement AddFloorTxt;
    @FindBy(id = "mall_city")
    WebElement mallCitySelect;
    @FindBy(id = "mall_address")
    WebElement mallAddressTxtEn;
    @FindBy(id = "mall_address_ar")
    WebElement mallAddressTxtAr;
    @FindBy(id = "website_link")
    WebElement websiteLinkTxt;
    @FindBy(id = "twitter_account")
    WebElement twitterTxt;
    @FindBy(id = "facebook_account")
    WebElement facebookTxt;
    @FindBy(id = "instagram_account")
    WebElement instagramTxt;
    @FindBy(id = "submit-btn")
    WebElement saveBt;

    public AddNewMallPage(WebDriver driver) {
        super(driver);
    }

    public void AddTextInMallNameArabic(String Value) {

        setTextElementText(mallNameArTxt, Value);
    }

    public void AddTextInMallNameEnglish(String Value) {

        setTextElementText(mallNameEnTxt, Value);
    }

    public void UploadSVGCover() {

        String imageName = "SVG.svg";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadMoreSizeCover() {

        String imageName = "OverSize.jpg";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadPNGCover() {

        String imageName = "PNG.png";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void UploadJPGCover() {

        String imageName = "JPG.jpg";
        String imagePath = System.getProperty("user.dir") + "/uploads/" + imageName;
        coverPhotoBt.sendKeys(imagePath);
    }

    public void AddTextInNumbersOfFloor(String Value) {

        setTextElementText(AddFloorTxt, Value);
    }

    public void SelectMakka() {

        Select selectMall = new Select(mallCitySelect);
        selectMall.selectByValue("2");
    }

    public void SelectMedina() {

        Select selectMall = new Select(mallCitySelect);
        selectMall.selectByValue("3");
    }

    public void AddTextInMallAddressEn(String Value) {

        setTextElementText(mallAddressTxtEn, Value);
    }

    public void AddTextInMallAddressAr(String Value) {

        setTextElementText(mallAddressTxtAr, Value);
    }

    public void AddTextInMallWebsite(String Value) {

        setTextElementText(websiteLinkTxt, Value);
    }

    public void AddTextInMallTwitter(String Value) {

        setTextElementText(twitterTxt, Value);
    }

    public void AddTextInMallFacebook(String Value) {

        setTextElementText(facebookTxt, Value);
    }

    public void AddTextInMallInstgram(String Value) {

        setTextElementText(instagramTxt, Value);
    }

    public void ClickToSave() {

        clickButton(saveBt);
    }

}
