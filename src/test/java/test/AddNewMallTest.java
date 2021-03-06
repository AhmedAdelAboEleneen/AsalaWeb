package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewMallPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeMallsPage;

public class AddNewMallTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeMallsPage mangeMallsPage;
    AddNewMallPage addNewMallPage;
    JavascriptExecutor js;

    Faker fakeData = new Faker();

    String name1 = fakeData.name().name();
    String name2 = fakeData.name().fullName();
    String name3 = fakeData.name().username();

    String location1 = fakeData.address().cityName();
    String location2 = fakeData.address().cityName();

    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click mange stores
        homePage = new HomePage(driver);
        homePage.ClickManageMalls();

        // click on add new mall
        mangeMallsPage = new MangeMallsPage(driver);
        mangeMallsPage.ClickAddMall();
    }

    // if user add name Arabic Empty
    @Test(priority = 2)
    public void IfUseAddNameArabicEmpty() {
        addNewMallPage = new AddNewMallPage(driver);
        addNewMallPage.AddTextInMallNameArabic("");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic Spaces
    @Test(priority = 3)
    public void IfUseAddNameArabicSpaces() {
        addNewMallPage.AddTextInMallNameArabic("        ");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic less than 3 char
    @Test(priority = 4)
    public void IfUseAddNameArabicLess() {
        addNewMallPage.AddTextInMallNameArabic("Te");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic more than 30 char
    @Test(priority = 5)
    public void IfUseAddNameArabicMore() {
        addNewMallPage.AddTextInMallNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 30 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic 3 char
    @Test(priority = 6)
    public void IfUseAddNameArabicThree() {
        addNewMallPage.AddTextInMallNameArabic("Tee");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name Arabic 30 char
    @Test(priority = 7)
    public void IfUseAddNameArabicThirty() {
        addNewMallPage.AddTextInMallNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English Empty
    @Test(priority = 8)
    public void IfUseAddNameEnglishEmpty() {
        addNewMallPage.AddTextInMallNameEnglish("");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English Spaces
    @Test(priority = 9)
    public void IfUseAddNameEnglishSpaces() {
        addNewMallPage.AddTextInMallNameEnglish("        ");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English less than 3 char
    @Test(priority = 10)
    public void IfUseAddNameEnglishLess() {
        addNewMallPage.AddTextInMallNameEnglish("Te");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name English more than 30 char
    @Test(priority = 11)
    public void IfUseAddNameEnglishMore() {
        addNewMallPage.AddTextInMallNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 30 characters"));
        driver.navigate().refresh();
    }

    // if user add name English 3 char
    @Test(priority = 12)
    public void IfUseAddNameEnglishThree() {
        addNewMallPage.AddTextInMallNameEnglish("Tee");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English 30 char
    @Test(priority = 13)
    public void IfUseAddNameEnglishThirty() {
        addNewMallPage.AddTextInMallNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo empty display validation message
    @Test(priority = 14)
    public void IfUserUploadphotoEmpty() {
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgPhoto.getText().contains("Please upload a photo"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo wWong display validation message
    @Test(priority = 15)
    public void IfUserUploadWrongPhoto() throws InterruptedException {
        addNewMallPage.UploadWrong();
        Thread.sleep(3000);
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgPhoto.getText().contains("Accept files in jpg, png and image format"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo more 2 mb display validation message
    @Test(priority = 16)
    public void IfUserUploadMore() throws InterruptedException {
        addNewMallPage.UploadMore();
        Thread.sleep(3000);
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgPhoto.getText().contains("Photo size shouldn’t be more than 2 Mb"));
        driver.navigate().refresh();
    }

    // if user add floor Empty
    @Test(priority = 17)
    public void IfUseAddFloorEmpty() {
        addNewMallPage.AddTextInNumbersOfFloor("");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgFloor.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add floor More Than 100
    @Test(priority = 18)
    public void IfUseAddFloorMoreThan() {
        addNewMallPage.AddTextInNumbersOfFloor("101");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgFloor.getText().contains("Please add a number between 1 to 100"));
        driver.navigate().refresh();
    }

    // if user add floor less Than 1
    @Test(priority = 19)
    public void IfUseAddFloorLessThan() {
        addNewMallPage.AddTextInNumbersOfFloor("0");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgFloor.getText().contains("Please add a number between 1 to 100"));
        driver.navigate().refresh();
    }

    // if user add floor with  -1
    @Test(priority = 20)
    public void IfUseAddFloorMinus() {
        addNewMallPage.AddTextInNumbersOfFloor("-1");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgFloor.getText().contains("Please add a number between 1 to 100"));
        driver.navigate().refresh();
    }

    // if user add floor with  1
    @Test(priority = 21)
    public void IfUseAddFloorOne() {
        addNewMallPage.AddTextInNumbersOfFloor("1");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add floor with  100
    @Test(priority = 22)
    public void IfUseAddFloorOneHundred() {
        addNewMallPage.AddTextInNumbersOfFloor("100");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user don't chose city
    @Test(priority = 23)
    public void IfUseDontChoseCity() {
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgCity.getText().contains("Please select a city"));
        driver.navigate().refresh();
    }

    // if user  chose city Makka
    @Test(priority = 24)
    public void IfUseChoseCityMakka() {
        addNewMallPage.SelectMakka();
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user  chose city Medina
    @Test(priority = 25)
    public void IfUseChoseCityMedina() {
        addNewMallPage.SelectMedina();
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }


    // if user  chose city Tarout
    @Test(priority = 26)
    public void IfUseChoseCityTarout() {
        addNewMallPage.SelectMedina();
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add address En Empty
    @Test(priority = 27)
    public void IfUseAddAddressEnEmpty() {
        addNewMallPage.AddTextInMallAddressEn("");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add address En Spaces
    @Test(priority = 28)
    public void IfUseAddAddressEnSpaces() {
        addNewMallPage.AddTextInMallAddressEn("        ");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add address En less than 3 char
    @Test(priority = 29)
    public void IfUseAddAddressEnLess() {
        addNewMallPage.AddTextInMallAddressEn("Te");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add address En more than 100 char
    @Test(priority = 30)
    public void IfUseAddAddressEnMore() {
        addNewMallPage.AddTextInMallAddressEn("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeeeeeeeeeeee");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressEn.getText().contains("This field shouldn’t contain more than 100 character"));
        driver.navigate().refresh();
    }

    // if user add address Ar Empty
    @Test(priority = 31)
    public void IfUseAddAddressArEmpty() {
        addNewMallPage.AddTextInMallAddressAr("");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add address Ar Spaces
    @Test(priority = 32)
    public void IfUseAddAddressArSpaces() {
        addNewMallPage.AddTextInMallAddressAr("        ");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add address Ar less than 3 char
    @Test(priority = 33)
    public void IfUseAddAddressArLess() {
        addNewMallPage.AddTextInMallAddressAr("Te");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressAr.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add address Ar more than 100 char
    @Test(priority = 34)
    public void IfUseAddAddressArMore() {
        addNewMallPage.AddTextInMallAddressAr("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeeeeeeeeeeee");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgAddressAr.getText().contains("This field shouldn’t contain more than 100 character"));
        driver.navigate().refresh();
    }

    // if user add website link number
    @Test(priority = 35)
    public void IfUseAddWebsiteLinkNumber() {
        addNewMallPage.AddTextInMallWebsite("15451546416546");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgWebsiteLink.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add website link text
    @Test(priority = 36)
    public void IfUseAddWebsiteLinkText() {
        addNewMallPage.AddTextInMallWebsite("bdakjbkjabkjfbaskbn");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgWebsiteLink.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add website link valid
    @Test(priority = 37)
    public void IfUseAddWebsiteLinkValid() {
        addNewMallPage.AddTextInMallWebsite("https://asala-dashboard.ibtikar.net.sa/mall/add");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }


    // if user add twitter link number
    @Test(priority = 38)
    public void IfUseAddTwitterLinkNumber() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallTwitter("15451546416546");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeTwitter.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add twitter link text
    @Test(priority = 39)
    public void IfUseAddTwitterLinkText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallTwitter("bdakjbkjabkjfbaskbn");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeTwitter.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }


    // if user add twitter link valid
    @Test(priority = 40)
    public void IfUseAddTwitterLinkValid() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallTwitter("https://twitter.com/");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add facebook link number
    @Test(priority = 41)
    public void IfUseAddFacebookLinkNumber() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallFacebook("15451546416546");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeFacebook.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add facebook link text
    @Test(priority = 42)
    public void IfUseAddFacebookLinkText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallFacebook("bdakjbkjabkjfbaskbn");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeFacebook.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add facebook link valid
    @Test(priority = 43)
    public void IfUseAddFacebookLinkValid() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallFacebook("https://facebook.com/");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add instagram link number
    @Test(priority = 44)
    public void IfUseAddinstagraminkNumber() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallInstgram("15451546416546");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeInstagram.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }

    // if user add instagram link text
    @Test(priority = 45)
    public void IfUseAddinstagramLinkText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallInstgram("bdakjbkjabkjfbaskbn");
        addNewMallPage.ClickToSave();
        Assert.assertTrue(addNewMallPage.errorMsgeInstagram.getText().contains("Please add a valid URL"));
        driver.navigate().refresh();
    }


    // if user add instagram link valid
    @Test(priority = 46)
    public void IfUseAddInstagramLinkValid() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewMallPage.AddTextInMallInstgram("https://www.instagram.com/");
        addNewMallPage.ClickToSave();
        driver.navigate().refresh();
    }

    // Not valid mall
    // if user add mall with wrong photo ratio
    @Test(priority = 47)
    public void IfUseAddValidMallWithoutSocialAccount() throws InterruptedException {
        driver.navigate().refresh();
        addNewMallPage.AddTextInMallNameArabic(name1);
        addNewMallPage.AddTextInMallNameEnglish(name1);
        addNewMallPage.UploadLogo();
        addNewMallPage.AddTextInNumbersOfFloor("10");
        addNewMallPage.SelectMakka();
        addNewMallPage.AddTextInMallAddressEn(location1);
        addNewMallPage.AddTextInMallAddressAr(location2);
        addNewMallPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-300)");
        Thread.sleep(5000);
       // Assert.assertTrue(addNewMallPage.errorMsgPhoto.getText().contains("Please upload a photo with aspect ratio 1.8 width : 1 height"));
        driver.navigate().refresh();
    }

    // valid mall
    // if user add mall valid website link & Without social account
    @Test(priority = 48)
    public void IfUseAddValidMallWithWebsiteLinkWithoutSocialAccount() throws InterruptedException {
        driver.navigate().refresh();
        addNewMallPage.AddTextInMallNameArabic(name2);
        addNewMallPage.AddTextInMallNameEnglish(name2);
        addNewMallPage.UploadCover();
        addNewMallPage.AddTextInNumbersOfFloor("10");
        addNewMallPage.SelectMedina();
        addNewMallPage.AddTextInMallAddressEn(location1);
        addNewMallPage.AddTextInMallAddressAr(location2);
        addNewMallPage.AddTextInMallWebsite("https://asala-dashboard.ibtikar.net.sa/mall/add");
        addNewMallPage.ClickToSave();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-300)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewMallPage.sucessMsg.getText().contains("New Mall had been added successfully"));
        driver.navigate().refresh();
    }

    // if user add mall valid website link & social account
    @Test(priority = 49)
    public void IfUseAddValidMallWithWebsiteLinkSocialAccount() throws InterruptedException {
        driver.navigate().refresh();
        addNewMallPage.AddTextInMallNameArabic(name3);
        addNewMallPage.AddTextInMallNameEnglish(name3);
        addNewMallPage.UploadCover();
        addNewMallPage.AddTextInNumbersOfFloor("10");
        addNewMallPage.SelectMakka();
        addNewMallPage.AddTextInMallAddressEn(location1);
        addNewMallPage.AddTextInMallAddressAr(location2);
        addNewMallPage.AddTextInMallWebsite("https://asala-dashboard.ibtikar.net.sa/mall/add");
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,300)");
        addNewMallPage.AddTextInMallTwitter("https://twitter.com/");
        addNewMallPage.AddTextInMallFacebook("https://facebook.com/");
        addNewMallPage.AddTextInMallInstgram("https://www.instagram.com/");
        addNewMallPage.ClickToSave();
        js.executeScript("scrollBy(0,-300)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewMallPage.sucessMsg.getText().contains("New Mall had been added successfully"));
        driver.navigate().refresh();
    }

}