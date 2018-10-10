package asala.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import asala.utilities.AsalaHelper;

public class AsalaTestBase {
	
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	@Test
	public void startDriver(@Optional ("firefox") String browserName) {
		
		if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "/home/be-max/Downloads/Drivres/geckodriver");
			driver = new FirefoxDriver();
			
		}else if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/home/be-max/Downloads/Drivres/chromedriver");
			driver = new ChromeDriver();
		}

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() {

		driver.quit();
	}
	
	//Take Screenshot when test case fail and add it in screenshot folder
	@AfterMethod
	public void screenShootsOnFailure (ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("Failed!");
			System.out.println("Taking ScreenShot.......");
			AsalaHelper.caputreScreenShoot(driver, result.getName());
			
		}
		
	}
	

}
