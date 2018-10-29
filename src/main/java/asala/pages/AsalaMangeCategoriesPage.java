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


	public void ClickToAddNewCategory () {

		clickButton(addNewCategoryBt);
	}

}
