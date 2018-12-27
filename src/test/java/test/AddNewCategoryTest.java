package test;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddNewCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MangeCategoriesPage;

public class AddNewCategoryTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    MangeCategoriesPage mangeCategoriesPage;
    AddNewCategoryPage addNewCategoryPage;

    Faker fakeData = new Faker();

    String Name1 = fakeData.name().name();
    String Name2 = fakeData.name().fullName();
    String Name3 = fakeData.name().firstName();
    String Name4 = fakeData.name().username();

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

        mangeCategoriesPage = new MangeCategoriesPage(driver);
        mangeCategoriesPage.ClickToAddNewCategory();
    }

    // if user add name en & ar empty
    @Test(priority = 2)
    public void UserAddNameEnEmptyAndNameArEmpty() {

        addNewCategoryPage = new AddNewCategoryPage(driver);
        addNewCategoryPage.AddcategoryNameEntxt("");
        addNewCategoryPage.AddcategoryNameArtxt("");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name en & ar less than 3 character
    @Test(priority = 3)
    public void UserAddNameEnAndNameArLessThanThreecharacter() {

        addNewCategoryPage.AddcategoryNameEntxt("Te");
        addNewCategoryPage.AddcategoryNameArtxt("Te");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText()
                .contains("This field shouldn’t be less than 3 characters"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText()
                .contains("This field shouldn’t be less than 3 characters"));
        driver.navigate().refresh();
    }

    // if user add name en & ar more than 30 character
    @Test(priority = 4)
    public void UserAddNameEnAndNameArMoreThanMaxcharacter() throws InterruptedException {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        addNewCategoryPage.ClearNameAr();
        addNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Thread.sleep(3000);
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field shouldn’t contain more than 30 characters"));
        driver.navigate().refresh();
    }

    // if user add name en & ar empty
    @Test(priority = 5)
    public void UserAddNameEnAndNameArEmpty() {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameEntxt("Testtttt");
        addNewCategoryPage.ClearNameAr();
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name en empty & ar
    @Test(priority = 6)
    public void UserAddNameEnEmptyAndNameAr() {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameArtxt("Testtttttt");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    // if user add name en & ar space
    @Test(priority = 7)
    public void UserAddNameEnAndNameArSpace() {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameEntxt("     ");
        addNewCategoryPage.ClearNameAr();
        addNewCategoryPage.AddcategoryNameArtxt("     ");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("This field is required"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("This field is required"));
        driver.navigate().refresh();
    }

    @Test(priority = 8)
    public void UserAddNameEnEmptyAndNameArEmptyAr() {

        driver.navigate().refresh();
        homePage.ClickChangeLanguageToArabic();
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
        driver.navigate().refresh();
    }

    // if user add name en & ar less than 3 character
    @Test(priority = 9)
    public void UserAddNameEnAndNameArLessThanThreecharacterAr() {

        addNewCategoryPage.AddcategoryNameEntxt("Te");
        addNewCategoryPage.AddcategoryNameArtxt("Te");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(
                addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
        Assert.assertTrue(
                addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تقل عدد الحروف عن 3 أحرف"));
        driver.navigate().refresh();
    }

    // if user add name en & ar more than 30 character
    @Test(priority = 10)
    public void UserAddNameEnAndNameArMoreThanMaxcharacterAr() throws InterruptedException {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameEntxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        addNewCategoryPage.ClearNameAr();
        addNewCategoryPage.AddcategoryNameArtxt("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Thread.sleep(3000);
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("يجب الا تزيد عدد الحروف عن 30 حرف"));
        driver.navigate().refresh();
    }

    // if user add name en & ar empty
    @Test(priority = 11)
    public void UserAddNameEnAndNameArEmptyAr() {

        driver.navigate().refresh();
        addNewCategoryPage.AddcategoryNameEntxt("Testtttttt");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
        driver.navigate().refresh();
    }

    // if user add name en & ar space
    @Test(priority = 12)
    public void UserAddNameEnAndNameArSpaceAr() {

        addNewCategoryPage.ClearNameEn();
        addNewCategoryPage.AddcategoryNameEntxt("     ");
        addNewCategoryPage.ClearNameAr();
        addNewCategoryPage.AddcategoryNameArtxt("     ");
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.addcategoryNameEnErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
        Assert.assertTrue(addNewCategoryPage.addcategoryNameArErrorMsgtxt.getText().contains("هذا الحقل مطلوب"));
        driver.navigate().refresh();
    }

    @Test(priority = 13)
    public void UserAddNameEnAndNameAr() {

        driver.navigate().refresh();
        addNewCategoryPage.AddcategoryNameEntxt(Name1);
        addNewCategoryPage.AddcategoryNameArtxt(Name2);
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.successMsgtxt.getText().contains("تم إضافة تصنيف جديد بنجاح"));
        driver.navigate().refresh();

    }

    @Test(priority = 14)
    public void UserAddNameEnAndName() {

        driver.navigate().refresh();
        homePage.ClickChangeLanguageToEnglish();
        addNewCategoryPage.AddcategoryNameEntxt(Name3);
        addNewCategoryPage.AddcategoryNameArtxt(Name4);
        addNewCategoryPage.ClickSumbitToAddCategory();
        Assert.assertTrue(addNewCategoryPage.successMsgtxt.getText().contains("New category has been added successfully"));
    }
}
