package asala.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeStoresPage;

public class AsalaMangeStoreTest extends AsalaTestBase {

	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaMangeStoresPage asalaMangeStoresPage;

	// login as mall admin to make sure that mall admin can see only his malls 
	/*@Test(priority = 1)
	public void MakeLoginAndSelectMallAsMallAdmin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page & click user & click to get here profile 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickManageStores();

		// as super admin can select all his malls
		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.SelectFilterMallAsMallAdmin();
		asalaMangeStoresPage.ClickSumbitToSearch();
		driver.navigate().refresh();

		//logout
		asalaHomePage.ClickUserName();
		asalaHomePage.ClickSignOut();
	}*/

	// login as super admin to make sure that super admin can see all malls 
	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickManageStores();
	}

	// make search about poma store 
	@Test(priority = 2)
	public void MakeSearch() {

		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.AddTextInSearch("Poma");
		asalaMangeStoresPage.ClickSumbitToSearch();
		driver.navigate().refresh();
	}

	// make search for wrong value not in database 
	@Test(priority = 3)
	public void MakeSearchWithWrongValue() {

		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.AddTextInSearch("doooooooooooooooooooooooooooooooooooooooooo");
		asalaMangeStoresPage.ClickSumbitToSearch();
		Assert.assertTrue(asalaMangeStoresPage.searchErrorMsg.getText().contains("No resultes found"));
		driver.navigate().refresh();
	}

	// make search with filter mall
	@Test(priority = 4)
	public void MakeFilterWithMall() {

		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.SelectFilterMallAsSuperAdmin();
		asalaMangeStoresPage.ClickSumbitToSearch();
		asalaMangeStoresPage.SelectFilterMallAll();
		asalaMangeStoresPage.ClickSumbitToSearch();
		driver.navigate().refresh();
	}

	// make search with filter mall & category 
	@Test(priority = 5)
	public void MakeFilterWithMallAndCategory() throws InterruptedException {

		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.SelectFilterMallAsSuperAdmin();
		Thread.sleep(3000);
		asalaMangeStoresPage.SelectFilterCategory();
		asalaMangeStoresPage.ClickSumbitToSearch();
		driver.navigate().refresh();
	}

	// make search with filter mall & search 
	@Test(priority = 6)
	public void MakeFilterWithMallAndSearch() {

		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.SelectFilterMallAsSuperAdmin();
		asalaMangeStoresPage.ClickSumbitToSearch();
		asalaMangeStoresPage.AddTextInSearch("Poma");
		asalaMangeStoresPage.ClickSumbitToSearch();
		driver.navigate().refresh();
	}
	
	// make search with filter mall & category & search 
		@Test(priority = 7)
		public void MakeFilterWithMallAndCategoryAndSearch() {

			asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
			asalaMangeStoresPage.SelectFilterMallAsSuperAdmin();
			asalaMangeStoresPage.ClickSumbitToSearch();
			asalaMangeStoresPage.AddTextInSearch("Poma");
			asalaMangeStoresPage.ClickSumbitToSearch();
			driver.navigate().refresh();
		}

}
