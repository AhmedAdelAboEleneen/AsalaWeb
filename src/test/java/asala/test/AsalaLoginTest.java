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
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your password"));
	}

	// if user try to make login add email but wrong format & password 
	/*@Test(priority = 2)
	public void AddEmailEmptyWrongFormat () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your password"));
	}*/

	@Test(priority = 3)
	public void AddEmailEmptyButAddPasword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}

	// if user try to make login add email but invalid password 
	@Test(priority = 4)
	public void AddEmailButAddPaswordEmpty () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your password"));
	}

	@Test(priority = 5)
	public void AddWrongEmailButVaildPassword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}

	@Test(priority = 6)
	public void AddValidEmailButWrongPasswordPassword () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordTxt.getText().contains("Wrong email or password"));
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

	// check that the email and password matches an active user.
	// check user role and pages access. 
	@Test(priority = 8)
	public void AddValidEmailAndPasswordActiveUSerSuperAdmin () {

		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}
	
	// check user role and pages access. 
	/*@Test(priority = 9)
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
	@Test(priority = 10)
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
