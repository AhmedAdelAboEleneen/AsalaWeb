package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    // if user try to make login without email & password
    @Test(priority = 1)
    public void AddEmailEmptyAndPassword() {

        loginPage = new LoginPage(driver);
        loginPage.AddEmail("");
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("Please enter your Email"));
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
    }

    // if user try to make login add email but wrong format & password
    @Test(priority = 2)
    public void AddEmailEmptyWrongFormat() {

        loginPage.AddEmail("ahmed");
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("Please enter a valid email"));
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
    }

    @Test(priority = 3)
    public void AddEmailEmptyButAddPasword() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("Please enter your Email"));
    }

    // if user try to make login add email but invalid password
    @Test(priority = 4)
    public void AddEmailButAddPaswordEmpty() {

        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
    }

    @Test(priority = 5)
    public void AddWrongEmailButVaildPassword() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("ahmed");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("Please enter a valid email"));
    }

    @Test(priority = 6)
    public void AddValidEmailButWrongPasswordPassword() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("1234567");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("Wrong email or password"));
    }

    // check that the user isn't inactive user.
    // Check that the inactive user will no longer able to login to the dashboard.
    @Test(priority = 7)
    public void AddValidEmailAndPasswordInActiveUSer() throws InterruptedException {

        loginPage.ClearEmailData();
        loginPage.AddEmail("a@asala.com");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.wrongEmailOrPasswordOrNotActiveTxt.getText()
                .contains("Sorry, this account is no longer active, please contact your dashboard administrator"));
    }

    // same test cases but Arabic
    @Test(priority = 8)
    public void AddEmailEmptyAndPasswordAr() throws InterruptedException {

        loginPage.ClickChangeLanguageToArabic();
        Thread.sleep(2000);
        loginPage.ClearEmailData();
        loginPage.AddEmail("");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
    }

    // if user try to make login add email but wrong format & password
    @Test(priority = 9)
    public void AddEmailEmptyWrongFormatAr() {

        loginPage.ClickChangeLanguageToArabic();
        loginPage.AddEmail("ahmed");
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
    }

    @Test(priority = 10)
    public void AddEmailEmptyButAddPaswordAr() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
    }

    // if user try to make login add email but invalid password
    @Test(priority = 11)
    public void AddEmailButAddPaswordEmptyAr() {

        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
    }

    @Test(priority = 12)
    public void AddWrongEmailButVaildPasswordAr() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("ahmed");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Assert.assertTrue(loginPage.emailTxtValidtion.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
    }

    @Test(priority = 13)
    public void AddValidEmailButWrongPasswordPasswordAr() {

        loginPage.ClearEmailData();
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("1234567");
        loginPage.ClickLogin();
        Assert.assertTrue(
                loginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("البريد او كلمة المرور غير صحيح"));
    }

    // check that the user isn't inactive user.
    // Check that the inactive user will no longer able to login to the dashboard.
    @Test(priority = 14)
    public void AddValidEmailAndPasswordInActiveUSerAr() throws InterruptedException {

        loginPage.ClearEmailData();
        loginPage.AddEmail("a@asala.com");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.wrongEmailOrPasswordOrNotActiveTxt.getText()
                .contains("ناسف، هذا الحساب غير مفعل، من فضلك تواصل مع مدير لوحة التحكم"));
    }

    // check that the email and password matches an active user.
    // check user role and pages access.
    // super admin login
    @Test(priority = 15)
    public void AddValidEmailAndPasswordActiveUSerSuperAdmin() throws InterruptedException {

        loginPage.ClearEmailData();
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.ClearPasswordData();
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        loginPage.ClickChangeLanguageToEnglish();

        homePage = new HomePage(driver);
        Thread.sleep(5000);
        homePage.ClickUserName();
        homePage.ClickSignOut();
    }

    // check user role and pages access.
    // mall admin login
    @Test(priority = 16)
    public void AddValidEmailAndPasswordActiveUSerMallAdmin() throws InterruptedException {

        loginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
        Thread.sleep(3000);
        homePage.ClickUserName();
        homePage.ClickSignOut();
    }

    // check user role and pages access.
    // store admin login
    @Test(priority = 17)
    public void AddValidEmailAndPasswordActiveUSerStoreAdmin() {

        loginPage.AddEmail("ahmed.adel.store@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();
    }

}
