package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaHomePage extends AsalaPageBase{

	public AsalaHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="")
	WebElement homeBt ;

	@FindBy(id="")
	WebElement sideMenuBt ;

	@FindBy(id="")
	WebElement manageMallsBt ;

	@FindBy(id="")
	WebElement userNameBt ;

	@FindBy(id="")
	WebElement signOutBt ;

	@FindBy(id="")
	WebElement profileBt ;

	public void ClickHome () {

		clickButton(homeBt);
	}

	public void ClickSideMenu () {

		clickButton(sideMenuBt);
	}
	public void ClickManageMalls () {

		clickButton(manageMallsBt);
	}
	public void ClickUserName () {

		clickButton(userNameBt);
	}
	public void ClickSignOut () {

		clickButton(signOutBt);
	}
	public void ClickProfile () {

		clickButton(profileBt);
	}

}
