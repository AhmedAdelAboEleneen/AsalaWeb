package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCategoryPage extends PageBase {

    @FindBy(id = "error-msg-catEnglishName")
    public WebElement editcategoryNameEnErrorMsgtxt;
    @FindBy(id = "error-msg-catArabicName")
    public WebElement editcategoryNameArErrorMsgtxt;
    @FindBy(id = "success-msg")
    public WebElement successMsgtxt;
    @FindBy(id = "form-control-catEnglishName")
    WebElement editcategoryNameEntxt;
    @FindBy(id = "form-control-catArabicName")
    WebElement editcategoryNameArtxt;
    @FindBy(id = "save-btn")
    WebElement editSaveBt;

    public EditCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void AddcategoryNameEntxt(String EnValue) {

        setTextElementText(editcategoryNameEntxt, EnValue);
        System.out.println(EnValue);
    }

    public void AddcategoryNameArtxt(String ArValue) {

        setTextElementText(editcategoryNameArtxt, ArValue);
        System.out.println(ArValue);

    }

    public void ClickSumbitToConfirmEditCategory() {

        clickButton(editSaveBt);
    }

    public void ClearNameEn() {

        editcategoryNameEntxt.clear();
    }

    public void ClearNameAr() {

        editcategoryNameArtxt.clear();
    }

}
