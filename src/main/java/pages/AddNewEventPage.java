package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewEventPage extends PageBase {
    @FindBy(id = "error-msg-mall_id")
    public WebElement errorMallSelect;
    @FindBy(id = "error-msg-event_name_ar")
    public WebElement errorMsgNameAr;
    @FindBy(id = "error-msg-event_name_en")
    public WebElement errorMsgNameEn;
    @FindBy(id = "error-msgs-description_ar")
    public WebElement errorMsgDescriptionAr;
    @FindBy(id = "error-msg-description_en")
    public WebElement errorMsgDescriptionEn;
    @FindBy(id = "error-msg-sponsor")
    public WebElement errorMsgOrganizerEn;
    @FindBy(id = "select-start_at")
    public WebElement DateFrom;
    @FindBy(id = "error-msg-start_at")
    public WebElement errorMsgDateFrom;
    @FindBy(id = "select-end_at")
    public WebElement DateTo;
    @FindBy(id = "error-msg-end_at")
    public WebElement errorMsgDateTo;
    @FindBy(id = "timeFrom-select")
    public WebElement timeFrom;
    @FindBy(id = "timeTo-select")
    public WebElement timeTo;
    @FindBy(id = "error-msg-timeTo")
    public WebElement errorMsgTimeTo;
    @FindBy(id = "error-msg-photo")
    public WebElement errorMsgPhoto;
    @FindBy(id = "error-msg-email")
    public WebElement errorMsgEmail;
    @FindBy(id = "error-msg-phone")
    public WebElement errorMsgPhone;
    @FindBy(id = "error-msg-location")
    public WebElement errorMsgLocationEn;
    @FindBy(id = "error-msg-location_ar")
    public WebElement errorMsgLocationAr;
    @FindBy(id = "success-msg")
    public WebElement sucessMsg;
    @FindBy(id = "filter-by-mall")
    WebElement mallSelect;
    @FindBy(id = "event_name_input_ar")
    WebElement eventNameArTxt;
    @FindBy(id = "event_name_input_en")
    WebElement eventNameEnTxt;
    @FindBy(id = "event_description_input_ar")
    WebElement eventDescriptionArTxt;
    @FindBy(id = "event_description_input_en")
    WebElement eventDescriptionEnTxt;
    @FindBy(id = "sponsor_input")
    WebElement organizerTxt;
    @FindBy(id = "input-file-photo")
    WebElement coverPhotoBt;
    @FindBy(id = "form-control-email")
    WebElement AddEmail;
    @FindBy(id = "form-control-phone")
    WebElement phoneNumberTxt;
    @FindBy(id = "location_input")
    WebElement eventLocationTxtEn;
    @FindBy(id = "location_ar_input")
    WebElement eventLocationTxtAr;
    @FindBy(id = "submit-btn")
    WebElement saveBt;

    public AddNewEventPage(WebDriver driver) {
        super(driver);
    }

    public void SelectMall() {

        Select selectMall = new Select(mallSelect);

        // stage
         selectMall.selectByValue("4");

        // demo
       // selectMall.selectByValue("72");
    }

    public void AddTextInEventNameArabic(String Value) {

        setTextElementText(eventNameArTxt, Value);
    }

    public void AddTextInEventNameEnglish(String Value) {

        setTextElementText(eventNameEnTxt, Value);
    }

    public void AddTextInEventDescArabic(String Value) {

        setTextElementText(eventDescriptionArTxt, Value);
    }

    public void AddTextInEventDescEnglish(String Value) {

        setTextElementText(eventDescriptionEnTxt, Value);
    }

    public void AddTextInSponseer(String Value) {

        setTextElementText(organizerTxt, Value);
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

    // Time From

    public void SelectTimefromEight() {

        Select selectTimeFromEight = new Select(timeFrom);
        selectTimeFromEight.selectByValue("8 AM");
    }

    public void SelectTimeFromTwelveAM() {

        Select SelectTimeFromTwelveAM = new Select(timeFrom);
        SelectTimeFromTwelveAM.selectByValue("12 AM");
    }

    public void SelectTimeFromTwelvePM() {

        Select SelectTimeFromTwelvePM = new Select(timeFrom);
        SelectTimeFromTwelvePM.selectByValue("12 PM");
    }

    public void SelectTimeFromElvenAM() {

        Select SelectTimeFromElvenAM = new Select(timeFrom);
        SelectTimeFromElvenAM.selectByValue("11 AM");
    }

    public void SelectTimeFromElvenPM() {

        Select SelectTimeFromElvenPM = new Select(timeFrom);
        SelectTimeFromElvenPM.selectByValue("11 PM");
    }
    public void SelectTimeFromOnePM() {

        Select SelectTimeFromOnePM = new Select(timeFrom);
        SelectTimeFromOnePM.selectByValue("1 PM");
    }

    public void SelectTimeFromOneAM() {

        Select SelectTimeFromOnePM = new Select(timeFrom);
        SelectTimeFromOnePM.selectByValue("1 AM");
    }

    // Time To

    public void SelectTimeToTwo() {

        Select selectTimeToTwo = new Select(timeTo);
        selectTimeToTwo.selectByValue("2 AM");
    }

    public void SelectTimeToTwelveAM() {

        Select SelectTimeToTwelveAM = new Select(timeTo);
        SelectTimeToTwelveAM.selectByValue("12 AM");
    }

    public void SelectTimeToTwelvePM() {

        Select SelectTimeToTwelvePM = new Select(timeTo);
        SelectTimeToTwelvePM.selectByValue("12 PM");
    }

    public void SelectTimeToElvenAM() {

        Select SelectTimeToElvenPAM = new Select(timeTo);
        SelectTimeToElvenPAM.selectByValue("11 AM");
    }

    public void SelectTimeToElvenPM() {

        Select SelectTimeToElvenPM = new Select(timeFrom);
        SelectTimeToElvenPM.selectByValue("11 PM");
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

    public void AddEmail(String Value) {

        setTextElementText(AddEmail, Value);
    }

    public void AddPhoneOne(String Value) {

        setTextElementText(phoneNumberTxt, Value);
    }

    public void AddTextInLocationEn(String Value) {

        setTextElementText(eventLocationTxtEn, Value);
    }

    public void AddTextInLocationAr(String Value) {

        setTextElementText(eventLocationTxtAr, Value);
    }

    public void ClickToSave() {

        clickButton(saveBt);
    }

}
