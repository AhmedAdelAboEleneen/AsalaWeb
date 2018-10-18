package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaHomePage extends AsalaPageBase{

	public AsalaHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="logo-lg")
	WebElement homeBt ;

	@FindBy(id="sidebar-toggle")
	WebElement sideMenuBt ;

	@FindBy(id="manage-malls")
	WebElement manageMallsBt ;

	@FindBy(id="dropdown-toggle")
	WebElement userNameBt ;

	@FindBy(id="sign-out-action")
	WebElement signOutBt ;

	@FindBy(id="edit-profile-action")
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
