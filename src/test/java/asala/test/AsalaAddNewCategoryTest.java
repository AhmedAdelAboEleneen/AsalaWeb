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
	AsalaAddNewCategoryPage addNewCategoryPage;

	// make login
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
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

		addNewCategoryPage = new AsalaAddNewCategoryPage(driver);
		addNewCategoryPage.AddcategoryNameEntxt("");
		addNewCategoryPage.AddcategoryNameArtxt("");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en & ar less than 3 character 
	@Test(priority = 3)
	public void UserAddNameEnAndNameArLessThanThreecharacter() {

		addNewCategoryPage.AddcategoryNameEntxt("Te");
		addNewCategoryPage.AddcategoryNameArtxt("Te");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add name en & ar more than 30 character 
	@Test(priority = 4)
	public void UserAddNameEnAndNameArMoreThanMaxcharacter() {

		addNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		addNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 character"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 character"));
	}

	// if user add name en & ar empty 
	@Test(priority = 5)
	public void UserAddNameEnAndNameArEmpty() throws InterruptedException {

		driver.navigate().refresh();
		addNewCategoryPage.AddcategoryNameEntxt("Testtt");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
	}

	// if user add name en & ar space 
	/*@Test(priority = 6)
		public void UserAddNameEnAndNameArSpace() {

			addNewCategoryPage.ClearNameEn();
			addNewCategoryPage.AddcategoryNameEntxt("     ");
			addNewCategoryPage.ClearNameAr();
			addNewCategoryPage.AddcategoryNameArtxt("     ");
			addNewCategoryPage.ClickSumbitToAddCategory();
			Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
			Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
		}*/
	
	@Test(priority = 7)
	public void UserAddNameEnAndName() {

		driver.navigate().refresh();
		addNewCategoryPage.AddcategoryNameEntxt("cinemaaa");
		addNewCategoryPage.AddcategoryNameArtxt("سينمااااا");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.successMsgtxt.getText().contains("New category has been added successfully"));

	}
	@Test(priority = 8)
	public void UserAddNameEnEmptyAndNameArEmptyAr() {

		driver.navigate().refresh();
		asalaHomePage.ClickChangeLanguageToArabic();
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
	}

	// if user add name en & ar less than 3 character 
	@Test(priority = 9)
	public void UserAddNameEnAndNameArLessThanThreecharacterAr() {

		addNewCategoryPage.AddcategoryNameEntxt("Te");
		addNewCategoryPage.AddcategoryNameArtxt("Te");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
	}

	// if user add name en & ar more than 30 character 
	@Test(priority = 10)
	public void UserAddNameEnAndNameArMoreThanMaxcharacterAr() {

		addNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		addNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
	}

	// if user add name en & ar empty 
	@Test(priority = 11)
	public void UserAddNameEnAndNameArEmptyAr() {

		driver.navigate().refresh();
		addNewCategoryPage.AddcategoryNameEntxt("Testtt");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
	}

	// if user add name en & ar space 
	/*	@Test(priority = 12)
			public void UserAddNameEnAndNameArSpaceAr() {

				addNewCategoryPage.ClearNameEn();
				addNewCategoryPage.AddcategoryNameEntxt("     ");
				addNewCategoryPage.ClearNameAr();
				addNewCategoryPage.AddcategoryNameArtxt("     ");
				addNewCategoryPage.ClickSumbitToAddCategory();
				Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
				Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
			}*/

	@Test(priority = 13)
	public void UserAddNameEnAndNameAr() {

		driver.navigate().refresh();
		addNewCategoryPage.AddcategoryNameEntxt("cinemaa");
		addNewCategoryPage.AddcategoryNameArtxt("سينماا");
		addNewCategoryPage.ClickSumbitToAddCategory();
		Assert.assertTrue(addNewCategoryPage.successMsgtxt.getText().contains("تم إضافة تصنيف جديد بنجاح"));

	}
}
