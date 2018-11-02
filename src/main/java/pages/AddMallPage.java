package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddMallPage extends PageBase  {

	public AddMallPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="")
	WebElement mallNameEnglishTxtBox;
	
	@FindBy(id="")
	WebElement mallNameArabicTxtBox;
	
	@FindBy(id="")
	WebElement mallPhotoBt;
	
	

}
