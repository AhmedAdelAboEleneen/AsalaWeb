package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "logo-lg")
	WebElement homeBt;

	@FindBy(id = "sidebar-toggle")
	WebElement sideMenuBt;

	@FindBy(id = "manage_mall")
	WebElement manageMallsBt;

	@FindBy(id = "manage_store")
	WebElement mangeStoreBt;

	@FindBy(id = "manage_category")
	WebElement mangeCategoryBt;

	@FindBy(id = "manage_offer")
	WebElement mangeOfferBt;

	@FindBy(id = "manage_event")
	WebElement mangeEventBt;

	@FindBy(id = "mall-list-manage_store_admin")
	WebElement mangeStoreAdminBt;

	@FindBy(id = "dropdown-toggle")
	WebElement userNameBt;

	@FindBy(id = "sign-out-action")
	WebElement signOutBt;

	@FindBy(id = "edit-profile-action")
	WebElement profileBt;

	@FindBy(id = "ar")
	WebElement changeLanguageToArabicBt;

	@FindBy(id = "en")
	WebElement changeLanguageToEnglishBt;

	public void ClickHome() {

		clickButton(homeBt);
	}

	public void ClickSideMenu() {

		clickButton(sideMenuBt);
	}

	public void ClickManageMalls() {

		clickButton(manageMallsBt);
	}

	public void ClickManageStores() {

		clickButton(mangeStoreBt);
	}

	public void ClickManageCategory() {

		clickButton(mangeCategoryBt);
	}

	public void ClickManageOffer() {

		clickButton(mangeOfferBt);
	}

	public void ClickManageEvent() {

		clickButton(mangeEventBt);
	}

	public void ClickMangeStoreAdmin() {

		clickButton(mangeStoreAdminBt);
	}

	public void ClickUserName() {

		clickButton(userNameBt);
	}

	public void ClickSignOut() {

		clickButton(signOutBt);
	}

	public void ClickProfile() {

		clickButton(profileBt);
	}

	public void ClickChangeLanguageToArabic() {

		clickButton(changeLanguageToArabicBt);
	}

	public void ClickChangeLanguageToEnglish() {

		clickButton(changeLanguageToEnglishBt);
	}

}
