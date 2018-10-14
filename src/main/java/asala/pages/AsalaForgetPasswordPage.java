package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaForgetPasswordPage extends AsalaPageBase {

	public AsalaForgetPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="")
	WebElement emailForgetPasswordTxtBox ;

	@FindBy(id="")
	public WebElement emailForgetPasswordTxtValidtion ; 

	@FindBy(id="")
	WebElement submitForgetPasswordBtn ; 

	public void AddEmail (String email) {

		setTextElementText(emailForgetPasswordTxtBox, email);	
	}

	public void ClickSubmitForForgetPassword () {

		clickButton(submitForgetPasswordBtn);	
	}

	public void ClearEmailData () {

		emailForgetPasswordTxtBox.clear();
	}

}
