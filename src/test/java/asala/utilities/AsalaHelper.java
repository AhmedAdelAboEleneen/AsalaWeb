package asala.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AsalaHelper {
	
	// Method to take screen shoot when test case fail 
	
		public static void caputreScreenShoot (WebDriver driver , String screenShootName) {
			
			Path dest = Paths.get("./ScreenShots" + screenShootName +".png");
			
			try {
				java.nio.file.Files.createDirectories(dest.getParent());
				FileOutputStream out = new FileOutputStream(dest.toString());
				out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
				out.close();
			} catch (IOException e) {

				System.out.println("Excpetion while take screen shoot"+e.getMessage());
			}
		}

}
