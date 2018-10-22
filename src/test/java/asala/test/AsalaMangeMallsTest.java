package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeMallsPage;

public class AsalaMangeMallsTest extends AsalaTestBase {
	
	AsalaMangeMallsPage asalaMangeMallsPage;
	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;

	@Test(priority = 1)
	public void MakeLogint() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page & click user & click to get here profile 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickManageMalls();
	}
	
	@Test(priority = 2)
	public void DeactiveKadiMallEn () {
		
		asalaMangeMallsPage = new AsalaMangeMallsPage(driver);
		asalaMangeMallsPage.ClickDeactiveMall();
		asalaMangeMallsPage.ClickToConfirm();
		Assert.assertTrue(asalaMangeMallsPage.successTxt.getText().contains("The Mall has been deactivated successfully"));
	}
	
	@Test(priority = 3)
	public void ActiveKadiMallEn () {
		
		asalaMangeMallsPage = new AsalaMangeMallsPage(driver);
		asalaMangeMallsPage.ClickActiveMall();
		asalaMangeMallsPage.ClickToConfirm();
		Assert.assertTrue(asalaMangeMallsPage.successTxt.getText().contains("The Mall has been activated successfully"));
	}
	
	@Test(priority = 4)
	public void DeactiveKadiMallAr () {
		
		asalaHomePage.ClickChangeLanguageToArabic();
		asalaMangeMallsPage = new AsalaMangeMallsPage(driver);
		asalaMangeMallsPage.ClickDeactiveMall();
		asalaMangeMallsPage.ClickToConfirm();
		Assert.assertTrue(asalaMangeMallsPage.successTxt.getText().contains("تم إلغاء تفعيل المول"));
	}
	
	@Test(priority = 5)
	public void ActiveKadiMallAr () {
		
		asalaHomePage.ClickChangeLanguageToArabic();
		asalaMangeMallsPage = new AsalaMangeMallsPage(driver);
		asalaMangeMallsPage.ClickActiveMall();
		asalaMangeMallsPage.ClickToConfirm();
		Assert.assertTrue(asalaMangeMallsPage.successTxt.getText().contains("تم تفعيل المول بنجاح"));
	}
}
