package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void startDriver(@Optional("firefox") String browserName) {

        if (browserName.equalsIgnoreCase("firefox")) {

            // For Windos
            //System.setProperty("webdriver.gecko.driver",
                   // System.getProperty("user.dir") + "/drivers/geckodriver.exe");

            // For Linux
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "/drivers/geckodriver");

            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/drivers/chromedriver");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Stage Link
        driver.navigate().to("https://asala-dashboard.ibtikar.net.sa/auth/login");
        // Demo Link
<<<<<<< HEAD
       // driver.navigate().to("https://asala-dashboard-demo.ibtikar.net.sa/auth/login");
=======
      //  driver.navigate().to("https://asala-dashboard-demo.ibtikar.net.sa/auth/login");
>>>>>>> master

    }

    @AfterTest
    public void stopDriver() {

        driver.quit();
    }

    // Take Screenshot when test case fail and add it in screenshot folder
    @AfterMethod
    public void screenShootsOnFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Failed!");
            System.out.println("Taking ScreenShot.......");
            Helper.caputreScreenShoot(driver, result.getName());

        }
    }
}
