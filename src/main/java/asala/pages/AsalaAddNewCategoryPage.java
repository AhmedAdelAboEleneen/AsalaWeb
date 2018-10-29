package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaAddNewCategoryPage extends AsalaPageBase {

	public AsalaAddNewCategoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form-control-catEnglishName")
	 WebElement addcategoryNameEntxt;

	@FindBy(id="error-msg-catEnglishName")
	public WebElement addcategoryNameEnErrorMsgtxt;

	@FindBy(id="form-control-catArabicName")
	 WebElement addcategoryNameArtxt;

	@FindBy(id="error-msg-catArabicName")
	public WebElement addcategoryNameArErrorMsgtxt;
	
	@FindBy(id="success-msg")
	public WebElement successMsgtxt;

	@FindBy(id="submit-btn")
	WebElement saveBt;

	public void AddcategoryNameEntxt (String EnValue) {

		setTextElementText(addcategoryNameEntxt, EnValue);
	}

	public void AddcategoryNameArtxt (String ArValue) {

		setTextElementText(addcategoryNameArtxt, ArValue);
	}

	public void ClickSumbitToAddCategory () {

		clickButton(saveBt);
	}

	public void ClearNameEn () {

		addcategoryNameEntxt.clear();
	}

	public void ClearNameAr () {

	   addcategoryNameArtxt.clear();
	}

}
