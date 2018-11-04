package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class MangeCategoriesTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeCategoriesPage mangeCategoriesPage;

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
	}

	// Delete Two categories
	@Test(priority = 2)
	public void DeleteCategory() throws InterruptedException {
		mangeCategoriesPage = new MangeCategoriesPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		Thread.sleep(3000);
		mangeCategoriesPage.ClickPageNumberSix();
		mangeCategoriesPage.ClickDeleteFirstCategory();
		mangeCategoriesPage.ClickConfirmDeleteCategory();
	}

}
