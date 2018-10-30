package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaEditCategoryPage extends AsalaPageBase {

	public AsalaEditCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="form-control-catEnglishName")
	 WebElement editcategoryNameEntxt;

	@FindBy(id="error-msg-catEnglishName")
	public WebElement editcategoryNameEnErrorMsgtxt;

	@FindBy(id="form-control-catArabicName")
	 WebElement editcategoryNameArtxt;

	@FindBy(id="error-msg-catArabicName")
	public WebElement editcategoryNameArErrorMsgtxt;
	
	@FindBy(id="success-msg")
	public WebElement successMsgtxt;

	@FindBy(id="save-btn")
	WebElement editSaveBt;
	

	public void AddcategoryNameEntxt (String EnValue) {

		setTextElementText(editcategoryNameEntxt, EnValue);
	}

	public void AddcategoryNameArtxt (String ArValue) {

		setTextElementText(editcategoryNameArtxt, ArValue);
	}

	public void ClickSumbitToConfirmEditCategory () {

		clickButton(editSaveBt);
	}

	public void ClearNameEn () {

		editcategoryNameEntxt.clear();
	}

	public void ClearNameAr () {

		editcategoryNameArtxt.clear();
	}


}
