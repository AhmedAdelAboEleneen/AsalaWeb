package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaMangeMallsPage extends AsalaPageBase {

	public AsalaMangeMallsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="")
	WebElement importMallBt;
	
	@FindBy(id="")
	WebElement addNewMallBt;
	
	@FindBy(id="")
	WebElement EditMallBt;
	
	@FindBy(id="")
	WebElement activeMallBt;
	
	public void ClickImportMall () {
		clickButton(importMallBt);
	}
	
	public void ClickAddMall () {
		clickButton(addNewMallBt);
	}
	
	public void ClickEditMall () {
		clickButton(EditMallBt);
	}
	
	public void ClickActiveMall () {
		clickButton(activeMallBt);
	}
}
