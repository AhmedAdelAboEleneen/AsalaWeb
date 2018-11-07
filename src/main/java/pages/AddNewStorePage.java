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
	public WebElement errorFilterByCategory;

	@FindBy(id = "floor")
	WebElement floorSelect;

	@FindBy(id = "error-msg-floor")
	public WebElement errorMsgFloor;

	@FindBy(id = "store_name_ar")
	WebElement storeNameArTxt;

	@FindBy(id = "error-msg-store_name_ar")
	public WebElement errorMsgNameAr;

	@FindBy(id = "store_name_en")
	WebElement storeNameEnTxt;

	@FindBy(id = "error-msg-store_name_en")
	public WebElement errorMsgNameEn;

	@FindBy(id = "store_description_ar")
	WebElement storeDescriptionArTxt;

	@FindBy(id = "error-msg-store_description_ar")
	public WebElement errorMsgDescriptionAr;

	@FindBy(id = "store_description_en")
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

	@FindBy(id = "")
	WebElement activeRadioBt;

	@FindBy(id = "")
	WebElement openingSoonRadioBt;


	@FindBy(id = "error-msg-status")
	public WebElement errorMsgStatus;

	@FindBy(id = "can_redeem")
	WebElement canRedeemCheckbox;

	@FindBy(id = "location")
	WebElement storeLocationTxt;

	@FindBy(id = "error-msg-location")
	public WebElement errorMsgLocation;

	@FindBy(id = "logo-input")
	WebElement logoBt;

	@FindBy(id = "error-msg-logo")
	public WebElement errorMsgLogo;

	@FindBy(id = "cover-input")
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

	@FindBy(id = "")
	WebElement addMorePhoneNumberBt;

	@FindBy(id = "submit-btn")
	WebElement saveBt;

	public void SelectMall() {

		Select selectMall = new Select(mallSelect);
		selectMall.selectByIndex(4);
	}

	public void SelectCategory() {

		Select selectMall = new Select(categorySelect);
		selectMall.selectByIndex(4);
	}

	public void SelectFloorNumber() {

		Select selectMall = new Select(floorSelect);
		selectMall.selectByIndex(4);
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
		selectMall.selectByIndex(4);
	}

	public void SelectDateFrom() {

		Select selectMall = new Select(dateFromSelect);
		selectMall.selectByIndex(9);
	}

	public void SelectDateTo() {

		Select selectMall = new Select(dateToSelect);
		selectMall.selectByIndex(20);
	}

	public void AddTextInLocation(String Value) {

		setTextElementText(storeLocationTxt, Value);
	}
}
