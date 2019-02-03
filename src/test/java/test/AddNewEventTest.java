package test;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewEventPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeEvents;

public class AddNewEventTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeEvents mangeEvents;
    AddNewEventPage addNewEventPage;
    JavascriptExecutor js;


    Faker fakeData = new Faker();

    String OrganizerName = fakeData.name().fullName();
    String location1 = fakeData.address().cityName();

    String name1 = fakeData.name().name();
    String name2 = fakeData.name().fullName();
    String name3 = fakeData.name().username();
    String name4 = fakeData.name().firstName();

    String email1 = fakeData.internet().emailAddress();
    String email2 = fakeData.internet().emailAddress();
    String email3 = fakeData.internet().emailAddress();
    String email4 = fakeData.internet().emailAddress();

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
        homePage.ClickManageEvent();

        // click on add new offer
        mangeEvents = new MangeEvents(driver);
        mangeEvents.ClickToAddNewEvent();
    }

    // if user add name Arabic Empty
    @Test(priority = 2)
    public void IfUseAddNameArabicEmpty() {
        addNewEventPage = new AddNewEventPage(driver);
        addNewEventPage.AddTextInEventNameArabic("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic Spaces
    @Test(priority = 3)
    public void IfUseAddNameArabicSpaces() {
        addNewEventPage.AddTextInEventNameArabic("        ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name Arabic less than 3 char
    @Test(priority = 4)
    public void IfUseAddNameArabicLess() {
        addNewEventPage.AddTextInEventNameArabic("Te");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameAr.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name Arabic more than 30 char
    @Test(priority = 5)
    public void IfUseAddNameArabicMore() {
        addNewEventPage.AddTextInEventNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameAr.getText().contains("This field shouldn’t contain more than 30 character"));
        driver.navigate().refresh();
    }

    // if user add name Arabic 3 char
    @Test(priority = 6)
    public void IfUseAddNameArabicThree() {
        addNewEventPage.AddTextInEventNameArabic("Tee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name Arabic 30 char
    @Test(priority = 7)
    public void IfUseAddNameArabicThirty() {
        addNewEventPage.AddTextInEventNameArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English Empty
    @Test(priority = 8)
    public void IfUseAddNameEnglishEmpty() {
        addNewEventPage.AddTextInEventNameEnglish("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English Spaces
    @Test(priority = 9)
    public void IfUseAddNameEnglishSpaces() {
        addNewEventPage.AddTextInEventNameEnglish("        ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name English less than 3 char
    @Test(priority = 10)
    public void IfUseAddNameEnglishLess() {
        addNewEventPage.AddTextInEventNameEnglish("Te");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name English more than 30 char
    @Test(priority = 11)
    public void IfUseAddNameEnglishMore() {
        addNewEventPage.AddTextInEventNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgNameEn.getText().contains("This field shouldn’t contain more than 30 character"));
        driver.navigate().refresh();
    }

    // if user add name English 3 char
    @Test(priority = 12)
    public void IfUseAddNameEnglishThree() {
        addNewEventPage.AddTextInEventNameEnglish("Tee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name English 30 char
    @Test(priority = 13)
    public void IfUseAddNameEnglishThirty() {
        addNewEventPage.AddTextInEventNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc Arabic Empty
    @Test(priority = 14)
    public void IfUseAddDescArabicEmpty() {
        addNewEventPage.AddTextInEventDescArabic("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic Spaces
    @Test(priority = 15)
    public void IfUseAddDescArabicSpaces() {
        addNewEventPage.AddTextInEventDescArabic("              ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionAr.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic less than 100 char
    @Test(priority = 16)
    public void IfUseAddDescArabicLess() {
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionAr.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic more than 500 char
    @Test(priority = 17)
    public void IfUseAddDescArabicMore() {
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionAr.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc Arabic 100 char
    @Test(priority = 18)
    public void IfUseAddDescArabicThree() {
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc Arabic 500 char
    @Test(priority = 19)
    public void IfUseAddDescArabicFifty() {
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc English Empty
    @Test(priority = 20)
    public void IfUseAddDescEnglishEmpty() {
        addNewEventPage.AddTextInEventDescEnglish("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English Spaces
    @Test(priority = 21)
    public void IfUseAddDescEnglishSpaces() {
        addNewEventPage.AddTextInEventDescEnglish("              ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add desc English less than 100 char
    @Test(priority = 22)
    public void IfUseAddDescEnglishLess() {
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionEn.getText().contains("This field shouldn’t be less than 100 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English more than 500 char
    @Test(priority = 23)
    public void IfUseAddDescEnglishMore() {
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDescriptionEn.getText().contains("This field shouldn’t contain more than 500 characters"));
        driver.navigate().refresh();
    }

    // if user add desc English 100 char
    @Test(priority = 24)
    public void IfUseAddDescEnglishThree() {
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add desc English 500 char
    @Test(priority = 25)
    public void IfUseAddDescEnglishFifty() {
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add organizer Empty
    @Test(priority = 26)
    public void IfUseAddNameOrganizerEmpty() {
        addNewEventPage.AddTextInSponseer("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgOrganizerEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add organizer space
    @Test(priority = 27)
    public void IfUseAddNameOrganizerSpaces() {
        addNewEventPage.AddTextInSponseer("           ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgOrganizerEn.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add organizer less than 3 char
    @Test(priority = 28)
    public void IfUseAddNameOrganizerLess() {
        addNewEventPage.AddTextInSponseer("Te");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgOrganizerEn.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add organizer more than 30 char
    @Test(priority = 29)
    public void IfUseAddNameOrganizerMore() {
        addNewEventPage.AddTextInSponseer("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgOrganizerEn.getText().contains("This field shouldn’t contain more than 30 character"));
        driver.navigate().refresh();
    }

    // if user add name organizer 3 char
    @Test(priority = 30)
    public void IfUseAddNameOrganizerThree() {
        addNewEventPage.AddTextInSponseer("Tee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if user add name organizer 30 char
    @Test(priority = 31)
    public void IfUseAddNameOrganizerThirty() {
        addNewEventPage.AddTextInSponseer("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if don't choose date
    @Test(priority = 32)
    public void IfUseDontAddDate() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDateFrom.getText().contains("Please select days range"));
        Assert.assertTrue(addNewEventPage.errorMsgDateTo.getText().contains("Please select days range"));
        driver.navigate().refresh();
    }

    // if  choose only date from
    @Test(priority = 33)
    public void IfUseAddDateFromOnly() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDateTo.getText().contains("Please select days range"));
        driver.navigate().refresh();
    }

    // if  choose only date to
    @Test(priority = 34)
    public void IfUseAddDateToOnly() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDateFrom.getText().contains("Please select days range"));
        driver.navigate().refresh();
    }

    // if  choose  date to in future & date from in current
    @Test(priority = 36)
    public void IfUseAddDateToInCurrentAndDateFromFuture() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ChoseDateFromFuture();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgDateTo.getText().contains("Please select a valid end date"));
        driver.navigate().refresh();
    }

    // if  choose  date to & date from in current
    @Test(priority = 37)
    public void IfUseAddDateToAndDateFromInCurrent() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // if  choose  date to & date from in future
    @Test(priority = 38)
    public void IfUseAddDateToAndDateFromInFuture() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ChoseDateToFuture();
        addNewEventPage.ChoseDateFromFuture();
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo empty display validation message
    @Test(priority = 39)
    public void IfUserUploadphotoEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhoto.getText().contains("Please upload a photo"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo Wrong display validation message
    @Test(priority = 40)
    public void IfUserUploadWrongPhoto() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadWrong();
        Thread.sleep(3000);
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhoto.getText().contains("Accept files in jpg, png and image format"));
        driver.navigate().refresh();
    }

    // photo
    // check if user upload photo more 2 mb display validation message
    @Test(priority = 41)
    public void IfUserUploadOverSize() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadMore();
        Thread.sleep(3000);
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhoto.getText().contains("Photo size shouldn’t be more than 2 Mb"));
        driver.navigate().refresh();
    }

    // check if user add email empty display validation message
    @Test(priority = 42)
    public void IfUserAddEmailEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgEmail.getText().contains("please add an email"));
        driver.navigate().refresh();
    }

    // check if user add email spaces display validation message
    @Test(priority = 43)
    public void IfUserAddEmailSpaces() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddEmail("          ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgEmail.getText().contains("please add an email"));
        driver.navigate().refresh();
    }

    // check if user add email wrong Format display validation message
    @Test(priority = 44)
    public void IfUserAddEmailWrongformat() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddEmail("test");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add email numbers  display validation message
    @Test(priority = 45)
    public void IfUserAddEmailNumbers() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddEmail("1234");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add valid email don't display validation message
    @Test(priority = 46)
    public void IfUserAddValidEmail() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddEmail("a@a.aa");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone empty display validation message
    @Test(priority = 47)
    public void IfUserAddPhoneEmpty() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhone.getText().contains("please add a phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone spaces display validation message
    @Test(priority = 48)
    public void IfUserAddPhoneSpaces() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("      ");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhone.getText().contains("please add a phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone text display validation message
    @Test(priority = 49)
    public void IfUserAddPhoneText() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("Zeoo");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhone.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone wrong display validation message
    @Test(priority = 50)
    public void IfUserAddPhoneWrong() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966521234567");
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgPhone.getText().contains("please add a valid phone number"));
        driver.navigate().refresh();
    }

    // check if user add  phone valid (3) display validation message
    @Test(priority = 51)
    public void IfUserAddPhonThree() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966531234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (4) display validation message
    @Test(priority = 52)
    public void IfUserAddPhonFour() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966541234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (5) display validation message
    @Test(priority = 53)
    public void IfUserAddPhonFive() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966551234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (6) display validation message
    @Test(priority = 54)
    public void IfUserAddPhonSix() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966561234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (7) display validation message
    @Test(priority = 55)
    public void IfUserAddPhonSeven() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966571234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (8) display validation message
    @Test(priority = 56)
    public void IfUserAddPhonEight() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966581234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // check if user add  phone valid (9) display validation message
    @Test(priority = 57)
    public void IfUserAddPhonNine() {
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.ClickToSave();
        driver.navigate().refresh();
    }

    // not valid case
    // if user add time from after time to
    @Test(priority = 58)
    public void IfUserAddTimeFromAfterTimeTo() {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic("tee");
        addNewEventPage.AddTextInEventNameEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimefromEight();
        addNewEventPage.SelectTimeToTwo();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail("a@a.com");
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        Assert.assertTrue(addNewEventPage.errorMsgTimeTo.getText().contains("please select a valid end time"));
    }

    // event from 12 AM to 12 AM
    @Test(priority = 59)
    public void IfUserAddNotValidEvent() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name1);
        addNewEventPage.AddTextInEventNameEnglish(name1);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelveAM();
        addNewEventPage.SelectTimeToTwelveAM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email1);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.errorMsgTimeTo.getText().contains("please select a valid end time"));
        driver.navigate().refresh();
    }

    // event from 12 PM to 12 PM
    @Test(priority = 60)
    public void IfUserAddNotValidEventTwo() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name1);
        addNewEventPage.AddTextInEventNameEnglish(name1);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelvePM();
        addNewEventPage.SelectTimeToTwelvePM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email1);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        Thread.sleep(5000);
        Assert.assertTrue(addNewEventPage.errorMsgTimeTo.getText().contains("please select a valid end time"));
    }

    // event from 12 PM to 11 AM
    @Test(priority = 61)
    public void IfUserAddNotValidEventThree() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name1);
        addNewEventPage.AddTextInEventNameEnglish(name1);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelvePM();
        addNewEventPage.SelectTimeToElvenAM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email1);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.errorMsgTimeTo.getText().contains("please select a valid end time"));
    }

    // Valid Offer

    // if user add valid event
    @Test(priority = 62)
    public void IfUserAddValidEvent() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name1);
        addNewEventPage.AddTextInEventNameEnglish(name1);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelveAM();
        addNewEventPage.SelectTimeToTwelvePM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email1);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 12 PM to 12 AM
    @Test(priority = 63)
    public void IfUserAddValidEventTwo() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name2);
        addNewEventPage.AddTextInEventNameEnglish(name2);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelvePM();
        addNewEventPage.SelectTimeToTwelveAM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email2);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 11 AM to 12 PM
    @Test(priority = 64)
    public void IfUserAddValidEventThree() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name3);
        addNewEventPage.AddTextInEventNameEnglish(name3);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromElvenAM();
        addNewEventPage.SelectTimeToTwelvePM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email3);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 12 PM to 11 AM
    @Test(priority = 65)
    public void IfUserAddValidEventFour() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelvePM();
        addNewEventPage.SelectTimeToElvenPM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 12 AM to 11 PM
    @Test(priority = 66)
    public void IfUserAddValidEventFive() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelveAM();
        addNewEventPage.SelectTimeToElvenPM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 12 PM to 11 PM
    @Test(priority = 67)
    public void IfUserAddValidEventSix() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromTwelvePM();
        addNewEventPage.SelectTimeToElvenPM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 11 PM to 12 AM
    @Test(priority = 68)
    public void IfUserAddValidEventSeven() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromElvenPM();
        addNewEventPage.SelectTimeToTwelveAM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 1 PM to 11 PM
    @Test(priority = 69)
    public void IfUserAddValidEventEight() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromOnePM();
        addNewEventPage.SelectTimeToElvenPM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
    }

    // event from 1 AM to 11 AM
    @Test(priority = 70)
    public void IfUserAddValidEventNine() throws InterruptedException {
        driver.navigate().refresh();
        addNewEventPage.SelectMall();
        addNewEventPage.AddTextInEventNameArabic(name4);
        addNewEventPage.AddTextInEventNameEnglish(name4);
        addNewEventPage.AddTextInEventDescArabic("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInEventDescEnglish("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewEventPage.AddTextInSponseer(OrganizerName);
        addNewEventPage.ChoseDateFromCurrent();
        addNewEventPage.ChoseDateToCurrent();
        addNewEventPage.SelectTimeFromOneAM();
        addNewEventPage.SelectTimeToElvenAM();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        addNewEventPage.UploadCover();
        addNewEventPage.AddEmail(email4);
        addNewEventPage.AddPhoneOne("966591234567");
        addNewEventPage.AddTextInLocationEn(location1);
        addNewEventPage.AddTextInLocationAr(location1);
        addNewEventPage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(3000);
        Assert.assertTrue(addNewEventPage.sucessMsg.getText().contains("New event has been added successfully"));
        driver.navigate().refresh();
    }
}