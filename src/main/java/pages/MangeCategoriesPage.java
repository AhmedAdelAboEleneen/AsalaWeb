package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangeCategoriesPage extends PageBase {

	public MangeCategoriesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "addNew-btn")
	WebElement addNewCategoryBt;

	@FindBy(id = "edit-4")
	WebElement editCategoryBt;

	@FindBy(id = "delete-61")
	WebElement deleteEnCategoryBt;

	@FindBy(id = "delete-62")
	WebElement deleteArCategoryBt;

	@FindBy(id = "btn-primary")
	WebElement confirmDeleteCategoryBt;

	@FindBy(id = "page-link-5")
	WebElement pageBt;

	public void ClickToAddNewCategory() {

		clickButton(addNewCategoryBt);
	}

	public void ClickEditCategory() {

		clickButton(editCategoryBt);
	}

	public void ClickDeleteFirstCategory() {

		clickButton(deleteEnCategoryBt);
	}

	public void ClickDeleteSecondeCategory() {

		clickButton(deleteArCategoryBt);
	}

	public void ClickConfirmDeleteCategory() {

		clickButton(confirmDeleteCategoryBt);
	}

	public void ClickPageNumberSix() {

		clickButton(pageBt);
	}
}
