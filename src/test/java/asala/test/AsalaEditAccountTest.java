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

	// if user add name empty
	@Test(priority = 2)
	public void UserAddNameFiledEmpty () throws InterruptedException {

		asalaEditAccountPage = new AsalaEditAccountPage(driver);
		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("This field is required"));
	}

	// if user add name more than 30 character 
	@Test(priority = 3)
	public void UserAddNameFiledMore30Char () {

		asalaEditAccountPage.AddNameInEdit("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("This field shouldn’t contain more than 30 character"));
	}

	// if user add name less than 3 character
	@Test(priority = 4)
	public void UserAddNameFiledLess3Char () throws InterruptedException {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Te");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add email empty
	@Test(priority = 5)
	public void UserAddEmptyEmail () throws InterruptedException {
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("This field is required"));
	}

	// if user add email but wrong format 
	@Test(priority = 6)
	public void UserAddWrongEmail () {

		asalaEditAccountPage.AddEmailInEdit("aaa");	
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("Please enter a valid email"));
	}

	// if user add name & email empty 
	@Test(priority = 7)
	public void UserClearNameAndEmail () throws InterruptedException {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("This field is required"));
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("This field is required"));	
	}

	// user clear name & email & change it name = test & email = ahmed.adel@ibtikar.net.sa
	@Test(priority = 8)
	public void UserAddValidEmailAndName () {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Test");
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.AddEmailInEdit("ahmed.adel@ibtikar.net.sa");
		asalaEditAccountPage.ClickSaveInEdit();
	}

	// if user add old password but empty new password & confirm password 
	@Test(priority = 9)
	public void UserAddOldPasswordButEmptyNewandConfirm () throws InterruptedException {

		asalaEditAccountPage.AddOldPasswordInEdit("123456");
		asalaEditAccountPage.AddNewPasswordInEdit("");
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("Password must be 6 letters at least"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("Password must be 6 letters at least"));
	}

	// if user add old password wrong & new password correct value & confirm password empty 
	@Test(priority = 10)
	public void UserAddOldPasswordWrongAndAddNewPasswordValid () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.AddOldPasswordInEdit("12345678989");
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("123456");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("new passwords and confirm password are not matched"));
	}

	// if user add old password correct & new password correct value & confirm password empty 
	@Test(priority = 11)
	public void UserAddNewPasswordButNoConfirm () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.AddOldPasswordInEdit("123456");
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("1234567");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("new passwords and confirm password are not matched"));
	}

	// if user add old password empty & new password correct value & confirm password empty 
	@Test(priority = 12)
	public void UserAddNewPasswordButEmptyOldAndConfirm () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("1234567");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("Password must be 6 letters at least"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("new passwords and confirm password are not matched"));
	}

	// if user add old password empty  & new password empty & confirm password correct value  
	@Test(priority = 13)
	public void UserAddConfirmPasswordButEmptyOldAndNew () {

		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("1234567");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("Password must be 6 letters at least"));
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("Password must be 6 letters at least"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("new passwords and confirm password are not matched"));
	}

	// if user add old password wrong & new password = old password  & confirm password = new password  
	@Test(priority = 14)
	public void UserAddOldWrongAndNewMatchWithWrong () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddOldPasswordInEdit("1234567");
		asalaEditAccountPage.AddNewPasswordInEdit("123456");
		asalaEditAccountPage.AddConfirmPasswordInEdit("123456");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("wrong password"));
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("new password should be different than the old password"));
	}


	// if user change password to 1234567
	@Test(priority = 15)
	public void ChangePassword () {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddOldPasswordInEdit("123456");
		asalaEditAccountPage.AddNewPasswordInEdit("1234567");
		asalaEditAccountPage.AddConfirmPasswordInEdit("1234567");
		asalaEditAccountPage.ClickSaveInEdit();
	}

	// edit user profile name & email & password  
	@Test(priority = 16)
	public void ChangePasswordAgain () {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddNameInEdit("Test");
		asalaEditAccountPage.AddEmailInEdit("ahmed.adel@ibtikar.net.sa");
		asalaEditAccountPage.AddOldPasswordInEdit("1234567");
		asalaEditAccountPage.AddNewPasswordInEdit("123456");
		asalaEditAccountPage.AddConfirmPasswordInEdit("123456");
		asalaEditAccountPage.ClickSaveInEdit();

		asalaHomePage.ClickUserName();
		asalaHomePage.ClickSignOut();

		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();	

		asalaHomePage.ClickUserName();
		asalaHomePage.ClickProfile();
	}

	// same scenario but Arabic 
	@Test(priority = 17)
	public void UserAddNameFiledEmptyAr () throws InterruptedException {

		asalaHomePage.ClickChangeLanguageToArabic();
		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 18)
	public void UserAddNameFiledMore30CharAr () {

		asalaEditAccountPage.AddNameInEdit("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
	}

	@Test(priority = 19)
	public void UserAddNameFiledLess3CharAr () throws InterruptedException {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Te");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
	}

	@Test(priority = 20)
	public void UserAddEmptyEmailAr () throws InterruptedException {
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 21)
	public void UserAddWrongEmailAr () throws InterruptedException {

		asalaEditAccountPage.AddEmailInEdit("aaa");	
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
	}

	@Test(priority = 22)
	public void UserClearNameAndEmailAr () throws InterruptedException {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(asalaEditAccountPage.nameValidationMessaga.getText().contains("هذا الحقل مطلوب"));
		Assert.assertTrue(asalaEditAccountPage.emailValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 23)
	public void UserAddValidEmailAndNameAr () {

		asalaEditAccountPage.ClearNameData();
		asalaEditAccountPage.AddNameInEdit("Test");
		asalaEditAccountPage.ClearEmailData();
		asalaEditAccountPage.AddEmailInEdit("ahmed.adel@ibtikar.net.sa");
		asalaEditAccountPage.ClickSaveInEdit();
	}

	@Test(priority = 24)
	public void UserAddOldPasswordButEmptyNewandConfirmAr () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.AddOldPasswordInEdit("123456");
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
	}

	@Test(priority = 25)
	public void UserAddOldPasswordWrongAndAddNewPasswordValidAr () {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.AddOldPasswordInEdit("12345678989");
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("123456");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 26)
	public void UserAddNewPasswordButNoConfirmAr () {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.AddOldPasswordInEdit("123456");
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("1234567");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 27)
	public void UserAddNewPasswordButEmptyOldAndConfirmAr () {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.AddNewPasswordInEdit("1234567");
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 28)
	public void UserAddConfirmPasswordButEmptyOldAndNewAr () {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddConfirmPasswordInEdit("1234567");
		asalaEditAccountPage.ClickSaveInEdit();
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(asalaEditAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 29)
	public void UserAddOldWrongAndNewMatchWithWrongAr () throws InterruptedException {

		asalaEditAccountPage.ClearOldPasswordData();
		asalaEditAccountPage.ClearNewPasswordData();
		asalaEditAccountPage.ClearConfirmpasswrodData();
		asalaEditAccountPage.AddOldPasswordInEdit("1234567");
		asalaEditAccountPage.AddNewPasswordInEdit("123456");
		asalaEditAccountPage.AddConfirmPasswordInEdit("123456");
		asalaEditAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(asalaEditAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور غير صحيحة"));
		Assert.assertTrue(asalaEditAccountPage.newPasswordlValidationMessaga.getText().contains("يجب ان تختلف كلمة المرور الجديدة عن القديمة"));
	}
}
