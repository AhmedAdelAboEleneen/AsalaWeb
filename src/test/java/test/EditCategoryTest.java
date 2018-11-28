package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EditCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class EditCategoryTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeCategoriesPage mangeCategoriesPage;
	EditCategoryPage editCategoryPage;

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
		mangeCategoriesPage = new MangeCategoriesPage(driver);
		mangeCategoriesPage.ClickEditCategory();
	}

}