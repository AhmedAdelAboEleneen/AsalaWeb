package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaMangeCategoriesPage extends AsalaPageBase {

	public AsalaMangeCategoriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="addNew-btn")
	WebElement addNewCategoryBt;

	@FindBy(id="edit-4")
	WebElement editCategoryBt;

	@FindBy(id="delete-59")
	WebElement deleteEnCategoryBt;

	@FindBy(id="delete-60")
	WebElement deleteArCategoryBt;

	@FindBy(id="btn-primary")
	WebElement confirmDeleteCategoryBt;


	@FindBy(id="page-link-5")
	WebElement pageBt;


	public void ClickToAddNewCategory () {

		clickButton(addNewCategoryBt);
	}

	public void ClickEditCategory () {

		clickButton(editCategoryBt);
	}

	public void ClickDeleteCategory () {

		clickButton(deleteEnCategoryBt);
	}

	public void ClickDeleteArCategory () {

		clickButton(deleteArCategoryBt);
	}

	public void ClickConfirmDeleteCategory () {

		clickButton(confirmDeleteCategoryBt);
	}

	public void ClickPageNumberSix () {

		clickButton(pageBt);
	}
}
