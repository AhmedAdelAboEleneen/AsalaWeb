package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import asala.pages.AsalaLoginPage;

public class AsalaLoginTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;

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

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtionWrongMailFormat.getText().contains("Invalid Email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
	}

	@Test(priority = 3)
	public void AddEmailEmptyButAddPasword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your Email"));
	}

	// if user try to make login add email but invalid password 
	@Test(priority = 4)
	public void AddEmailButAddPaswordEmpty () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your Password"));
	}

	@Test(priority = 5)
	public void AddWrongEmailButVaildPassword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtionWrongMailFormat.getText().contains("Invalid Email"));
	}

	@Test(priority = 6)
	public void AddValidEmailButWrongPasswordPassword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordTxt.getText().contains("Wrong email or password"));
	}

	// check that the user isn't inactive user.
	// Check that the inactive user will no longer able to login to the dashboard.
	@Test(priority = 7)
	public void AddValidEmailAndPasswordInActiveUSer () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("super@asala.com");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.inActiveUserText.getText().contains("Sorry, this account is no longer active, please contact your dashboard administrator"));
	}

	@Test(priority = 8)
	public void AddEmailEmptyAndPasswordAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClickChangeLanguageToArabic();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	// if user try to make login add email but wrong format & password 
	@Test(priority = 9)
	public void AddEmailEmptyWrongFormatAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClickChangeLanguageToArabic();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("البريد الإلكتروني غير صحيح"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	@Test(priority = 10)
	public void AddEmailEmptyButAddPaswordAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("من فضلك أدخل البريد الإلكتروني"));
	}

	// if user try to make login add email but invalid password 
	@Test(priority = 11)
	public void AddEmailButAddPaswordEmptyAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("من فضلك أدخل كلمة المرور"));
	}

	@Test(priority = 12)
	public void AddWrongEmailButVaildPasswordAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("البريد الإلكتروني غير صحيح"));
	}

	@Test(priority = 13)
	public void AddValidEmailButWrongPasswordPasswordAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordTxt.getText().contains("Wrong email or password"));
	}

	// check that the user isn't inactive user.
	// Check that the inactive user will no longer able to login to the dashboard.
	@Test(priority = 14)
	public void AddValidEmailAndPasswordInActiveUSerAr () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("super@asala.com");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.inActiveUserText.getText().contains("Sorry, this account is no longer active, please contact your dashboard administrator"));
	}

	// check that the email and password matches an active user.
	// check user role and pages access. 
	@Test(priority = 15)
	public void AddValidEmailAndPasswordActiveUSerSuperAdmin () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
	}

	// check user role and pages access. 
	/*@Test(priority = 16)
	public void AddValidEmailAndPasswordActiveUSerMallAdmin () {

		asalaLoginPage = new AsalaLoginPage(driver);
		// logout here
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}

	// check user role and pages access. 
	@Test(priority = 17)
	public void AddValidEmailAndPasswordActiveUSerStoreAdmin () {

		asalaLoginPage = new AsalaLoginPage(driver);
		// logout here
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel.store@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}*/

}
