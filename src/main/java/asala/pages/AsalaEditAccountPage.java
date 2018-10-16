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

	@FindBy(id="form-control-Password")
	WebElement passwordTxtBoxInEdit ;

	@FindBy(id="error-msg-Password")
	public WebElement passwordlValidationMessaga ;

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

	public void AddPasswordInEdit (String password) {

		setTextElementText(passwordTxtBoxInEdit, password);	
	}

	public void AddConfirmPasswordInEdit (String confirmPassword) {

		setTextElementText(confirmPasswordTxtBoxInEdit, confirmPassword);	
	}

	public void ClickSaveInEdit () {

		clickButton(submitInEditBt);
	}

}
