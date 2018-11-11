package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewStorePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeStoresPage;

public class AddNewStoreTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeStoresPage mangeStoresPage;
	AddNewStorePage addNewStorePage;
	JavascriptExecutor js;

	// make login
	@Test(priority = 1)
	public void MakeLogin() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();
		// go to home page
		homePage = new HomePage(driver);
		homePage.ClickManageStores();
	}
	// click on add new store
	@Test(priority = 2)
	public void ClickAddNewStore (){
		mangeStoresPage = new MangeStoresPage(driver);
		mangeStoresPage.ClickToAddNewStore();
	}
	// check if mall empty display validation message
	@Test(priority = 3)
	public void IfUserChoseMallEmpty(){
		addNewStorePage = new AddNewStorePage(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMallSelect.getText().contains("Please select a Mall"));
		driver.navigate().refresh();
	}

	// check if category empty display validation message
	/*@Test(priority = 4)
	public void IfUserChoseCategoryEmpty() {
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorCategorySelect.getText().contains("Please select a category"));
		driver.navigate().refresh();

	}

	// check if floor empty display validation message
	@Test(priority = 5)
	public void IfUserChoseFloorEmpty() {
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgFloor.getText().contains("Please select a floor"));
		driver.navigate().refresh();
	}
	// check if user chose mall but empty Category & Floor
	@Test(priority = 6)
	public void IfUserChoseMallButEmptyCategoryAndFloor() {
		addNewStorePage.SelectMall();
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorCategorySelect.getText().contains("Please select a category"));
		Assert.assertTrue(addNewStorePage.errorMsgFloor.getText().contains("Please select a floor"));
		driver.navigate().refresh();
	}

	// check if user chose mall & category but empty  Floor
	@Test(priority = 7)
	public void IfUserChoseMallAndCategoryButEmptyFloor() throws InterruptedException {
		addNewStorePage.SelectMall();
		Thread.sleep(3000);
		addNewStorePage.SelectCategory();
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgFloor.getText().contains("Please select a floor"));
		driver.navigate().refresh();
	}

	// check if user chose mall & category & Floor
	@Test(priority = 8)
	public void IfUserChoseMallAndCategoryAndFloor() throws InterruptedException {
		addNewStorePage.SelectMall();
		Thread.sleep(3000);
		addNewStorePage.SelectCategory();
		addNewStorePage.SelectFloorNumber();
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		driver.navigate().refresh();
	}
	// if user add name Arabic Empty
	@Test(priority = 9)
	public void IfUseAddNameArabicEmpty(){
		addNewStorePage.AddTextInStoreNameArabic("");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field is required"));
		driver.navigate().refresh();
	}
	// if user add name Arabic Spaces
	@Test(priority = 10)
	public void IfUseAddNameArabicSpaces(){
		addNewStorePage.AddTextInStoreNameArabic("        ");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field is required"));
		driver.navigate().refresh();
	}

	// if user add name Arabic less than 3 char
	@Test(priority = 11)
	public void IfUseAddNameArabicLess(){
		addNewStorePage.AddTextInStoreNameArabic("Te");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
		driver.navigate().refresh();
	}

	// if user add name Arabic more than 50 char
	@Test(priority = 12)
	public void IfUseAddNameArabicMore(){
		addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 50 characters"));
		driver.navigate().refresh();
	}

	// if user add name Arabic 3 char
	@Test(priority = 13)
	public void IfUseAddNameArabicThree(){
		addNewStorePage.AddTextInStoreNameArabic("Tee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
		driver.navigate().refresh();
	}

	// if user add name Arabic 50 char
	@Test(priority = 14)
	public void IfUseAddNameArabicFifty(){
		addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 50 characters"));
		driver.navigate().refresh();
	}

	// if user add name English Empty
	@Test(priority = 15)
	public void IfUseAddNameEnglishEmpty(){
		addNewStorePage.AddTextInStoreNameEnglish("");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field is required"));
		driver.navigate().refresh();
	}
	// if user add name English Spaces
	@Test(priority = 16)
	public void IfUseAddNameEnglishSpaces(){
		addNewStorePage.AddTextInStoreNameEnglish("        ");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field is required"));
		driver.navigate().refresh();
	}

	// if user add name English less than 3 char
	@Test(priority = 17)
	public void IfUseAddNameEnglishLess(){
		addNewStorePage.AddTextInStoreNameEnglish("Te");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
		driver.navigate().refresh();
	}

	// if user add name English more than 50 char
	@Test(priority = 18)
	public void IfUseAddNameEnglishMore(){
		addNewStorePage.AddTextInStoreNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 50 characters"));
		driver.navigate().refresh();
	}

	// if user add name English 3 char
	@Test(priority = 19)
	public void IfUseAddNameEnglishThree(){
		addNewStorePage.AddTextInStoreNameEnglish("Tee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
		driver.navigate().refresh();
	}

	// if user add name Arabic 50 char
	@Test(priority = 20)
	public void IfUseAddNameEnglishFifty(){
		addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 50 characters"));
		driver.navigate().refresh();
	}

	// if user add desc Arabic Empty
	@Test(priority = 21)
	public void IfUseAddDescArabicEmpty(){
		addNewStorePage.AddTextInStoreDescArabic("");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field is required"));
		driver.navigate().refresh();
	}
	// if user add desc Arabic Spaces
	@Test(priority = 22)
	public void IfUseAddDescArabicSpaces(){
		addNewStorePage.AddTextInStoreDescArabic("              ");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field is required"));
		driver.navigate().refresh();
	}

	// if user add desc Arabic less than 100 char
	@Test(priority = 23)
	public void IfUseAddDescArabicLess(){
		addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t be less than 100 characters"));
		driver.navigate().refresh();
	}

	// if user add desc Arabic more than 500 char
	@Test(priority = 24)
	public void IfUseAddDescArabicMore(){
		addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t contain more than 500 characters"));
		driver.navigate().refresh();
	}

	// if user add desc Arabic 100 char
	@Test(priority = 25)
	public void IfUseAddDescArabicThree(){
		addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t be less than 100 characters"));
		driver.navigate().refresh();
	}

	// if user add desc Arabic 500 char
	@Test(priority = 26)
	public void IfUseAddDescArabicFifty(){
		addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t contain more than 500 characters"));
		driver.navigate().refresh();
	}

	// if user add desc English Empty
	@Test(priority = 27)
	public void IfUseAddDescEnglishEmpty(){
		addNewStorePage.AddTextInStoreDescEnglish("");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field is required"));
		driver.navigate().refresh();
	}
	// if user add desc English Spaces
	@Test(priority = 28)
	public void IfUseAddDescEnglishSpaces(){
		addNewStorePage.AddTextInStoreDescEnglish("              ");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field is required"));
		driver.navigate().refresh();
	}

	// if user add desc English less than 100 char
	@Test(priority = 29)
	public void IfUseAddDescEnglishLess(){
		addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t be less than 100 characters"));
		driver.navigate().refresh();
	}

	// if user add desc English more than 50 char
	@Test(priority = 30)
	public void IfUseAddDescEnglishMore(){
		addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t contain more than 500 characters"));
		driver.navigate().refresh();
	}

	// if user add desc English 3 char
	@Test(priority = 31)
	public void IfUseAddDescEnglishThree(){
		addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t be less than 100 characters"));
		driver.navigate().refresh();
	}

	// if user add desc English 50 char
	@Test(priority = 32)
	public void IfUseAddDescEnglishFifty(){
		addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		js.executeScript("scrollBy(0,-3000)");
		Assert.assertFalse(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t contain more than 500 characters"));
		driver.navigate().refresh();
	}

	// if user chose shift
	@Test(priority = 33)
	public void IfUserChoseShift(){
		addNewStorePage.SelectDay();
		addNewStorePage.SelectDateFrom();
		addNewStorePage.SelectDateTo();
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		driver.navigate().refresh();
	}

	// if user chose shift more than one shift
	@Test(priority = 34)
	public void IfUserChoseShiftMoreThanOneShift(){
		addNewStorePage.ClickToAddAnotherShift();
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		driver.navigate().refresh();
	}

	// check if user don't chose status display validation message
	@Test(priority = 35)
	public void IfUserDontChoseStatus(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgStatus.getText().contains("Please select a status"));
		driver.navigate().refresh();
	}

	// check if user chose status (Active) display validation message
	@Test(priority = 36)
	public void IfUserChoseStatusActive(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToMakeStatusActive();
		addNewStorePage.ClickToSave();
		Assert.assertFalse(addNewStorePage.errorMsgStatus.getText().contains("Please select a status"));
		driver.navigate().refresh();
	}

	// check if user chose status (Opening Soon) display validation message
	@Test(priority = 37)
	public void IfUserChoseStatusOpeningSoon(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToMakeStatusOpeningSoon();
		addNewStorePage.ClickToSave();
		Assert.assertFalse(addNewStorePage.errorMsgStatus.getText().contains("Please select a status"));
		//driver.navigate().refresh();
	}

	// check if user don't add location  display validation message
	@Test(priority = 38)
	public void IfUserDontAddLocation(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgLocation.getText().contains("please enter the location"));
		//driver.navigate().refresh();
	}

	// logo
	// check if user upload photo empty display validation message
	@Test(priority = 39)
	public void IfUserUploadphotoEmpty(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Please upload a photo"));
		//driver.navigate().refresh();
	}

	// logo
	// check if user upload photo svg display validation message
	@Test(priority = 40)
	public void IfUserUploadSvgPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadSVG();
		Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Accept files in jpg, png and image format"));
		//driver.navigate().refresh();
	}

	// logo
	// check if user upload photo more 1 mb display validation message
	@Test(priority = 41)
	public void IfUserUploadOverSize(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadMoreSize();
		Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}

	// logo
	// check if user upload PNG display validation message
	@Test(priority = 42)
	public void IfUserUploadPngPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadPNG();
		//Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}

	// logo
	// check if user upload JPG display validation message
	@Test(priority = 43)
	public void IfUserUploadJpgPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadJPG();
		//Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}

	// cover photo
	// check if user upload cover photo empty display validation message
	@Test(priority = 44)
	public void IfUserUploadphotoEmptyCover(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Please upload a photo"));
		//driver.navigate().refresh();
	}

	// cover photo
	// check if user upload cover photo svg display validation message
	@Test(priority = 45)
	public void IfUserUploadSvgCoverPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadSVGCover();
		Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Accept files in jpg, png and image format"));
		//driver.navigate().refresh();
	}

	// cover photo
	// check if user upload cover photo more 1 mb display validation message
	@Test(priority = 46)
	public void IfUserUploadOverSizeCover(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadMoreSizeCover();
		Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}

	// cover photo
	// check if user upload PNG display validation message
	@Test(priority = 47)
	public void IfUserUploadPngCoverPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadPNGCover();
		//Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}

	// cover photo
	// check if user upload JPG display validation message
	@Test(priority = 48)
	public void IfUserUploadJpgCoverPhoto(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.UploadJPG();
		//Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Photo size shouldn't be more than 1 Mb"));
		//driver.navigate().refresh();
	}*/

	// check if user add email empty display validation message
	@Test(priority = 49)
	public void IfUserAddEmailEmpty(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("please add an email"));
		driver.navigate().refresh();
	}
	// check if user add email spaces display validation message
	@Test(priority = 50)
	public void IfUserAddEmailSpaces(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.AddEmail("          ");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("please add an email"));
		driver.navigate().refresh();
	}

	// check if user add email wrong Format display validation message
	@Test(priority = 50)
	public void IfUserAddEmailWrongformat(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.AddEmail("test");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("Please enter a valid email"));
		driver.navigate().refresh();
	}

	// check if user add email numbers  display validation message
	@Test(priority = 51)
	public void IfUserAddEmailNumbers(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.AddEmail("1234");
		addNewStorePage.ClickToSave();
		Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("Please enter a valid email"));
		driver.navigate().refresh();
	}

	// check if user add valid email don't display validation message
	@Test(priority = 52)
	public void IfUserAddValidEmail(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		addNewStorePage.AddEmail("a@a.aa");
		addNewStorePage.ClickToSave();
		Assert.assertFalse(addNewStorePage.errorMsgEmail.getText().contains("Please enter a valid email"));
		//driver.navigate().refresh();
	}
}
