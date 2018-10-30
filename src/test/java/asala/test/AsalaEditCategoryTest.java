package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import asala.pages.AsalaEditCategoryPage;
import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeCategoriesPage;

public class AsalaEditCategoryTest extends AsalaTestBase {
	
	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaMangeCategoriesPage asalaMangeCategoriesPage;
	AsalaEditCategoryPage asalaEditCategoryPage;
	
	// make login
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

			// go to mange category screen 
			asalaMangeCategoriesPage = new AsalaMangeCategoriesPage(driver);
			asalaMangeCategoriesPage.ClickEditCategory();
		}
	
		@Test(priority = 2)
		public void cleraNameEnAndAr () {
			
			asalaEditCategoryPage = new AsalaEditCategoryPage(driver);
			asalaEditCategoryPage.ClearNameEn();
			asalaEditCategoryPage.ClearNameAr();
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
		}
		
}
