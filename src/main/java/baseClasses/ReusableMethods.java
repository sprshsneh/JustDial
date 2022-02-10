package baseClasses;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;

/**
 * Common methods class
 */
public class ReusableMethods extends PageBaseClass {

	/**
	 * Method to scroll on a web-page
	 */
	public void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * Method to take screenshot on a web-page
	 */
	public void takeScreenShot(String fileName) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\ScreenShot\\" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
