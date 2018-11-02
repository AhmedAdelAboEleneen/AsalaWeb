package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import asala.test.AsalaTestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class MangeCategoriesTest extends AsalaTestBase {

	LoginPage asalaLoginPage;
	HomePage asalaHomePage;
	MangeCategoriesPage asalaMangeCategoriesPage;
	
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		asalaLoginPage = new LoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page 
		asalaHomePage = new HomePage(driver);
		asalaHomePage.ClickManageCategory();
	}
	
	@Test(priority = 2)
	public void DeleteCategory () throws InterruptedException {
		asalaMangeCategoriesPage = new MangeCategoriesPage(driver);
		
		 JavascriptExecutor js =  (JavascriptExecutor) driver;
		 js.executeScript("scrollBy(0,3000)");
		 Thread.sleep(3000);
		//asalaMangeCategoriesPage.ScrollDowen();
		asalaMangeCategoriesPage.ClickPageNumberSix();
		asalaMangeCategoriesPage.ClickDeleteCategory();
		asalaMangeCategoriesPage.ClickConfirmDeleteCategory();	
		asalaMangeCategoriesPage.ClickDeleteArCategory();
		asalaMangeCategoriesPage.ClickConfirmDeleteCategory();
		
	}
	
}
