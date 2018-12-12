package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class AddNewEventPage extends PageBase {
    public AddNewEventPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sfilter-by-mall")
    WebElement mallSelect;

    @FindBy(id = "error-msg-mall_id")
    public WebElement errorMallSelect;

    @FindBy(id = "event_name_input_ar")
    WebElement eventNameArTxt;

    @FindBy(id = "error-msg-event_name_ar")
    public WebElement errorMsgNameAr;

    @FindBy(id = "event_name_input_en")
    WebElement eventNameEnTxt;

    @FindBy(id = "error-msg-event_name_en")
    public WebElement errorMsgNameEn;

    @FindBy(id = "event_description_input_ar")
    WebElement eventDescriptionArTxt;

    @FindBy(id = "error-msgs-description_ar")
    public WebElement errorMsgDescriptionAr;

    @FindBy(id = "event_description_input_en")
    WebElement eventDescriptionEnTxt;

    @FindBy(id = "error-msg-description_en")
    public WebElement eventMsgDescriptionEn;

    @FindBy(id = "sponsor_input")
    WebElement organizerTxt;

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


    @FindBy(id = "timeFrom")
    public WebElement timeFrom;

    @FindBy(id = "")
    public WebElement errorMsgTimeFrom;

    @FindBy(id = "timeTo")
    public WebElement timeTo;

    @FindBy(id = "")
    public WebElement errorMsgTimeTo;

    @FindBy(id = "input-file-photo")
    WebElement photoBt;

    @FindBy(id = "error-msg-photo")
    public WebElement errorMsgPhoto;

    @FindBy(id = "form-control-email")
    WebElement addEmailTxt;

    @FindBy(id = "error-msg-email")
    public WebElement errorMsgEmail;

    @FindBy(id = "form-control-phone")
    WebElement phoneNumberTxt;

    @FindBy(id = "error-msg-phone")
    public WebElement errorMsgPhone;

    @FindBy(id = "location_input")
    WebElement eventLocationTxt;

    @FindBy(id = "error-msg-location")
    public WebElement errorMsgEvent;

    @FindBy(id = "submit-btn")
    WebElement saveBt;

    @FindBy(id = "success-msg")
    public WebElement sucessMsg;

    public void SelectMall() {

        Select selectMall = new Select(mallSelect);
        selectMall.selectByValue("4");
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

    // chose old date in date from
    public void ChoseDateFromOld(){
        DateFrom.click();
        DateFrom.sendKeys(Keys.ARROW_UP);
        DateFrom.sendKeys(Keys.ENTER);
    }

    // chose current  date in date from
    public void ChoseDateFromCurrent(){
        DateFrom.click();
        DateFrom.sendKeys(Keys.ENTER);
    }

    // chose future date in date from
    public void ChoseDateFromFuture(){
        DateFrom.click();
        DateFrom.sendKeys(Keys.ARROW_DOWN);
        DateFrom.sendKeys(Keys.ENTER);
    }

    // chose old date in date to
    public void ChoseDateToOld(){
        DateTo.click();
        DateTo.sendKeys(Keys.ARROW_UP);
        DateTo.sendKeys(Keys.ENTER);
    }

    // chose current  date in date to
    public void ChoseDateToCurrent(){
        DateTo.click();
        DateTo.sendKeys(Keys.ENTER);
    }

    // chose future date in date to
    public void ChoseDateToFuture(){
        DateTo.click();
        DateTo.sendKeys(Keys.ARROW_DOWN);
        DateTo.sendKeys(Keys.ENTER);
    }

    public void UploadSVG (){

        String imageName = "SVG.svg";
        String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
        photoBt.sendKeys(imagePath);
    }

    public void UploadMoreSize (){

        String imageName = "OverSize.jpg";
        String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
        photoBt.sendKeys(imagePath);
    }

    public void UploadPNG (){

        String imageName = "PNG.png";
        String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
        photoBt.sendKeys(imagePath);
    }

    public void UploadJPG (){

        String imageName = "JPG.jpg";
        String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
        photoBt.sendKeys(imagePath);
    }

    public void AddEmailEvent(String Value) {

        setTextElementText(addEmailTxt, Value);
    }

    public void AddPhoneOne(String Value) {

        setTextElementText(phoneNumberTxt, Value);
    }

    public void AddTextInLocation(String Value) {

        setTextElementText(eventLocationTxt, Value);
    }

}
