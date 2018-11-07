package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class SelectMallCategory extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeCategoriesPage mangeCategoriesPage;

    @Test(priority = 1)
    public void MakeLogin() {

        // login
        loginPage = new LoginPage(driver);
        loginPage.AddEmail("ahmed.adel.super@ibtikar.net.sa");
        loginPage.AddPassword("123456");
        loginPage.ClickLogin();

        // go to home page select mange category
        homePage = new HomePage(driver);
        homePage.ClickManageCategory();
    }

    @Test(priority = 2)
    public void ClickSelectCategory (){
        mangeCategoriesPage = new MangeCategoriesPage(driver);
        mangeCategoriesPage.ClickToSelectMallCategory();
    }
}
