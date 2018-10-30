package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaMangeCategoriesPage extends AsalaPageBase {

	public AsalaMangeCategoriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="addNewCat-btn")
	WebElement addNewCategoryBt;
	
	@FindBy(id="edit-4")
	WebElement editCategoryBt;


	public void ClickToAddNewCategory () {

		clickButton(addNewCategoryBt);
	}

	public void ClickEditCategory () {

		clickButton(editCategoryBt);
	}
}
