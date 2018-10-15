package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaLoginPage extends AsalaPageBase {

	public AsalaLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form-control-Email")
	WebElement emailTxtBox ;

	@FindBy(id="")
	public WebElement emailTxtValidtion ; 

	@FindBy(id="")
	public WebElement emailTxtValidtionWrongMailFormat ; 

	@FindBy(id="form-control-Password")
	WebElement passwordTxtBox ; 

	@FindBy(id="")
	public WebElement passwordTxtValidtion ; 

	@FindBy(id="")
	public WebElement wrongEmailOrPasswordTxt ; 

	@FindBy(id="")
	public WebElement inActiveUserText ; 

	@FindBy(id="submit-btn")
	WebElement loginBtn ; 

	@FindBy(id="forgot-password-btn")
	WebElement forgetPasswordBtn ; 

	public void AddEmail (String email) {

		setTextElementText(emailTxtBox, email);	
	}

	public void AddPassword (String password) {

		setTextElementText(passwordTxtBox, password);	
	}

	public void ClickLogin () {

		clickButton(loginBtn);	
	}

	public void ClickForgetPassword () {

		clickButton(forgetPasswordBtn);	
	}

	public void ClearEmailData () {

		emailTxtBox.clear();
	}

	public void ClearPasswordData () {

		passwordTxtBox.clear();
	}

}
