package asala.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeCategoriesPage;

public class AsalaMangeCategoriesTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaMangeCategoriesPage asalaMangeCategoriesPage;
	
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickManageCategory();
	}
	
	@Test(priority = 2)
	public void DeleteCategory () throws InterruptedException {
		asalaMangeCategoriesPage = new AsalaMangeCategoriesPage(driver);
		
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
