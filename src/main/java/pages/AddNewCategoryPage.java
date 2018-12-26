package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCategoryPage extends PageBase {

    @FindBy(id = "error-msg-catEnglishName")
    public WebElement addcategoryNameEnErrorMsgtxt;
    @FindBy(id = "error-msg-catArabicName")
    public WebElement addcategoryNameArErrorMsgtxt;
    @FindBy(id = "success-msg")
    public WebElement successMsgtxt;
    @FindBy(id = "form-control-catEnglishName")
    WebElement addcategoryNameEntxt;
    @FindBy(id = "form-control-catArabicName")
    WebElement addcategoryNameArtxt;
    @FindBy(id = "submit-btn")
    WebElement saveBt;

    public AddNewCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void AddcategoryNameEntxt(String EnValue) {

        setTextElementText(addcategoryNameEntxt, EnValue);
    }

    public void AddcategoryNameArtxt(String ArValue) {

        setTextElementText(addcategoryNameArtxt, ArValue);
    }

    public void ClickSumbitToAddCategory() {

        clickButton(saveBt);
    }

    public void ClearNameEn() {

        addcategoryNameEntxt.clear();
    }

    public void ClearNameAr() {

        addcategoryNameArtxt.clear();
    }

}
