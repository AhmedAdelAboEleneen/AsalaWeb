package asala.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class AsalaMangeStoresPage extends AsalaPageBase {

	public AsalaMangeStoresPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="filter-by-mall")
	WebElement filterByMall;

	@FindBy(id="filter-by-category")
	WebElement filterByCategory;

	@FindBy(id="store-search")
	public WebElement seacrhStoreTxt ;

	@FindBy(id="error-msg-search")
	public WebElement searchErrorMsg;

	@FindBy(id="submit-filters")
	WebElement submitFilterAndSearch;

	@FindBy(id="addNew-btn")
	WebElement addNewStoreBt;

	@FindBy(id="edit-1")
	WebElement editStoreBt;

	@FindBy(id="deactivated-1")
	public WebElement deleteStoreBt;

	@FindBy(id="admin-1")
	public WebElement adminStoreBt;

	@FindBy(id="offers-1")
	WebElement offerStoreBt;

	@FindBy(id="offers-1")
	WebElement reviewsStoreBt;

	public void SelectFilterMallAll () {

		Select selectMall = new Select(filterByMall);
		selectMall.selectByIndex(0);
	}

	public void SelectFilterMallAsSuperAdmin () {

		Select selectMall = new Select(filterByMall);
		selectMall.selectByValue("4");

	}
	public void SelectFilterMallAsMallAdmin () {

		Select selectMall = new Select(filterByMall);
		selectMall.selectByValue("2");

	}

	public void SelectFilterCategoryAll () {

		Select selectCategoru = new Select(filterByCategory);
		selectCategoru.selectByIndex(0);
	}

	public void SelectFilterCategory () {

		Select selectCategoru = new Select(filterByCategory);
		selectCategoru.selectByIndex(4);
	}

	public void AddTextInSearch (String SearchValue) {

		setTextElementText(seacrhStoreTxt, SearchValue);
	}
	public void AutoComplete () {
		
		seacrhStoreTxt.sendKeys(Keys.ARROW_DOWN);
		seacrhStoreTxt.sendKeys(Keys.ENTER);
		seacrhStoreTxt.sendKeys(Keys.ENTER);
	}

	public void ClearSearchValue () {

		seacrhStoreTxt.clear();
	}

	public void ClickSumbitToSearch () {

		clickButton(submitFilterAndSearch);
	}

}
