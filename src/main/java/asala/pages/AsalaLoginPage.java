package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaLoginPage extends AsalaPageBase {

	public AsalaLoginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(css="#root > div > div > div.login-box-body > form > div:nth-child(1) > input")
	WebElement emailTxtBox ;

	@FindBy(css="#root > div > div > div.login-box-body > form > div:nth-child(1) > div > span")
	public WebElement emailTxtValidtion ; 

	@FindBy(css="#root > div > div > div.login-box-body > form > div:nth-child(1) > div > span")
	public WebElement emailTxtValidtionWrongMailFormat ; 

	@FindBy(css="#root > div > div > div.login-box-body > form > div:nth-child(2) > input")
	WebElement passwordTxtBox ; 

	@FindBy(css="#root > div > div > div.login-box-body > form > div:nth-child(2) > div > span")
	public WebElement passwordTxtValidtion ; 

	@FindBy(css="#root > div > div > div.login-box-body > div")
	public WebElement wrongEmailOrPasswordTxt ; 


	@FindBy(css="#root > div > div > div.login-box-body > div")
	public WebElement inActiveUserText ; 

	@FindBy(css="#root > div > div > div.login-box-body > form > div.row > div > button")
	WebElement loginBtn ; 

	@FindBy(css="#root > div > div > div.login-box-body > form > a")
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
