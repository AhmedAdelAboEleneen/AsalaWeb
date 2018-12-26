package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeStoresPage;

public class MangeStoreTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeStoresPage mangeStoresPage;

    // login as super admin to make sure that super admin can see all malls
    @Test(priority = 1)
    public void MakeLoginAndSelectMallAsSuperAdmin() {

        // login
        loginPage = new LoginPage(driver);
        // login in stage server
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        // login in demo server
        //loginPage.AddEmail("super@asala.com");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page
        homePage = new HomePage(driver);
        homePage.ClickManageStores();
    }

    // make search about poma store
    @Test(priority = 2)
    public void MakeSearch() {

        mangeStoresPage = new MangeStoresPage(driver);
        mangeStoresPage.AddTextInSearch("asala");
        mangeStoresPage.ClickSumbitToSearch();
        driver.navigate().refresh();
    }

    // make search for wrong value not in database
    @Test(priority = 3)
    public void MakeSearchWithWrongValue() {

        mangeStoresPage.AddTextInSearch("doooooooooooooooooooooooooooooooooooooooooo");
        mangeStoresPage.ClickSumbitToSearch();
        Assert.assertTrue(mangeStoresPage.searchErrorMsg.getText().contains("No resultes found"));
        driver.navigate().refresh();
    }

    // make search but use AutoComplete
    @Test(priority = 4)
    public void MakeSearchWithValueAutoComplete() {

        mangeStoresPage.AddTextInSearch("Pom");
        mangeStoresPage.AutoComplete();
        driver.navigate().refresh();
    }

    // make filter with mall
    @Test(priority = 5)
    public void MakeFilterWithMall() {

        mangeStoresPage.SelectFilterMallAsSuperAdmin();
        mangeStoresPage.ClickSumbitToSearch();
        mangeStoresPage.SelectFilterMallAll();
        mangeStoresPage.ClickSumbitToSearch();
        driver.navigate().refresh();
    }

    // make filter with mall & category
    @Test(priority = 6)
    public void MakeFilterWithMallAndCategory() throws InterruptedException {

        mangeStoresPage.SelectFilterMallAsSuperAdmin();
        Thread.sleep(3000);
        mangeStoresPage.SelectFilterCategory();
        Thread.sleep(3000);
        mangeStoresPage.ClickSumbitToSearch();
        driver.navigate().refresh();
    }

    // make filter with mall & Search
    @Test(priority = 7)
    public void MakeFilterWithMallAndSearch() throws InterruptedException {

        mangeStoresPage.SelectFilterMallAsSuperAdmin();
        Thread.sleep(3000);
        mangeStoresPage.AddTextInSearch("pom");
        mangeStoresPage.AutoComplete();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    // make filter with mall & category & Search
    @Test(priority = 8)
    public void MakeFilterWithMallAndCategoryAndSearch() throws InterruptedException {

        mangeStoresPage.SelectFilterMallAsSuperAdmin();
        Thread.sleep(3000);
        mangeStoresPage.SelectFilterCategory();
        Thread.sleep(3000);
        mangeStoresPage.AddTextInSearch("asa");
        mangeStoresPage.ClickSumbitToSearch();
        driver.navigate().refresh();
    }

}
