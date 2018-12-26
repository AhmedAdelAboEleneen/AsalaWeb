package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EditCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class EditCategoryTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeCategoriesPage mangeCategoriesPage;
    EditCategoryPage editCategoryPage;

    // make login
    @Test(priority = 1)
    public void MakeLoginAndSelectMallAsSuuperAdmin() {

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
        homePage.ClickManageCategory();

        // go to mange category screen
        mangeCategoriesPage = new MangeCategoriesPage(driver);
        mangeCategoriesPage.SelectMall();
        mangeCategoriesPage.ClickEditCategory();
    }

    // if user add space in English & Arabic filed no validation message display
    @Test(priority = 2)
    public void IfuserAddSpacesInEnglishAndArabicName() {
        editCategoryPage = new EditCategoryPage(driver);
        editCategoryPage.ClearNameEn();
        editCategoryPage.AddcategoryNameEntxt("        ");
        editCategoryPage.ClearNameAr();
        editCategoryPage.AddcategoryNameArtxt("         ");
        editCategoryPage.ClickSumbitToConfirmEditCategory();
        Assert.assertTrue(editCategoryPage.editcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
        Assert.assertTrue(editCategoryPage.editcategoryNameArErrorMsgtxt.getText().contains("This field is required"));

    }

}