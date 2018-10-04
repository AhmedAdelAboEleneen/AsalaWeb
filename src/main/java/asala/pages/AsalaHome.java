package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaHome extends AsalaPageBase {

	public AsalaHome(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTextBox ; 
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn ; 
	
	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}
}
