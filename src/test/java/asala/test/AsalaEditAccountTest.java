package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import asala.pages.AsalaEditAccountPage;
import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;

public class AsalaEditAccountTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaEditAccountPage asalaEditAccountPage;

	// make login with super admin user 
	@Test(priority = 1)
	public void MakeLogin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page & click user & click to get here profile 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickUserName();
		asalaHomePage.ClickProfile();
	}

	@Test(priority = 2)
	public void UserAddNameFiledEmpty () {

		asalaEditAccountPage = new AsalaEditAccountPage(driver);
		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("Please enter your name"));
	}

	@Test(priority = 3)
	public void UserAddNameFiledMore30Char () {

		asalaEditAccountPage.AddNameInEdit("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("Name shouldn’t contain more than 30 character"));
	}

	@Test(priority = 4)
	public void UserAddNameFiledLess3Char () throws InterruptedException {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Te");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("Name shouldn’t be less than 3 characters"));
	}

	@Test(priority = 5)
	public void UserAddNameFiledsuccess () {
		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Test");
		asalaEditAccountPage.ClickSaveInEdit();
	}

	@Test(priority = 6)
	public void UserAddEmptyEmail () throws InterruptedException {
		Thread.sleep(2000);
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("Please enter your Email"));
	}

	@Test(priority = 7)
	public void UserAddWrongEmail () {

		asalaEditAccountPage.AddEmailInEdit("aaa");	
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("Invalid Email"));
	}

	@Test(priority = 8)
	public void UserAddValidEmail () {

		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.AddEmailInEdit("ahmed.adel@ibtikar.net.sa");
		asalaEditAccountPage.ClickSaveInEdit();
	}

	/*@Test(priority = 9)
	public void UserAddOldPasswordWrong () throws InterruptedException {



	}

	@Test(priority = 10)
	public void UserAddNewpasswordNotMatchWithConfirmPassword () {


	}

	@Test(priority = 11)
	public void UserAddNewPasswordMatchWithNewPassword () {

	}*/

}
