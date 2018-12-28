package test;

import com.github.javafaker.Faker;
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

    Faker fakeData = new Faker();

    String location1 = fakeData.address().cityName();
    String location2 = fakeData.address().cityName();
    String location4 = fakeData.address().cityName();
    String location5 = fakeData.address().cityName();
    String location6 = fakeData.address().cityName();
    String location7 = fakeData.address().cityName();
    String location8 = fakeData.address().cityName();
    String location9 = fakeData.address().cityName();
    String location10 = fakeData.address().cityName();
    String location11 = fakeData.address().cityName();
    String location12 = fakeData.address().cityName();

    String name1 = fakeData.name().name();
    String name2 = fakeData.name().fullName();
    String name3 = fakeData.name().firstName();
    String name4 = fakeData.name().lastName();
    String name5 = fakeData.name().nameWithMiddle();
    String name6 = fakeData.name().title();
    String name7 = fakeData.name().prefix();
    String name8 = fakeData.name().suffix();
    String name9 = fakeData.name().username();

    String email1 = fakeData.internet().emailAddress();
    String email2 = fakeData.internet().emailAddress();
    String email3 = fakeData.internet().emailAddress();
    String email4 = fakeData.internet().emailAddress();
    String email5 = fakeData.internet().emailAddress();
    String email6 = fakeData.internet().emailAddress();
    String email7 = fakeData.internet().emailAddress();

    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        //loginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click mange stores
        homePage = new HomePage(driver);
        homePage.ClickManageStores();

        // click on add new store
        mangeStoresPage = new MangeStoresPage(driver);
        mangeStoresPage.ClickToAddNewStore();
    }

    // check if mall empty display validation message
    @Test(priority = 2)
    public void IfUserChoseMallEmpty() {
        addNewStorePage = new AddNewStorePage(driver);
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMallSelect.getText().contains("Please select a Mall"));
        driver.navigate().refresh();
    }

    // check if category empty display validation message
    @Test(priority = 3)
    public void IfUserChoseCategoryEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorCategorySelect.getText().contains("Please select a category"));
        driver.navigate().refresh();

    }

    // check if floor empty display validation message
    @Test(priority = 4)
    public void IfUserChoseFloorEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgFloor.getText().contains("Please select a floor"));
        driver.navigate().refresh();
    }

    // check if user chose mall but empty Category & Floor
    @Test(priority = 5)
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
    @Test(priority = 6)
    public void IfUserChoseMallAndCategoryButEmptyFloor() throws InterruptedException {
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgFloor.getText().contains("Please select a floor"));
        driver.navigate().refresh();
    }

    // check if user chose mall & category & Floor
    @Test(priority = 7)
    public void IfUserChoseMallAndCategoryAndFloor() throws InterruptedException {
        addNewStorePage.SelectMall();
        Thread.sleep(7000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add name Arabic Empty
    @Test(priority = 8)
    public void IfUseAddNameArabicEmpty() {
        addNewStorePage.AddTextInStoreNameArabic("");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic Spaces
    @Test(priority = 9)
    public void IfUseAddNameArabicSpaces() {
        addNewStorePage.AddTextInStoreNameArabic("        ");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic less than 3 char
    @Test(priority = 10)
    public void IfUseAddNameArabicLess() {
        addNewStorePage.AddTextInStoreNameArabic("Te");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic more than 50 char
    @Test(priority = 11)
    public void IfUseAddNameArabicMore() {
        addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 50 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic 3 char
    @Test(priority = 12)
    public void IfUseAddNameArabicThree() {
        addNewStorePage.AddTextInStoreNameArabic("Tee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add name Arabic 50 char
    @Test(priority = 13)
    public void IfUseAddNameArabicFifty() {
        addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add name English Empty
    @Test(priority = 14)
    public void IfUseAddNameEnglishEmpty() {
        addNewStorePage.AddTextInStoreNameEnglish("");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English Spaces
    @Test(priority = 15)
    public void IfUseAddNameEnglishSpaces() {
        addNewStorePage.AddTextInStoreNameEnglish("        ");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English less than 3 char
    @Test(priority = 16)
    public void IfUseAddNameEnglishLess() {
        addNewStorePage.AddTextInStoreNameEnglish("Te");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name English more than 50 char
    @Test(priority = 17)
    public void IfUseAddNameEnglishMore() {
        addNewStorePage.AddTextInStoreNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 50 characters"));
        driver.navigate().refresh();
    }

    // if user add name English 3 char
    @Test(priority = 18)
    public void IfUseAddNameEnglishThree() {
        addNewStorePage.AddTextInStoreNameEnglish("Tee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add name Arabic 50 char
    @Test(priority = 19)
    public void IfUseAddNameEnglishFifty() {
        addNewStorePage.AddTextInStoreNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeBeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add desc Arabic Empty
    @Test(priority = 20)
    public void IfUseAddDescArabicEmpty() {
        addNewStorePage.AddTextInStoreDescArabic("");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic Spaces
    @Test(priority = 21)
    public void IfUseAddDescArabicSpaces() {
        addNewStorePage.AddTextInStoreDescArabic("              ");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic less than 100 char
    @Test(priority = 22)
    public void IfUseAddDescArabicLess() {
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic more than 500 char
    @Test(priority = 23)
    public void IfUseAddDescArabicMore() {
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionAr.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic 100 char
    @Test(priority = 24)
    public void IfUseAddDescArabicThree() {
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add desc Arabic 500 char
    @Test(priority = 25)
    public void IfUseAddDescArabicFifty() {
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add desc English Empty
    @Test(priority = 26)
    public void IfUseAddDescEnglishEmpty() {
        addNewStorePage.AddTextInStoreDescEnglish("");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English Spaces
    @Test(priority = 27)
    public void IfUseAddDescEnglishSpaces() {
        addNewStorePage.AddTextInStoreDescEnglish("              ");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English less than 100 char
    @Test(priority = 28)
    public void IfUseAddDescEnglishLess() {
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English more than 500 char
    @Test(priority = 29)
    public void IfUseAddDescEnglishMore() {
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Assert.assertTrue(addNewStorePage.errorMsgDescriptionEn.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English 100 char
    @Test(priority = 30)
    public void IfUseAddDescEnglishThree() {
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user add desc English 500 char
    @Test(priority = 31)
    public void IfUseAddDescEnglishFifty() {
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        driver.navigate().refresh();
    }

    // if user chose shift
    @Test(priority = 32)
    public void IfUserChoseShift() {
        addNewStorePage.SelectDay();
        addNewStorePage.SelectDateFrom();
        addNewStorePage.SelectDateTo();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user chose shift more than one shift
    @Test(priority = 33)
    public void IfUserChoseShiftMoreThanOneShift() {
        addNewStorePage.ClickToAddAnotherShift();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user don't chose status display validation message
    @Test(priority = 34)
    public void IfUserDontChoseStatus() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgStatus.getText().contains("Please select a status"));
        driver.navigate().refresh();
    }

    // check if user chose status (Active) display validation message
    @Test(priority = 35)
    public void IfUserChoseStatusActive() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user chose status (Opening Soon) display validation message
    @Test(priority = 36)
    public void IfUserChoseStatusOpeningSoon() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user don't add location  display validation message
    @Test(priority = 37)
    public void IfUserDontAddLocation() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgLocation.getText().contains("please enter the location"));
        driver.navigate().refresh();
    }

    // logo
    // check if user upload photo empty display validation message
    @Test(priority = 38)
    public void IfUserUploadphotoEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Please upload a photo"));
        driver.navigate().refresh();
    }

    // logo
    // check if user upload photo svg display validation message
    @Test(priority = 39)
    public void IfUserUploadSvgPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadSVG();
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Accept files in jpg, png and image format"));
        driver.navigate().refresh();
    }

    // logo
    // check if user upload photo more 1 mb display validation message
    @Test(priority = 40)
    public void IfUserUploadOverSize() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        Thread.sleep(3000);
        addNewStorePage.UploadMoreSize();
        addNewStorePage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewStorePage.errorMsgLogo.getText().contains("Photo size shouldn’t be more than 1 Mb"));
        driver.navigate().refresh();
    }

    // logo
    // check if user upload PNG
    @Test(priority = 41)
    public void IfUserUploadPngPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadPNG();
        driver.navigate().refresh();
    }

    // logo
    // check if user upload JPG
    @Test(priority = 42)
    public void IfUserUploadJpgPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadJPG();
        driver.navigate().refresh();
    }

    // cover photo
    // check if user upload cover photo empty display validation message
    @Test(priority = 43)
    public void IfUserUploadphotoEmptyCover() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Please upload a photo"));
        driver.navigate().refresh();
    }

    // cover photo
    // check if user upload cover photo svg display validation message
    @Test(priority = 44)
    public void IfUserUploadSvgCoverPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadSVGCover();
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Accept files in jpg, png and image format"));
        driver.navigate().refresh();
    }

    // cover photo
    // check if user upload cover photo more 1 mb display validation message
    @Test(priority = 45)
    public void IfUserUploadOverSizeCover() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadMoreSizeCover();
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgCoverPhoto.getText().contains("Photo size shouldn’t be more than 1 Mb"));
        driver.navigate().refresh();
    }

    // cover photo
    // check if user upload PNG
    @Test(priority = 46)
    public void IfUserUploadPngCoverPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadPNGCover();
        driver.navigate().refresh();
    }

    // cover photo
    // check if user upload JPG
    @Test(priority = 47)
    public void IfUserUploadJpgCoverPhoto() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.UploadJPGCover();
        driver.navigate().refresh();
    }


    // check if user add email wrong Format display validation message
    @Test(priority = 48)
    public void IfUserAddEmailWrongformat() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddEmail("test");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add email numbers  display validation message
    @Test(priority = 49)
    public void IfUserAddEmailNumbers() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddEmail("1234");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add valid email don't display validation message
    @Test(priority = 50)
    public void IfUserAddValidEmail() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddEmail("a@a.aa");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone text display validation message
    @Test(priority = 51)
    public void IfUserAddPhoneText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("Zeoo");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgPhone1.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone wrong display validation message
    @Test(priority = 52)
    public void IfUserAddPhoneWrong() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966521234567");
        addNewStorePage.ClickToSave();
        Assert.assertTrue(addNewStorePage.errorMsgPhone1.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone valid (3) display validation message
    @Test(priority = 53)
    public void IfUserAddPhonThree() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966531234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (4) display validation message
    @Test(priority = 54)
    public void IfUserAddPhonFour() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966541234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (5) display validation message
    @Test(priority = 55)
    public void IfUserAddPhonFive() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966551234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (6) display validation message
    @Test(priority = 56)
    public void IfUserAddPhonSix() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966561234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (7) display validation message
    @Test(priority = 57)
    public void IfUserAddPhonSeven() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966571234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (8) display validation message
    @Test(priority = 58)
    public void IfUserAddPhonEight() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966581234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (9) display validation message
    @Test(priority = 59)
    public void IfUserAddPhonNine() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.AddPhoneOne("966591234567");
        addNewStorePage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add Second phone text display validation message
    @Test(priority = 60)
    public void IfUserAddSecondPhoneText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("Zeoo");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        Assert.assertTrue(addNewStorePage.errorMsgPhone2.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add Second phone wrong display validation message
    @Test(priority = 61)
    public void IfUserAddSecondPhoneWrong() {
        driver.navigate().refresh();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966521234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        Assert.assertTrue(addNewStorePage.errorMsgPhone2.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (3) display validation message
    @Test(priority = 62)
    public void IfUserAddSecondPhonThree() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966531234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (4) display validation message
    @Test(priority = 63)
    public void IfUserAddSecondPhonFour() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966541234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (5) display validation message
    @Test(priority = 64)
    public void IfUserAddSecondPhonFive() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();

        addNewStorePage.AddPhoneTwo("966551234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (6) display validation message
    @Test(priority = 65)
    public void IfUserAddSecondPhonSix() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966561234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (7) display validation message
    @Test(priority = 66)
    public void IfUserAddSecondPhonSeven() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966571234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (8) display validation message
    @Test(priority = 67)
    public void IfUserAddSecondPhonEight() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966581234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // check if user add Second phone valid (9) display validation message
    @Test(priority = 68)
    public void IfUserAddSecondPhonNine() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966591234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        driver.navigate().refresh();
    }

    // Location
    // if location already exist
    @Test(priority = 69)
    public void IfLocationAlreadyExist() throws InterruptedException {
        driver.navigate().refresh();
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic("كبير");
        addNewStorePage.AddTextInStoreNameEnglish("Big");
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.SelectDay();
        addNewStorePage.SelectDateFrom();
        addNewStorePage.SelectDateTo();
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation("G-56");
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail("A@A.AA");
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewStorePage.errorMsgLocation.getText().contains("location is already exist"));
    }

    // if Shift already exist
    @Test(priority = 70)
    public void IfShiftAlreadyExist() throws InterruptedException {
        driver.navigate().refresh();
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic("كبير");
        addNewStorePage.AddTextInStoreNameEnglish("Big");
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddAnotherShift();
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation(location1);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail("A@A.AA");
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.errorMsgDay.getText().contains("You should enter the day only one time"));
    }

    // if User Add Phone two Empty
    @Test(priority = 71)
    public void IfUserAddPhoneTwoEmpty() throws InterruptedException {
        driver.navigate().refresh();
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic("كبير");
        addNewStorePage.AddTextInStoreNameEnglish("Big");
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.SelectDay();
        addNewStorePage.SelectDateFrom();
        addNewStorePage.SelectDateTo();
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location2);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail("A@A.AA");
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.ClickToSave();
    }


    // VALID TO ADD NEW STORE

    // if User Add try to make Add new store in arabic
    @Test(priority = 72)
    public void IfUserAddStoreArabic() throws InterruptedException {
        driver.navigate().refresh();
        homePage.ClickChangeLanguageToArabic();
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name1);
        addNewStorePage.AddTextInStoreNameEnglish(name1);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location4);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email1);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("تم إضافة متجر جديد بنجاح"));
    }

    // if user add two same shifts & after that change day in one shift
    @Test(priority = 73)
    public void IfUserChangeShiftAfterAddIt() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name2);
        addNewStorePage.AddTextInStoreNameEnglish(name2);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToAddAnotherShift();
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation(location5);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email2);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.errorMsgDay.getText().contains("يجب ادخال اليوم مرة واحدة فقط"));
        addNewStorePage.SelectDay();
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("تم إضافة متجر جديد بنجاح"));
    }

    // if User Add store Active
    @Test(priority = 74)
    public void IfUserAddStoreActive() throws InterruptedException {
        driver.navigate().refresh();
        homePage.ClickChangeLanguageToEnglish();
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name3);
        addNewStorePage.AddTextInStoreNameEnglish(name3);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation(location6);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email3);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add store opening soon
    @Test(priority = 75)
    public void IfUserAddStoreOpeningSoon() throws InterruptedException {
        driver.navigate().refresh();
        homePage.ClickChangeLanguageToEnglish();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name4);
        addNewStorePage.AddTextInStoreNameEnglish(name4);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location7);
        addNewStorePage.UploadJPG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email4);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add store with Can redeem
    @Test(priority = 76)
    public void IfUserAddStoreCanRedeem() throws InterruptedException {
        driver.navigate().refresh();
        homePage.ClickChangeLanguageToEnglish();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name5);
        addNewStorePage.AddTextInStoreNameEnglish(name5);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location8);
        addNewStorePage.UploadPNG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email5);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add two phone number
    @Test(priority = 77)
    public void IfUserAddTwoPhoneNumber() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name6);
        addNewStorePage.AddTextInStoreNameEnglish(name6);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation(location9);
        addNewStorePage.UploadPNG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email6);
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToAddMorePhone();
        addNewStorePage.AddPhoneTwo("966511234568");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add store Without email
    @Test(priority = 78)
    public void IfUserAddStoreWithoutEmail() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name7);
        addNewStorePage.AddTextInStoreNameEnglish(name7);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location10);
        addNewStorePage.UploadPNG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddPhoneOne("966511234567");
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add store Without phone
    @Test(priority = 79)
    public void IfUserAddStoreWithoutPhone() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name8);
        addNewStorePage.AddTextInStoreNameEnglish(name8);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusActive();
        addNewStorePage.AddTextInLocation(location11);
        addNewStorePage.UploadPNG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.AddEmail(email7);
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

    // if User Add store Without phone & email
    @Test(priority = 80)
    public void IfUserAddStoreWithoutPhoneAndEmail() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        addNewStorePage.SelectMall();
        Thread.sleep(5000);
        addNewStorePage.SelectCategory();
        addNewStorePage.SelectFloorNumber();
        addNewStorePage.AddTextInStoreNameArabic(name9);
        addNewStorePage.AddTextInStoreNameEnglish(name9);
        addNewStorePage.AddTextInStoreDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStorePage.AddTextInStoreDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewStorePage.ClickToMakeStatusOpeningSoon();
        addNewStorePage.AddTextInLocation(location12);
        addNewStorePage.UploadPNG();
        addNewStorePage.UploadJPGCover();
        addNewStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewStorePage.sucessMsg.getText().contains("New store has been added successfully"));
    }

}