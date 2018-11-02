package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewStore extends PageBase {

	public AddNewStore(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="filter-by-mall")
	WebElement filterByMallDropList ;

	@FindBy(id="error-msg-mall_id")
	public WebElement errorFilterByMall ; 

	@FindBy(id="filter-by-category")
	WebElement filterByCategoryDropList ; 

	@FindBy(id="error-msg-category_id")
	public WebElement errorFilterByCategory ; 

	@FindBy(id="form-control-store_name_ar")
	public WebElement storeNameArTxt ; 

	@FindBy(id="error-msg-store_name_ar")
	WebElement errorMsgNameAr ; 

	@FindBy(id="form-control-store_name_en")
	WebElement storeNameEnTxt ; 

	@FindBy(id="error-msg-store_name_en")
	WebElement errorMsgNameEn ; 

	@FindBy(id="form-control-store_description_ar")
	WebElement storeDescriptionAr ; 
	
	@FindBy(id="error-msg-store_description_ar")
	WebElement errorMsgDescriptionAr ;

	@FindBy(id="form-control-store_description_en")
	public WebElement storeDescriptionEn ; 

	@FindBy(id="error-msg-store_description_en")
	WebElement errorMsgDescriptionEn ; 

	@FindBy(id="logo-input")
	public WebElement logoBt ; 

	@FindBy(id="")
	public WebElement errorMsgLogo ; 

	@FindBy(id="cover-input")
	WebElement coverPhotoBt ; 

	@FindBy(id="")
	WebElement errorMsgCoverPhoto ; 

	@FindBy(id="")
	WebElement activeRadioBt ; 

	@FindBy(id="")
	WebElement openingSoonRadioBt ; 
	
	@FindBy(id="")
	WebElement canRedeemCheckbox ; 

	@FindBy(id="form-control-location")
	WebElement storeLocationTxt ; 
	
	@FindBy(id="error-msg-location")
	WebElement errorMsgLocation ; 

	@FindBy(id="form-control-floor")
	WebElement floorTxt ; 
	
	@FindBy(id="error-msg-floor")
	WebElement errorMsgFloor ; 
}
