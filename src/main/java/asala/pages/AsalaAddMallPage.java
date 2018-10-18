package asala.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsalaAddMallPage extends AsalaPageBase  {

	public AsalaAddMallPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="")
	WebElement mallNameEnglishTxtBox;
	
	@FindBy(id="")
	WebElement mallNameArabicTxtBox;
	
	@FindBy(id="")
	WebElement mallPhotoBt;
	
	

}
