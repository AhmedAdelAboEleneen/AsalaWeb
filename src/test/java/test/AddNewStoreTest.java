package test;

import org.testng.annotations.Test;

import pages.AddNewStorePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeStoresPage;

public class AddNewStoreTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeStoresPage mangeStoresPage;
	AddNewStorePage addNewStorePage;

	// make login
	@Test(priority = 1)
	public void MakeLogin() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();

		// go to home page
		homePage = new HomePage(driver);
		homePage.ClickManageStores();
	}
	@Test(priority = 2)
	public void ClickAddNewStore (){
		mangeStoresPage = new MangeStoresPage(driver);
		mangeStoresPage.ClickToAddNewStore();
	}

}
