package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaEditAccountPage extends AsalaPageBase {

	public AsalaEditAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="")
	WebElement nameTxtBoxInEdit ;

	@FindBy(id="")
	WebElement emailTxtBoxInEdit ;

	@FindBy(id="")
	WebElement passwordTxtBoxInEdit ;

	@FindBy(id="")
	WebElement confirmPasswordTxtBoxInEdit ;

	@FindBy(id="")
	WebElement saveInEditBt;

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
		
		clickButton(saveInEditBt);
	}

}
