package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewStorePage extends PageBase {

	public AddNewStorePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "filter-by-mall")
	WebElement mallSelect;

	@FindBy(id = "error-msg-mall_id")
	public WebElement errorMallSelect;

	@FindBy(id = "filter-by-category")
	WebElement categorySelect;

	@FindBy(id = "error-msg-category_id")
	public WebElement errorCategorySelect;

	@FindBy(id = "floor-select")
	WebElement floorSelect;

	@FindBy(id = "error-msg-floor")
	public WebElement errorMsgFloor;

	@FindBy(id = "store_name_input_ar")
	WebElement storeNameArTxt;

	@FindBy(id = "error-msg-store_name_ar")
	public WebElement errorMsgNameAr;

	@FindBy(id = "store_name_input_en")
	WebElement storeNameEnTxt;

	@FindBy(id = "error-msg-store_name_en")
	public WebElement errorMsgNameEn;

	@FindBy(id = "store_description_input_ar")
	WebElement storeDescriptionArTxt;

	@FindBy(id = "error-msg-store_description_ar")
	public WebElement errorMsgDescriptionAr;

	@FindBy(id = "store_description_input_en")
	WebElement storeDescriptionEnTxt;

	@FindBy(id = "error-msg-store_description_en")
	public WebElement errorMsgDescriptionEn;

	@FindBy(id = "add-more-shifts")
	WebElement addMoreShiftBt;

	@FindBy(id = "days-0")
	WebElement daySelect;

	@FindBy(id = "select-date-from-0")
	WebElement dateFromSelect;

	@FindBy(id = "select-date-to-0")
	WebElement dateToSelect;

	@FindBy(id = "error-msg-day")
	public WebElement errorMsgDay;

	@FindBy(id = "active_status")
	WebElement activeRadioBt;

	@FindBy(id = "opening_soon_status")
	WebElement openingSoonRadioBt;


	@FindBy(id = "error-msg-status")
	public WebElement errorMsgStatus;

	@FindBy(id = "can_redeem_input")
	WebElement canRedeemCheckbox;

	@FindBy(id = "location_input")
	WebElement storeLocationTxt;

	@FindBy(id = "error-msg-location")
	public WebElement errorMsgLocation;

	@FindBy(id = "logo-input-file")
	public WebElement logoBt;

	@FindBy(id = "error-msg-logo")
	public WebElement errorMsgLogo;

	@FindBy(id = "cover-input-file")
	WebElement coverPhotoBt;

	@FindBy(id = "error-msg-photo")
	public WebElement errorMsgCoverPhoto;

	@FindBy(id = "form-control-email")
	WebElement addEmailTxt;

	@FindBy(id = "error-msg-email")
	public WebElement errorMsgEmail;

	@FindBy(id = "phone-0")
	WebElement phoneNumber1Txt;

	@FindBy(id = "error-msgs-phone-0")
	public WebElement errorMsgPhone1;

	@FindBy(id = "add-more-phone")
	 WebElement addMorePhone;

	@FindBy(id = "phone-1")
	WebElement phoneNumber2Txt;

	@FindBy(id = "error-msg-phone-1")
	public WebElement errorMsgPhone2;

	@FindBy(id = "submit-btn")
	WebElement saveBt;

	@FindBy(id = "success-msg")
	public WebElement sucessMsg;

	public void SelectMall() {

		Select selectMall = new Select(mallSelect);
		selectMall.selectByValue("4");
	}

	public void SelectCategory() {

		Select selectCategory = new Select(categorySelect);
		selectCategory.selectByValue("114");
	}

	public void SelectFloorNumber() {

		Select selectFloor = new Select(floorSelect);
		selectFloor.selectByValue("4");
	}

	public void AddTextInStoreNameArabic(String Value) {

		setTextElementText(storeNameArTxt, Value);
	}

	public void AddTextInStoreNameEnglish(String Value) {

		setTextElementText(storeNameEnTxt, Value);
	}

	public void AddTextInStoreDescArabic(String Value) {

		setTextElementText(storeDescriptionArTxt, Value);
	}

	public void AddTextInStoreDescEnglish(String Value) {

		setTextElementText(storeDescriptionEnTxt, Value);
	}

	public void ClickToAddAnotherShift() {

		clickButton(addMoreShiftBt);
	}

	public void SelectDay() {

		Select selectMall = new Select(daySelect);
		selectMall.selectByValue("Monday");
	}

	public void SelectDateFrom() {

		Select selectMall = new Select(dateFromSelect);
		selectMall.selectByValue("8 AM");
	}

	public void SelectDateTo() {

		Select selectMall = new Select(dateToSelect);
		selectMall.selectByValue("8 PM");
	}

	public void AddTextInLocation(String Value) {

		setTextElementText(storeLocationTxt, Value);
	}

    public void ClickToCanredeem() {

        clickButton(canRedeemCheckbox);
    }

    public void ClickToMakeStatusActive() {

        clickButton(activeRadioBt);
    }

    public void ClickToMakeStatusOpeningSoon() {

        clickButton(openingSoonRadioBt);
    }

	public void ClickToMakeCanredeem() {

		clickButton(canRedeemCheckbox);
	}

    public void UploadSVG (){

		String imageName = "SVG.svg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		logoBt.sendKeys(imagePath);
	}

	public void UploadMoreSize (){

		String imageName = "OverSize.jpg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		logoBt.sendKeys(imagePath);
	}

	public void UploadPNG (){

		String imageName = "PNG.png";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		logoBt.sendKeys(imagePath);
	}

	public void UploadJPG (){

		String imageName = "JPG.jpg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		logoBt.sendKeys(imagePath);
	}

	public void UploadSVGCover (){

		String imageName = "SVG.svg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		coverPhotoBt.sendKeys(imagePath);
	}

	public void UploadMoreSizeCover (){

		String imageName = "OverSize.jpg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		coverPhotoBt.sendKeys(imagePath);
	}

	public void UploadPNGCover (){

		String imageName = "PNG.png";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		coverPhotoBt.sendKeys(imagePath);
	}

	public void UploadJPGCover (){

		String imageName = "JPG.jpg";
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		coverPhotoBt.sendKeys(imagePath);
	}

	public void AddEmail(String Value) {

		setTextElementText(addEmailTxt, Value);
	}

	public void ClickToAddMorePhone() {

		clickButton(addMorePhone);
	}

	public void AddPhoneOne(String Value) {

		setTextElementText(phoneNumber1Txt, Value);
	}

	public void AddPhoneTwo(String Value) {

		setTextElementText(phoneNumber2Txt, Value);
	}

	public void ClickToSave() {

		clickButton(saveBt);
	}

}
