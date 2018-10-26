package asala.test;

import org.testng.annotations.Test;
import asala.pages.AsalaHomePage;
import asala.pages.AsalaLoginPage;
import asala.pages.AsalaMangeStoresPage;

public class AsalaMangeStoreTest extends AsalaTestBase {
	
	AsalaLoginPage asalaLoginPage;
	AsalaHomePage asalaHomePage;
	AsalaMangeStoresPage asalaMangeStoresPage;

	@Test(priority = 1)
	public void MakeLoginAndSelectMallAsSuuperAdmin() {

		// login
		asalaLoginPage = new AsalaLoginPage(driver);
		asalaLoginPage.AddEmail("ahmed.adel@ibtikar.net.sa");
		asalaLoginPage.AddPassword("123456");
		asalaLoginPage.ClickLogin();

		// go to home page & click user & click to get here profile 
		asalaHomePage = new AsalaHomePage(driver);
		asalaHomePage.ClickManageStores();
		
		// as super admin can select all his malls
		asalaMangeStoresPage = new AsalaMangeStoresPage(driver);
		asalaMangeStoresPage.SelectFilterMallAsSuperAdmin();
		asalaMangeStoresPage.ClickSumbitToSearch();
		
		//logout
		asalaHomePage.ClickUserName();
		asalaHomePage.ClickSignOut();
	}
	
	@Test(priority = 2)
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
				
				//logout
				asalaHomePage.ClickUserName();
				asalaHomePage.ClickSignOut();
	}

}
