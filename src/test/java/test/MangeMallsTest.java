package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeMallsPage;

public class MangeMallsTest extends TestBase {

    MangeMallsPage mangeMallsPage;
    LoginPage loginPage;
    HomePage homePage;

    // make login with super admin
    @Test(priority = 1)
    public void MakeLogint() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click user & click to get here profile
        homePage = new HomePage(driver);
        homePage.ClickManageMalls();
    }

    // Deactive KADI MALL
    @Test(priority = 2)
    public void DeactiveKadiMallEn() throws InterruptedException {

        mangeMallsPage = new MangeMallsPage(driver);
        mangeMallsPage.ClickDeactiveMall();
        Thread.sleep(3000);
        mangeMallsPage.ClickToConfirm();
        Assert.assertTrue(mangeMallsPage.successTxt.getText().contains("The Mall has been deactivated successfully"));
    }

    // Active KADI MALL
    @Test(priority = 3)
    public void ActiveKadiMallEn() {

        mangeMallsPage = new MangeMallsPage(driver);
        mangeMallsPage.ClickActiveMall();
        mangeMallsPage.ClickToConfirm();
        Assert.assertTrue(mangeMallsPage.successTxt.getText().contains("The Mall has been activated successfully"));
    }

    // Deactive KADI MALL Ar
    @Test(priority = 4)
    public void DeactiveKadiMallAr() {

        homePage.ClickChangeLanguageToArabic();
        mangeMallsPage = new MangeMallsPage(driver);
        mangeMallsPage.ClickDeactiveMall();
        mangeMallsPage.ClickToConfirm();
        Assert.assertTrue(mangeMallsPage.successTxt.getText().contains("تم إلغاء تفعيل المول"));
    }

    // Active KADI MALL Ar
    @Test(priority = 5)
    public void ActiveKadiMallAr() {

        homePage.ClickChangeLanguageToArabic();
        mangeMallsPage = new MangeMallsPage(driver);
        mangeMallsPage.ClickActiveMall();
        mangeMallsPage.ClickToConfirm();
        Assert.assertTrue(mangeMallsPage.successTxt.getText().contains("تم تفعيل المول بنجاح"));
    }
}
