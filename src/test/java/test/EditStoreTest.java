package test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditStorePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeStoresPage;

public class EditStoreTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeStoresPage mangeStoresPage;
    EditStorePage editStorePage;
    JavascriptExecutor js;

    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page & click mange stores
        homePage = new HomePage(driver);
        homePage.ClickManageStores();
    }

    // select Kadi Mall & chose store number 293
    @Test(priority = 2)
    public void SelectKadiMall() {

        mangeStoresPage = new MangeStoresPage(driver);
        mangeStoresPage.SelectFilterMallAsSuperAdmin();
        mangeStoresPage.ClickSumbitToSearch();

        editStorePage = new EditStorePage(driver);
        editStorePage.CLickToEditStore();
    }

    // if user change the mall & don't select category & click save no validation message display
    @Test(priority = 3)
    public void ChangeMall() throws InterruptedException {

        driver.navigate().refresh();
        editStorePage.SelectMall();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        editStorePage.ClickToSave();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(editStorePage.errorCategorySelect.getText().contains("Please select a category"));
        Assert.assertTrue(editStorePage.errorMsgFloor.getText().contains("Please select a floor"));
    }

    //if user add a second phone number & click save click back & click on same store again user will be see only one phone number
    @Test(priority = 4)
    public void AddSecondNumber() throws InterruptedException {

        driver.navigate().refresh();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,-3000)");
        editStorePage.ClickToAddMorePhone();
        editStorePage.AddPhoneTwo("966511234567");
        editStorePage.ClickToSave();
        js.executeScript("scrollBy(0,3000)");
        Thread.sleep(5000);
        Assert.assertTrue(editStorePage.sucessMsg.getText().contains("Store information has been Updated successfully"));
        driver.navigate().refresh();
        js.executeScript("scrollBy(0,-3000)");
        Thread.sleep(5000);
        Assert.assertTrue(editStorePage.phoneNumber2Txt.getText().contains("966511234567"));
        editStorePage.ClickToRemovePhone();
        driver.navigate().refresh();
    }

    //if user try to edit only one photo logo or cover the change don't apply
    @Test(priority = 5)
    public void ChangeLogo() throws InterruptedException {

        driver.navigate().refresh();
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        editStorePage.UploadPNG();
        editStorePage.ClickToSave();
        driver.navigate().refresh();
    }
}
