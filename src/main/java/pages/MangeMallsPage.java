package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MangeMallsPage extends PageBase {

	public MangeMallsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "import-btn")
	WebElement importMallBt;

	@FindBy(id = "addNew-btn")
	WebElement addNewMallBt;

	@FindBy(id = "success-msg")
	public WebElement successTxt;

	@FindBy(id = "edit-4")
	WebElement EditMallBt;

	@FindBy(id = "activated-4")
	WebElement activeMallBt;

	@FindBy(id = "deactivated-4")
	WebElement deactiveMallBt;

	@FindBy(id = "activated-4")
	public WebElement activeTxt;

	@FindBy(id = "deactivated-4")
	public WebElement deactiveTxt;

	@FindBy(id = "btn-default")
	WebElement CancelBt;

	@FindBy(id = "btn-primary")
	WebElement confirmBt;

	public void ClickImportMall() {
		clickButton(importMallBt);
	}

	public void ClickAddMall() {
		clickButton(addNewMallBt);
	}

	public void ClickEditMall() {
		clickButton(EditMallBt);
	}

	public void ClickActiveMall() {
		clickButton(activeMallBt);
	}

	public void ClickDeactiveMall() {
		clickButton(deactiveMallBt);
	}

	public void ClickToCancel() {
		clickButton(CancelBt);
	}

	public void ClickToConfirm() {
		clickButton(confirmBt);
	}
}
