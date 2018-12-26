package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MangeCategoriesPage extends PageBase {

    @FindBy(id = "addNew-btn")
    WebElement addNewCategoryBt;
    @FindBy(id = "filter-by-mall")
    WebElement mallSelect;
    @FindBy(id = "edit-114")
    WebElement editCategoryBt;

    public MangeCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void ClickToAddNewCategory() {

        clickButton(addNewCategoryBt);
    }

    public void SelectMall() {

        Select selectMall = new Select(mallSelect);
        selectMall.selectByValue("4");
    }

    public void ClickEditCategory() {

        clickButton(editCategoryBt);
    }
}
