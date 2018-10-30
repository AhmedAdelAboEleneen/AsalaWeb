package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import asala.pages.AsalaAddNewCategoryPage;
import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeCategoriesPage;

public class AsalaAddNewCategoryTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaMangeCategoriesPage asalaMangeCategoriesPage;
	AsalaAddNewCategoryPage asalaaddNewCategoryPage;

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
		asalaMangeCategoriesPage.ClickToAddNewCategory();
	}

	// if user add name en & ar empty 
	@Test(priority = 2)
	public void UserAddNameEnEmptyAndNameArEmpty() {

		asalaaddNewCategoryPage = new AsalaAddNewCategoryPage(driver);
		asalaaddNewCategoryPage.AddcategoryNameEntxt("");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en & ar less than 3 character 
	@Test(priority = 3)
	public void UserAddNameEnAndNameArLessThanThreecharacter() {

		asalaaddNewCategoryPage.AddcategoryNameEntxt("Te");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("Te");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add name en & ar more than 30 character 
	@Test(priority = 4)
	public void UserAddNameEnAndNameArMoreThanMaxcharacter() throws InterruptedException {

		asalaaddNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Thread.sleep(3000);
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 character"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 character"));
	}

	// if user add name en & ar empty 
	@Test(priority = 5)
	public void UserAddNameEnAndNameArEmpty() throws InterruptedException {

		//driver.navigate().refresh();
		asalaaddNewCategoryPage.ClearNameEn();
		asalaaddNewCategoryPage.AddcategoryNameEntxt("Testtt");
		asalaaddNewCategoryPage.ClearNameAr();
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en & ar space 
	@Test(priority = 6)
		public void UserAddNameEnAndNameArSpace() {

			asalaaddNewCategoryPage.ClearNameEn();
			asalaaddNewCategoryPage.AddcategoryNameEntxt("     ");
			asalaaddNewCategoryPage.ClearNameAr();
			asalaaddNewCategoryPage.AddcategoryNameArtxt("     ");
			asalaaddNewCategoryPage.ClickSumbitToAddCategory();
			Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
			Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
		}
	
	@Test(priority = 7)
	public void UserAddNameEnAndName() throws InterruptedException {

		driver.navigate().refresh();
		asalaaddNewCategoryPage.AddcategoryNameEntxt("DFAasfas");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("gsdgasfasfasfsdg");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Thread.sleep(3000);
		Assert.assertTrue(asalaaddNewCategoryPage.successMsgtxt.getText().contains("New category has been added successfully"));

	}
	@Test(priority = 8)
	public void UserAddNameEnEmptyAndNameArEmptyAr() {

		driver.navigate().refresh();
		asalaHomePage.ClickChangeLanguageToArabic();
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
	}

	// if user add name en & ar less than 3 character 
	@Test(priority = 9)
	public void UserAddNameEnAndNameArLessThanThreecharacterAr() {

		asalaaddNewCategoryPage.AddcategoryNameEntxt("Te");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("Te");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
	}

	// if user add name en & ar more than 30 character 
	@Test(priority = 10)
	public void UserAddNameEnAndNameArMoreThanMaxcharacterAr() throws InterruptedException {

		asalaaddNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Thread.sleep(3000);
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
	}

	// if user add name en & ar empty 
	@Test(priority = 11)
	public void UserAddNameEnAndNameArEmptyAr() {

		driver.navigate().refresh();
		asalaaddNewCategoryPage.AddcategoryNameEntxt("Testtt");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
	}

	// if user add name en & ar space 
		@Test(priority = 12)
			public void UserAddNameEnAndNameArSpaceAr() {

				asalaaddNewCategoryPage.ClearNameEn();
				asalaaddNewCategoryPage.AddcategoryNameEntxt("     ");
				asalaaddNewCategoryPage.ClearNameAr();
				asalaaddNewCategoryPage.AddcategoryNameArtxt("     ");
				asalaaddNewCategoryPage.ClickSumbitToAddCategory();
				Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
				Assert.assertTrue(asalaaddNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
			}

	@Test(priority = 13)
	public void UserAddNameEnAndNameAr() throws InterruptedException {

		driver.navigate().refresh();
		asalaaddNewCategoryPage.AddcategoryNameEntxt("daDADda");
		asalaaddNewCategoryPage.AddcategoryNameArtxt("khkh,DAD,DADaD,");
		asalaaddNewCategoryPage.ClickSumbitToAddCategory();
		Thread.sleep(6000);
		Assert.assertTrue(asalaaddNewCategoryPage.successMsgtxt.getText().contains("تم إضافة تصنيف جديد بنجاح"));

	}
}
