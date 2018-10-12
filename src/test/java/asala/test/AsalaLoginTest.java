package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import asala.pages.AsalaLoginPage;

public class AsalaLoginTest extends AsalaTestBase {
	
	AsalaLoginPage asalaLoginPage;
	
	
	@Test(priority = 1)
	public void AddEmailEmptyAndPassword () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your password"));
	}
	
	@Test(priority = 2)
	public void AddEmailEmptyButAddPasword () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}
	
	@Test(priority = 3)
	public void AddEmailButAddPaswordEmpty () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.passwordTxtValidtion.getText().contains("Please enter your password"));
	}
	
	@Test(priority = 4)
	public void AddWrongEmailButVaildPassword () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}
	
	@Test(priority = 5)
	public void AddValidEmailButWrongPasswordPassword () {
	
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("1234567");
		asalaLoginPage.ClickLogin();
		Assert.assertTrue(asalaLoginPage.wrongEmailOrPasswordTxt.getText().contains("Wrong email or password"));
	}
	
	@Test(priority = 6)
	public void AddValidEmailAndPasswordInActiveUSer () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("super@asala.com");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.inActiveUserText.getText().contains("Sorry, this account is no longer active, please contact your dashboard administrator"));
	}
	
	@Test(priority = 7)
	public void AddValidEmailAndPasswordActiveUSer () {
		
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.ClearEmailData();
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.ClearPasswordData();
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();
		//Assert.assertTrue(asalaLoginPage.emailTxtValidtion.getText().contains("Please enter your email"));
	}

}
