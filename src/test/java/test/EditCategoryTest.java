package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import asala.test.AsalaTestBase;
import pages.EditCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class EditCategoryTest extends AsalaTestBase {

	LoginPage asalaLoginPage;
	HomePage asalaHomePage;
	MangeCategoriesPage asalaMangeCategoriesPage;
	EditCategoryPage asalaEditCategoryPage;

	// make login
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

		// go to mange category screen 
		asalaMangeCategoriesPage = new MangeCategoriesPage(driver);
		asalaMangeCategoriesPage.ClickEditCategory();
	}

	// if user add en name & ar name empty 
	@Test(priority = 2)
	public void cleraNameEnAndAr () throws InterruptedException {

		asalaEditCategoryPage = new EditCategoryPage(driver);
		asalaEditCategoryPage.ClearNameEn();
		asalaEditCategoryPage.ClearNameAr();
		asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
		Thread.sleep(6000);
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add character less than 3 character 
	@Test(priority = 3)
	public void UserAddNameEnAndNameArLessThanThreecharacter() {

		asalaEditCategoryPage.ClearNameEn();
		asalaEditCategoryPage.AddcategoryNameEntxt("Te");
		asalaEditCategoryPage.ClearNameAr();
		asalaEditCategoryPage.AddcategoryNameArtxt("Te");
		asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add character more than 30 character 
	@Test(priority = 4)
	public void UserAddNameEnAndNameArMoreThanMaxcharacter() throws InterruptedException {
		
		asalaEditCategoryPage.ClearNameEn();
		Thread.sleep(3000);
		asalaEditCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Thread.sleep(3000);
		asalaEditCategoryPage.ClearNameAr();
		Thread.sleep(3000);
		asalaEditCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Thread.sleep(3000);
		asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
		Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
	}
	
	// if user add name en & ar empty 
		@Test(priority = 5)
		public void UserAddNameEnAndNameArEmpty(){

			asalaEditCategoryPage.ClearNameEn();
			asalaEditCategoryPage.AddcategoryNameEntxt("Test");
			asalaEditCategoryPage.ClearNameAr();
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
		}

		// if user add name en empty & ar 
		@Test(priority = 6)
		public void UserAddNameEnEmptyAndNameAr(){

			asalaEditCategoryPage.ClearNameEn();
			asalaEditCategoryPage.AddcategoryNameArtxt("Test");
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		}
		
		// if user add name en & ar space 
		@Test(priority = 7)
		public void UserAddNameEnAndNameArSpace() {

			asalaEditCategoryPage.ClearNameEn();
			asalaEditCategoryPage.AddcategoryNameEntxt("     ");
			asalaEditCategoryPage.ClearNameAr();
			asalaEditCategoryPage.AddcategoryNameArtxt("     ");
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
		}
		
		@Test(priority = 8)
		public void UserAddNameEnEmptyAndNameArEmptyAr() {

			asalaHomePage.ClickChangeLanguageToArabic();
			asalaEditCategoryPage.ClearNameEn();
			asalaEditCategoryPage.ClearNameAr();
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
		}
		
		// if user add name en & ar less than 3 character 
		@Test(priority = 9)
		public void UserAddNameEnAndNameArLessThanThreecharacterAr() {

			asalaEditCategoryPage.AddcategoryNameEntxt("Te");
			asalaEditCategoryPage.AddcategoryNameArtxt("Te");
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
		}

		// if user add name en & ar more than 30 character 
		@Test(priority = 10)
		public void UserAddNameEnAndNameArMoreThanMaxcharacterAr() throws InterruptedException {

			asalaEditCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			asalaEditCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Thread.sleep(7000);
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
			Assert.assertTrue(asalaEditCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
		}
		
		@Test(priority = 11)
		public void UserAddNameEnAndNameAr() {

			asalaEditCategoryPage.AddcategoryNameEntxt("Ahmed Test 2");
			asalaEditCategoryPage.AddcategoryNameArtxt("Ahmed Test 2");
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			asalaEditCategoryPage.ClickSumbitToConfirmEditCategory();
			Assert.assertTrue(asalaEditCategoryPage.successMsgtxt.getText().contains("تم إضافة تصنيف جديد بنجاح"));
		}
}
