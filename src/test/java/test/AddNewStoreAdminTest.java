package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewStoreAdminPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageStoreAdminsPage;

public class AddNewStoreAdminTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ManageStoreAdminsPage manageStoreAdminsPage;
    AddNewStoreAdminPage addNewStoreAdminPage;

    Faker fakeData = new Faker();

    String name = fakeData.name().name();

    String email = fakeData.internet().emailAddress();


    // make login
    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        //loginPage.AddEmail("ahmed.adel.mall@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();


        // go to home page & click mange stores
        homePage = new HomePage(driver);
        homePage.ClickMangeStoreAdmin();

        // click add new store admin
        manageStoreAdminsPage = new ManageStoreAdminsPage(driver);
        manageStoreAdminsPage.ClickAddNewAdmin();

    }

    // if user add admin name Empty
    @Test(priority = 2)
    public void IfUseAddAdminName() {
        addNewStoreAdminPage = new AddNewStoreAdminPage(driver);
        addNewStoreAdminPage.AddAddminName("");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgAdminName.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add admin name Empty
    @Test(priority = 3)
    public void IfUseAddAdminNameEmpty() {
        addNewStoreAdminPage = new AddNewStoreAdminPage(driver);
        addNewStoreAdminPage.AddAddminName("");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgAdminName.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add admin name less than 3 char
    @Test(priority = 4)
    public void IfUseAddAdminNameLess() {
        addNewStoreAdminPage.AddAddminName("Te");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgAdminName.getText().contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add admin name more than 30 char
    @Test(priority = 5)
    public void IfUseAddAdminNameMore() {
        addNewStoreAdminPage.AddAddminName("TeeeeeeeeeTeeeeeeeeeTeeeeeeeeee");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgAdminName.getText().contains("This field shouldn’t contain more than 30 character"));
        driver.navigate().refresh();
    }

    // if user add admin name  3 char
    @Test(priority = 6)
    public void IfUseAddNameArabicThree() {
        addNewStoreAdminPage.AddAddminName("Tee");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        driver.navigate().refresh();
    }

    // if user add admin name 30 char
    @Test(priority = 7)
    public void IfUseAddNameArabicThirty() {
        addNewStoreAdminPage.AddAddminName("TeeeeeeeeeTeeeeeeeeeTeeeeeeeee");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        driver.navigate().refresh();
    }

    // check if user add email empty display validation message
    @Test(priority = 8)
    public void IfUserAddEmailEmpty() {
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgEmail.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // check if user add email spaces display validation message
    @Test(priority = 9)
    public void IfUserAddEmailSpaces() {
        addNewStoreAdminPage.AddAdminEmail("          ");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgEmail.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // check if user add email wrong Format display validation message
    @Test(priority = 10)
    public void IfUserAddEmailWrongformat() {
        addNewStoreAdminPage.AddAdminEmail("test");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add email numbers  display validation message
    @Test(priority = 11)
    public void IfUserAddEmailNumbers() {
        addNewStoreAdminPage.AddAdminEmail("1234");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgEmail.getText().contains("Please enter a valid email"));
        driver.navigate().refresh();
    }

    // check if user add valid email don't display validation message
    @Test(priority = 12)
    public void IfUserAddValidEmail() {
        addNewStoreAdminPage.AddAdminEmail("a@a.aa");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        driver.navigate().refresh();
    }

    // add password less than 6 char
    @Test(priority = 13)
    public void IfUserAddPasswordLessThanSixChar() throws InterruptedException {
        addNewStoreAdminPage.SelectMallInAdmin();
        Thread.sleep(5000);
        addNewStoreAdminPage.SelectStoreInAdmin();
        addNewStoreAdminPage.AddAddminName(name);
        addNewStoreAdminPage.AddAdminEmail(email);
        System.out.println(email);
        addNewStoreAdminPage.AddPasswordInAdmin("1234");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Assert.assertTrue(addNewStoreAdminPage.errorMsgPasssword.getText().contains("Password must be 6 letters at least"));
        driver.navigate().refresh();
    }

    // add email already exist
    @Test(priority = 14)
    public void IfUserAddEmailAlreadyExist() throws InterruptedException {
        addNewStoreAdminPage.SelectMallInAdmin();
        addNewStoreAdminPage.SelectStoreInAdmin();
        addNewStoreAdminPage.AddAddminName(name);
        addNewStoreAdminPage.AddAdminEmail("a@a.com");
        System.out.println(email);
        addNewStoreAdminPage.AddPasswordInAdmin("123456");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Thread.sleep(5000);
        Assert.assertTrue(addNewStoreAdminPage.errorMsgEmail.getText().contains("Another admin is using this email, please enter a new email"));
        driver.navigate().refresh();
    }

    // add valid store admin
    @Test(priority = 15)
    public void IfUserAddValidStoreAdmin() throws InterruptedException {
        addNewStoreAdminPage.SelectMallInAdmin();
        addNewStoreAdminPage.SelectStoreInAdmin();
        addNewStoreAdminPage.AddAddminName(name);
        addNewStoreAdminPage.AddAdminEmail(email);
        System.out.println(email);
        addNewStoreAdminPage.AddPasswordInAdmin("123456");
        addNewStoreAdminPage.ClickToSaveInAdmin();
        Thread.sleep(5000);
        Assert.assertTrue(addNewStoreAdminPage.successMsg.getText().contains("New store admin has been added successfully"));
    }

}
