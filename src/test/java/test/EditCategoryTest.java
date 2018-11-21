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

	// if user add en name empty
	@Test(priority = 2)
	public void UserAddEnNameEmpty(){
		editCategoryPage = new EditCategoryPage(driver);
		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add en name spaces
	@Test(priority = 3)
	public void UserAddEnNameSpaces(){
		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("                   ");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add en name less than 3 character
	@Test(priority = 4)
	public void UserAddEnNameLess(){

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("Te");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add en name more than 30 character
	@Test(priority = 5)
	public void UserAddEnNameMore(){

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("HaaaaaaaaaaHaaaaaaaaaaHaaaaaaaaaaa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
	}

	// if user add en name = 3 character
	@Test(priority = 6)
	public void UserAddNameEnNameEqualLess() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("Haa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
	}

	// if user add en name = 30 character
	@Test(priority = 7)
	public void UserAddNameEnNameEqualMore() {

		editCategoryPage.ClearNameEn();
		editCategoryPage.AddcategoryNameEntxt("HaaaaaaaaaHaaaaaaaaaHaaaaaaaaa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
	}

	// if user add Ar name empty
	@Test(priority = 8)
	public void UserAddArNameEmpty(){

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add Ar name spaces
	@Test(priority = 9)
	public void UserAddArNameSpaces(){

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("                   ");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add Ar name less than 3 character
	@Test(priority = 10)
	public void UserAddArNameLess(){

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("Te");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add en name more than 30 character
	@Test(priority = 11)
	public void UserAddArNameMore(){

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("HaaaaaaaaaHaaaaaaaaaHaaaaaaaaaa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
		Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
	}

	// if user add ar name = 3 character
	@Test(priority = 12)
	public void UserAddNameArNameEqualLess() {

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("Haa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
	}

	// if user add ar name = 30 character
	@Test(priority = 13)
	public void UserAddNameArNameEqualMore() {

		editCategoryPage.ClearNameAr();
		editCategoryPage.AddcategoryNameArtxt("HaaaaaaaaaaHaaaaaaaaaaHaaaaaaaaaaa");
		editCategoryPage.ClickSumbitToConfirmEditCategory();
	}
}