package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class EditAccountTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	EditAccountPage editAccountPage;

	// make login with super admin user
	@Test(priority = 1)
	public void MakeLogin() {

		// login
		/*loginPage = new LoginPage(driver);
		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();*/

		// go to home page & click user & click to get here profile
		homePage = new HomePage(driver);
		homePage.ClickUserName();
		homePage.ClickProfile();
	}

	// if user add name empty
	@Test(priority = 2)
	public void UserAddNameFiledEmpty() throws InterruptedException {

		editAccountPage = new EditAccountPage(driver);
		editAccountPage.ClearNameData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText().contains("This field is required"));
	}

	// if user add name more than 30 character
	@Test(priority = 3)
	public void UserAddNameFiledMore30Char() {

		editAccountPage.AddNameInEdit("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText()
				.contains("This field shouldn’t contain more than 30 character"));
	}

	// if user add name less than 3 character
	@Test(priority = 4)
	public void UserAddNameFiledLess3Char() throws InterruptedException {

		editAccountPage.ClearNameData();
		editAccountPage.AddNameInEdit("Te");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText()
				.contains("This field shouldn’t be less than 3 characters"));
	}

	// if user add email empty
	@Test(priority = 5)
	public void UserAddEmptyEmail() throws InterruptedException {
		editAccountPage.ClearEmailData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("This field is required"));
	}

	// if user add email but wrong format
	@Test(priority = 6)
	public void UserAddWrongEmail() {

		editAccountPage.AddEmailInEdit("aaa");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("Please enter a valid email"));
	}

	// if user add name & email empty
	@Test(priority = 7)
	public void UserClearNameAndEmail() throws InterruptedException {

		editAccountPage.ClearNameData();
		editAccountPage.ClearEmailData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText().contains("This field is required"));
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("This field is required"));
	}

	// user clear name & email & change it name = test & email =
	// ahmed.adel@ibtikar.net.sa
	@Test(priority = 8)
	public void UserAddValidEmailAndName() {

		editAccountPage.ClearNameData();
		editAccountPage.AddNameInEdit("Test");
		editAccountPage.ClearEmailData();
		editAccountPage.AddEmailInEdit("ahmed.adel.super@ibtikar.net.sa");
		editAccountPage.ClickSaveInEdit();
	}

	// if user add old password but empty new password & confirm password
	@Test(priority = 9)
	public void UserAddOldPasswordButEmptyNewandConfirm() throws InterruptedException {

		editAccountPage.AddOldPasswordInEdit("123456");
		editAccountPage.AddNewPasswordInEdit("");
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(editAccountPage.newPasswordlValidationMessaga.getText()
				.contains("Password must be 6 letters at least"));
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("Password must be 6 letters at least"));
	}

	// if user add old password wrong & new password correct value & confirm
	// password empty
	@Test(priority = 10)
	public void UserAddOldPasswordWrongAndAddNewPasswordValid() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.AddOldPasswordInEdit("12345678989");
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("123456");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("new passwords and confirm password are not matched"));
	}

	// if user add old password correct & new password correct value & confirm
	// password empty
	@Test(priority = 11)
	public void UserAddNewPasswordButNoConfirm() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.AddOldPasswordInEdit("123456");
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("1234567");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("new passwords and confirm password are not matched"));
	}

	// if user add old password empty & new password correct value & confirm
	// password empty
	@Test(priority = 12)
	public void UserAddNewPasswordButEmptyOldAndConfirm() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("1234567");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.OldPasswordlValidationMessaga.getText()
				.contains("Password must be 6 letters at least"));
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("new passwords and confirm password are not matched"));
	}

	// if user add old password empty & new password empty & confirm password
	// correct value
	@Test(priority = 13)
	public void UserAddConfirmPasswordButEmptyOldAndNew() {

		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("1234567");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.OldPasswordlValidationMessaga.getText()
				.contains("Password must be 6 letters at least"));
		Assert.assertTrue(editAccountPage.newPasswordlValidationMessaga.getText()
				.contains("Password must be 6 letters at least"));
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("new passwords and confirm password are not matched"));
	}

	// if user add old password wrong & new password = old password & confirm
	// password = new password
	@Test(priority = 14)
	public void UserAddOldWrongAndNewMatchWithWrong() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddOldPasswordInEdit("1234567");
		editAccountPage.AddNewPasswordInEdit("123456");
		editAccountPage.AddConfirmPasswordInEdit("123456");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.OldPasswordlValidationMessaga.getText().contains("wrong password"));
		Assert.assertTrue(editAccountPage.newPasswordlValidationMessaga.getText()
				.contains("new password should be different than the old password"));
	}

	// if user change password to 1234567
	@Test(priority = 15)
	public void ChangePassword() {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddOldPasswordInEdit("123456");
		editAccountPage.AddNewPasswordInEdit("1234567");
		editAccountPage.AddConfirmPasswordInEdit("1234567");
		editAccountPage.ClickSaveInEdit();
	}

	// edit user profile name & email & password
	@Test(priority = 16)
	public void ChangePasswordAgain() {

		editAccountPage.ClearNameData();
		editAccountPage.ClearEmailData();
		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddNameInEdit("Test");
		editAccountPage.AddEmailInEdit("ahmed.adel.super@ibtikar.net.sa");
		editAccountPage.AddOldPasswordInEdit("1234567");
		editAccountPage.AddNewPasswordInEdit("123456");
		editAccountPage.AddConfirmPasswordInEdit("123456");
		editAccountPage.ClickSaveInEdit();

		homePage.ClickUserName();
		homePage.ClickSignOut();

		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();

		homePage.ClickUserName();
		homePage.ClickProfile();
	}

	// same scenario but Arabic
	@Test(priority = 17)
	public void UserAddNameFiledEmptyAr() throws InterruptedException {

		homePage.ClickChangeLanguageToArabic();
		editAccountPage.ClearNameData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(3000);
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 18)
	public void UserAddNameFiledMore30CharAr() {

		editAccountPage.AddNameInEdit("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(
				editAccountPage.nameValidationMessaga.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
	}

	@Test(priority = 19)
	public void UserAddNameFiledLess3CharAr() throws InterruptedException {

		editAccountPage.ClearNameData();
		editAccountPage.AddNameInEdit("Te");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
	}

	@Test(priority = 20)
	public void UserAddEmptyEmailAr() throws InterruptedException {
		editAccountPage.ClearEmailData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 21)
	public void UserAddWrongEmailAr() throws InterruptedException {

		editAccountPage.AddEmailInEdit("aaa");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("برجاء إدخال بريد إلكتروني صحيح"));
	}

	@Test(priority = 22)
	public void UserClearNameAndEmailAr() throws InterruptedException {

		editAccountPage.ClearNameData();
		editAccountPage.ClearEmailData();
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(5000);
		Assert.assertTrue(editAccountPage.nameValidationMessaga.getText().contains("هذا الحقل مطلوب"));
		Assert.assertTrue(editAccountPage.emailValidationMessaga.getText().contains("هذا الحقل مطلوب"));
	}

	@Test(priority = 23)
	public void UserAddValidEmailAndNameAr() {

		editAccountPage.ClearNameData();
		editAccountPage.AddNameInEdit("Test");
		editAccountPage.ClearEmailData();
		editAccountPage.AddEmailInEdit("ahmed.adel.super@ibtikar.net.sa");
		editAccountPage.ClickSaveInEdit();
	}

	@Test(priority = 24)
	public void UserAddOldPasswordButEmptyNewandConfirmAr() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.AddOldPasswordInEdit("123456");
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(
				editAccountPage.newPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(
				editAccountPage.confirmPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
	}

	@Test(priority = 25)
	public void UserAddOldPasswordWrongAndAddNewPasswordValidAr() {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.AddOldPasswordInEdit("12345678989");
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("123456");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 26)
	public void UserAddNewPasswordButNoConfirmAr() {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.AddOldPasswordInEdit("123456");
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("1234567");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 27)
	public void UserAddNewPasswordButEmptyOldAndConfirmAr() {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.AddNewPasswordInEdit("1234567");
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(
				editAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 28)
	public void UserAddConfirmPasswordButEmptyOldAndNewAr() {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddConfirmPasswordInEdit("1234567");
		editAccountPage.ClickSaveInEdit();
		Assert.assertTrue(
				editAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(
				editAccountPage.newPasswordlValidationMessaga.getText().contains("كلمة المرور لا تقل عن 6 أحرف"));
		Assert.assertTrue(editAccountPage.confirmPasswordlValidationMessaga.getText()
				.contains("كلمة المرور الجديدة غير متطابقة"));
	}

	@Test(priority = 29)
	public void UserAddOldWrongAndNewMatchWithWrongAr() throws InterruptedException {

		editAccountPage.ClearOldPasswordData();
		editAccountPage.ClearNewPasswordData();
		editAccountPage.ClearConfirmpasswrodData();
		editAccountPage.AddOldPasswordInEdit("1234567");
		editAccountPage.AddNewPasswordInEdit("123456");
		editAccountPage.AddConfirmPasswordInEdit("123456");
		editAccountPage.ClickSaveInEdit();
		Thread.sleep(6000);
		Assert.assertTrue(editAccountPage.OldPasswordlValidationMessaga.getText().contains("كلمة المرور غير صحيحة"));
		Assert.assertTrue(editAccountPage.newPasswordlValidationMessaga.getText()
				.contains("يجب ان تختلف كلمة المرور الجديدة عن القديمة"));
	}
}
