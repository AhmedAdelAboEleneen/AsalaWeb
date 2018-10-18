package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaEditAccountPage extends AsalaPageBase {

	public AsalaEditAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form-control-Name")
	WebElement nameTxtBoxInEdit ;

	@FindBy(id="error-msgs-name")
	public WebElement nameValidationMessaga ;

	@FindBy(id="form-control-Email")
	WebElement emailTxtBoxInEdit ;

	@FindBy(id="error-msg-Email")
	public WebElement emailValidationMessaga ;

	@FindBy(id="form-control-old_password")
	WebElement OldPasswordTxtBoxInEdit ;

	@FindBy(id="error-msg-old_password")
	public WebElement OldPasswordlValidationMessaga ;
	
	@FindBy(id="form-control-new_password")
	public WebElement newPasswordTxtBoxInEdit ;
	
	@FindBy(id="error-msg-new_password")
	public WebElement newPasswordlValidationMessaga ;

	@FindBy(id="form-control-Confirm Password")
	WebElement confirmPasswordTxtBoxInEdit ;

	@FindBy(id="error-msg-Confirm Password")
	public WebElement confirmPasswordlValidationMessaga ;

	@FindBy(id="submit-btn")
	WebElement submitInEditBt;

	public void AddNameInEdit (String name) {

		setTextElementText(nameTxtBoxInEdit, name);	
	}
	
	public void AddEmailInEdit (String email) {

		setTextElementText(emailTxtBoxInEdit, email);	
	}

	public void AddOldPasswordInEdit (String password) {

		setTextElementText(OldPasswordTxtBoxInEdit, password);	
	}
	
	public void AddNewPasswordInEdit (String Newpassword) {

		setTextElementText(newPasswordTxtBoxInEdit, Newpassword);	
	}

	public void AddConfirmPasswordInEdit (String confirmPassword) {

		setTextElementText(confirmPasswordTxtBoxInEdit, confirmPassword);	
	}

	public void ClickSaveInEdit () {

		clickButton(submitInEditBt);
	}
	
	public void ClearNameData () {

		nameTxtBoxInEdit.clear();
	}
	
	public void ClearEmailData () {

		emailTxtBoxInEdit.clear();
	}
	
	public void ClearOldPasswordData () {

		OldPasswordTxtBoxInEdit.clear();
	}
	
	public void ClearNewPasswordData () {

		newPasswordTxtBoxInEdit.clear();
	}
	
	public void ClearConfirmpasswrodData () {

		confirmPasswordTxtBoxInEdit.clear();
	}

}
