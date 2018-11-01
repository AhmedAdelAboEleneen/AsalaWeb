package asala.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AsalaPageBase {
	
	public WebDriver driver;
	public JavascriptExecutor jse ; 
	public Select select ; 
	public Actions action ; 

	// create constructor
	public AsalaPageBase(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public static void clickButton(WebElement button) 
	{
		button.click();
	}
	
	public static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	public void scrollToBottom() 
	
	{
		jse.executeScript("scrollBy(0,1000)"); 
	}
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}

}
