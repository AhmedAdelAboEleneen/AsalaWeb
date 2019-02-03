package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewOfferPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeOfferPage;

public class AddNewOfferTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeOfferPage mangeOfferPage;
    AddNewOfferPage addNewOfferPage;
    JavascriptExecutor js;

    Faker fakeData = new Faker();

    String name1 = fakeData.name().name();
    String name2 = fakeData.name().firstName();
    String name3 = fakeData.name().lastName();
    String name4 = fakeData.name().fullName();


    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        // loginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
        // loginPage.AddEmail("ahmed.adel.store@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click mange stores
        homePage = new HomePage(driver);
        homePage.ClickManageOffer();

        // click on add new offer
        mangeOfferPage = new MangeOfferPage(driver);
        mangeOfferPage.ClickToAddNewOffer();
    }

    // if user add name Arabic Empty
    @Test(priority = 2)
    public void IfUseAddNameArabicEmpty() {
        addNewOfferPage = new AddNewOfferPage(driver);
        addNewOfferPage.AddTextInOfferNameArabic("");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic Spaces
     @Test(priority = 3)
    public void IfUseAddNameArabicSpaces() {
        addNewOfferPage.AddTextInOfferNameArabic("        ");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic less than 3 char
    @Test(priority = 4)
    public void IfUseAddNameArabicLess() {
        addNewOfferPage.AddTextInOfferNameArabic("Te");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic more than 30 char
    @Test(priority = 5)
    public void IfUseAddNameArabicMore() {
        addNewOfferPage.AddTextInOfferNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 30 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic 3 char
    @Test(priority = 6)
    public void IfUseAddNameArabicThree() {
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name Arabic 30 char
    @Test(priority = 7)
    public void IfUseAddNameArabicThirty() {
        addNewOfferPage.AddTextInOfferNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English Empty
    @Test(priority = 8)
    public void IfUseAddNameEnglishEmpty() {
        addNewOfferPage.AddTextInOfferNameEnglish("");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English Spaces
    @Test(priority = 9)
    public void IfUseAddNameEnglishSpaces() {
        addNewOfferPage.AddTextInOfferNameEnglish("        ");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English less than 3 char
    @Test(priority = 10)
    public void IfUseAddNameEnglishLess() {
        addNewOfferPage.AddTextInOfferNameEnglish("Te");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name English more than 30 char
    @Test(priority = 11)
    public void IfUseAddNameEnglishMore() {
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 30 characters"));
        driver.navigate().refresh();
    }

    // if user add name English 3 char
    @Test(priority = 13)
    public void IfUseAddNameEnglishThree() {
        addNewOfferPage.AddTextInOfferNameEnglish("Tee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English 30 char
    @Test(priority = 14)
    public void IfUseAddNameEnglishThirty() {
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc Arabic Empty
    @Test(priority = 15)
    public void IfUseAddDescArabicEmpty() {
        addNewOfferPage.AddTextInOfferDescArabic("");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic Spaces
    @Test(priority = 16)
    public void IfUseAddDescArabicSpaces() {
        addNewOfferPage.AddTextInOfferDescArabic("              ");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic less than 100 char
    @Test(priority = 17)
    public void IfUseAddDescArabicLess() {
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionAr.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic more than 500 char
    @Test(priority = 18)
    public void IfUseAddDescArabicMore() {
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionAr.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic 100 char
    @Test(priority = 19)
    public void IfUseAddDescArabicThree() {
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc Arabic 500 char
    @Test(priority = 20)
    public void IfUseAddDescArabicFifty() {
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc English Empty
    @Test(priority = 21)
    public void IfUseAddDescEnglishEmpty() {
        addNewOfferPage.AddTextInOfferDescEnglish("");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English Spaces
    @Test(priority = 22)
    public void IfUseAddDescEnglishSpaces() {
        addNewOfferPage.AddTextInOfferDescEnglish("              ");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English less than 100 char
    @Test(priority = 23)
    public void IfUseAddDescEnglishLess() {
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionEn.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English more than 500 char
    @Test(priority = 24)
    public void IfUseAddDescEnglishMore() {
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgDescriptionEn.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English 100 char
    @Test(priority = 25)
    public void IfUseAddDescEnglishThree() {
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc English 500 char
    @Test(priority = 26)
    public void IfUseAddDescEnglishFifty() {
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.ClickToSave();
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo empty display validation message
    @Test(priority = 27)
    public void IfUserUploadphotoEmpty() {
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgPhoto.getText().contains("Please upload a photo"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo Wrong display validation message
    @Test(priority = 28)
    public void IfUserUploadWrong() throws InterruptedException {
        addNewOfferPage.UploadWrong();
        Thread.sleep(3000);
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgPhoto.getText().contains("Accept files in jpg, png and image format"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo more 2 mb display validation message
    @Test(priority = 29)
    public void IfUserUploadMoreSize() throws InterruptedException {
        addNewOfferPage.UploadMore();
        Thread.sleep(3000);
        addNewOfferPage.ClickToSave();
        Assert.assertTrue(addNewOfferPage.errorMsgPhoto.getText().contains("Photo size shouldn’t be more than 2 Mb"));
        driver.navigate().refresh();
    }

    // Not Valid Offer
    // because it from future to curent date
    @Test(priority = 30)
    public void AddOfferinDateFromInFutureAndDateToInCurrent() throws InterruptedException {
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromFuture();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.errorMsgDateTo.getText().contains("Please select a valid end date"));
        driver.navigate().refresh();

    }

    // add offer without store
    @Test(priority = 31)
    public void AddOfferWithoutStore() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.errorstoreSelect.getText().contains("please select a store"));
        driver.navigate().refresh();
    }


    // add offer without mall
    @Test(priority = 32)
    public void AddOfferWithoutMall() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.errorMallSelect.getText().contains("please select a mall"));
        driver.navigate().refresh();
    }

    // add offer without Date To
    @Test(priority = 33)
    public void AddOfferWithoutDateTo() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.errorMsgDateTo.getText().contains("Please select days range"));
        driver.navigate().refresh();
    }

    // add offer without Date From
    @Test(priority = 34)
    public void AddOfferWithoutDateFrom() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.errorMsgDateFrom.getText().contains("Please select days range"));
        driver.navigate().refresh();
    }

    // add offer with Wrong Ratio
    @Test(priority = 35)
    public void AddOfferWrongRatio() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic("Tee");
        addNewOfferPage.AddTextInOfferNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadLogo();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        Thread.sleep(8000);
        Assert.assertTrue(addNewOfferPage.errorMsgPhoto.getText().contains("Please upload a photo with aspect ratio 1.8 width : 1 height"));
        driver.navigate().refresh();
    }


    // valid offer
    // add offer in current day & photo PNG
    @Test(priority = 36)
    public void AddOfferinCurrent() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic(name1);
        addNewOfferPage.AddTextInOfferNameEnglish(name1);
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.ChoseDateToCurrent();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.sucessMsg.getText().contains("New offer has been added successfully"));
        driver.navigate().refresh();
    }

    // add offer Date from in current & Date to in future & photo JPG
    @Test(priority = 37)
    public void AddOfferinCurrentAndFuture() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic(name2);
        addNewOfferPage.AddTextInOfferNameEnglish(name2);
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.ChoseDateToFuture();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.sucessMsg.getText().contains("New offer has been added successfully"));
        driver.navigate().refresh();
    }

    // add offer Date from in future & Date to in future & photo JPG
    @Test(priority = 38)
    public void AddOfferinFutureAndFuture() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic(name3);
        addNewOfferPage.AddTextInOfferNameEnglish(name3);
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromFuture();
        addNewOfferPage.ChoseDateToFuture();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.sucessMsg.getText().contains("New offer has been added successfully"));
        driver.navigate().refresh();
    }
    // add offer valid
    @Test(priority = 39)
    public void AddOfferValid() throws InterruptedException {
        driver.navigate().refresh();
        addNewOfferPage.AddTextInOfferNameArabic(name4);
        addNewOfferPage.AddTextInOfferNameEnglish(name4);
        addNewOfferPage.AddTextInOfferDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.AddTextInOfferDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewOfferPage.UploadCover();
        addNewOfferPage.ChoseDateFromCurrent();
        addNewOfferPage.ChoseDateToFuture();
        addNewOfferPage.SelectMall();
        addNewOfferPage.SelectStore();
        addNewOfferPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewOfferPage.sucessMsg.getText().contains("New offer has been added successfully"));
        driver.navigate().refresh();
    }
}
