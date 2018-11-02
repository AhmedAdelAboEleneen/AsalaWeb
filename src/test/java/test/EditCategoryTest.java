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

	// if user add en name & ar name empty
	@Test(priority = 2)
	public void cleraNameEnAndAr() throws InterruptedException {

		editCategoryPage = new EditCategoryPage(driver);
		editCategoryPage.ClearNameEn();
		editCategoryPage.ClearNameAr();
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Thread.sleep(6000);
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add character less than 3 character
	@Test(priority = 3)
	public void UserAddNameEnAndNameArLessThanThreecharacter() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("Te");
		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("Te");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText()
				.contains("This field shouldn’t be less than 3 characters"));
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText()
				.contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add character more than 30 character
	@Test(priority = 4)
	public void UserAddNameEnAndNameArMoreThanMaxcharacter() throws InterruptedException {

		editCategoryPage.ClearNameEn();
		Thread.sleep(3000);
		editCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Thread.sleep(3000);
		editCategoryPage.ClearNameAr();
		Thread.sleep(3000);
		editCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Thread.sleep(3000);
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Thread.sleep(3000);
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText()
				.contains("This field shouldn’t contain more than 30 characters"));
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText()
				.contains("This field shouldn’t contain more than 30 characters"));
	}

	// if user add name en & ar empty
	@Test(priority = 5)
	public void UserAddNameEnAndNameArEmpty() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("Test");
		editCategoryPage.ClearNameAr();
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en empty & ar
	@Test(priority = 6)
	public void UserAddNameEnEmptyAndNameAr() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameArtxt("Test");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en & ar space
	@Test(priority = 7)
	public void UserAddNameEnAndNameArSpace() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("     ");
		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("     ");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	@Test(priority = 8)
	public void UserAddNameEnEmptyAndNameArEmptyAr() {

		homePage.ClickChangeLanguageToArabic();
		editCategoryPage.ClearNameEn();
		editCategoryPage.ClearNameAr();
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
	}

	// if user add name en & ar less than 3 character
	@Test(priority = 9)
	public void UserAddNameEnAndNameArLessThanThreecharacterAr() {

		editCategoryPage.AddcategoryNameEntxt("Te");
		editCategoryPage.AddcategoryNameArtxt("Te");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(
				editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
		Assert.assertTrue(
				editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
	}

	// if user add name en & ar more than 30 character
	@Test(priority = 10)
	public void UserAddNameEnAndNameArMoreThanMaxcharacterAr() throws InterruptedException {

		editCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		editCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Thread.sleep(7000);
		Assert.assertTrue(
				editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
		Assert.assertTrue(
				editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
	}

	@Test(priority = 11)
	public void UserAddNameEnAndNameAr() {

		editCategoryPage.AddcategoryNameEntxt("Ahmed Test 2");
		editCategoryPage.AddcategoryNameArtxt("Ahmed Test 2");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.successMsgtxt.getText().contains("تم إضافة تصنيف جديد بنجاح"));
	}
}
