package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="form-control-Email")
	WebElement emailTxtBox ;

	@FindBy(id="error-msg-email")
	public WebElement emailTxtValidtion ; 

	@FindBy(id="form-control-Password")
	WebElement passwordTxtBox ; 

	@FindBy(id="error-msg-password")
	public WebElement passwordTxtValidtion ; 

	@FindBy(id="error-1")
	public WebElement wrongEmailOrPasswordOrNotActiveTxt ; 

	@FindBy(id="ar")
	WebElement changeLanguageToArabicBt ; 

	@FindBy(id="en")
	WebElement changeLanguageToEnglishBt ; 

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
	public void ClickChangeLanguageToArabic () {

		clickButton(changeLanguageToArabicBt);
	}

	public void ClickChangeLanguageToEnglish () {

		clickButton(changeLanguageToEnglishBt);
	}

}
