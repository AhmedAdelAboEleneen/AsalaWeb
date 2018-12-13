package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EditMallTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MangeMallsPage mangeMallsPage;
	EditMallPage editMallPage;
	JavascriptExecutor js;


	// make login
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		loginPage = new LoginPage(driver);
		loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
		loginPage.AddPassword("123456");
		loginPage.ClickLogin();

		// go to home page
		homePage = new HomePage(driver);
		homePage.ClickManageCategory();

		// go to mange category screen
		mangeMallsPage = new MangeMallsPage(driver);
		mangeMallsPage.ClickMangeMalls();
		mangeMallsPage.ClickEditMall();
	}

	// if user delete website kink or twitter link or Facebook link or Instagram link & click submit & make refresh will see link you delete display in response
	@Test(priority = 2)
	public void IfUserTryToRemoveAnyLinkAndSubmitIt() {

		editMallPage = new EditMallPage(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,300)");
		editMallPage.ClearAllLinks();
		editMallPage.ClickToSave();
		js.executeScript("scrollBy(0,-300)");
		Assert.assertTrue(editMallPage.sucessMsg.getText().contains("Mall data updated successfully"));

	}

    @Test(priority = 3)
	public void AddNewLinks(){
		js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,300)");
		editMallPage.AddTextInMallWebsite("https://www.google.com.eg");
		editMallPage.AddTextInMallTwitter("https://www.google.com.eg");
		editMallPage.AddTextInMallFacebook("https://www.google.com.eg");
		editMallPage.AddTextInMallInstgram("https://www.google.com.eg");
		editMallPage.ClickToSave();
		js.executeScript("scrollBy(0,-300)");
		Assert.assertTrue(editMallPage.sucessMsg.getText().contains("Mall data updated successfully"));
}
}
