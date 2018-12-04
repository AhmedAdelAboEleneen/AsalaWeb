package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditOfferPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeOfferPage;

public class EditOfferTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeOfferPage mangeOfferPage;
    EditOfferPage editOfferPage;
    JavascriptExecutor js;

    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click mange offers
        homePage = new HomePage(driver);
        homePage.ClickManageOffer();

        // got edit offer number 4
        mangeOfferPage = new MangeOfferPage(driver);
        mangeOfferPage.ClickToEditOffer();
    }
    // if user try to change photo
    @Test(priority = 2)
    public void ChangePhoto() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        editOfferPage = new EditOfferPage(driver);
        editOfferPage.UploadPNG();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,300)");
        editOfferPage.ClickToSave();
        js.executeScript("scrollBy(0,-300)");
        Assert.assertTrue(editOfferPage.sucessMsg.getText().contains("Offer has been updated successfully"));
        driver.navigate().refresh();
    }

    // if user try to change mall
    @Test(priority = 3)
    public void Changemall() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        editOfferPage.UploadJPG();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        editOfferPage.SelectMall();
        editOfferPage.ClickToSave();
        Assert.assertTrue(editOfferPage.errorstoreSelect.getText().contains("please select a store"));
    }
}
