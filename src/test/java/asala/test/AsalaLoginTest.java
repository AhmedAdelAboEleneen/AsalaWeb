package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;

public class AsalaLoginTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;

	// if user try to make login without email & password 
	@Test(priority = 1)
	public void AddEmailEmptyAndPassword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your Email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
	}

	// if user try to make login add email but wrong format & password 
	@Test(priority = 2)
	public void AddEmailEmptyWrongFormat () {

		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter a valid email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
	}

	@Test(priority = 3)
	public void AddEmailEmptyButAddPasword () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your Email"));
	}

	// if user try to make login add email but invalid password 
	@Test(priority = 4)
	public void AddEmailButAddPaswordEmpty () {

		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
	}

	@Test(priority = 5)
	public void AddWrongEmailButVaildPassword () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter a valid email"));
	}

	@Test(priority = 6)
	public void AddValidEmailButWrongPasswordPassword () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("Wrong email or password"));
	}

	// check that the user isn't inactive user.
	// Check that the inactive user will no longer able to login to the dashboard.
	@Test(priority = 7)
	public void AddValidEmailAndPasswordInActiveUSer () throws InterruptedException {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("a@asala.com");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Thread.sleep(3000);
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("Sorry, this account is no longer active, please contact your dashboard administrator"));
	}

	// same test cases but Arabic
	@Test(priority = 8)
	public void AddEmailEmptyAndPasswordAr () throws InterruptedException {

		asalaLoginPage.ClickChangeLanguageToArabic();
		Thread.sleep(2000);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	// if user try to make login add email but wrong format & password 
	@Test(priority = 9)
	public void AddEmailEmptyWrongFormatAr () {

		asalaLoginPage.ClickChangeLanguageToArabic();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	@Test(priority = 10)
	public void AddEmailEmptyButAddPaswordAr () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
	}

	// if user try to make login add email but invalid password 
	@Test(priority = 11)
	public void AddEmailButAddPaswordEmptyAr () {

		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	@Test(priority = 12)
	public void AddWrongEmailButVaildPasswordAr () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
	}

	@Test(priority = 13)
	public void AddValidEmailButWrongPasswordPasswordAr () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("البريد او كلمة المرور غير صحيح"));
	}

	// check that the user isn't inactive user.
	// Check that the inactive user will no longer able to login to the dashboard.
	@Test(priority = 14)
	public void AddValidEmailAndPasswordInActiveUSerAr () throws InterruptedException {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("a@asala.com");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Thread.sleep(1000);
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordOrNotActiveTxt.getText().contains("ناسف، هذا الحساب غير مفعل، من فضلك تواصل مع مدير لوحة التحكم"));
	}

	// check that the email and password matches an active user.
	// check user role and pages access. 
	// super admin login
	@Test(priority = 15)
	public void AddValidEmailAndPasswordActiveUSerSuperAdmin () {

		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		asalaLoginPage.ClickChangeLanguageToEnglish();

		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickUserName();
		asalaHomePage.ClickSignOut();
	}

	// check user role and pages access. 
	// mall admin login
	@Test(priority = 16)
	public void AddValidEmailAndPasswordActiveUSerMallAdmin () {

		asalaLoginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		asalaHomePage.ClickUserName();
		asalaHomePage.ClickSignOut();
	}

	// check user role and pages access. 
	// store admin login 
	@Test(priority = 17)
	public void AddValidEmailAndPasswordActiveUSerStoreAdmin () {

		asalaLoginPage.AddEmail("ahmed.adel.store@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
	}

}
