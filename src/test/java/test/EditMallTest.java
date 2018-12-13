package test;

import org.testng.annotations.Test;
import pages.*;

public class EditMallTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeMallsPage mangeMallsPage;
	EditMallPage editMallPage;

	// make login
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();

		// go to home page
		homePage = new HomePage(driver);
		homePage.ClickManageCategory();

		// go to mange category screen
		mangeMallsPage = new MangeMallsPage(driver);
	}

}
