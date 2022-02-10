package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.ReusableMethods;

/**
 * Page class
 */
public class GymPage extends ReusableMethods {

	public GymPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Locating Web-Elements
	 */
	@FindBy(xpath = "//span[@class='meditle1 lng_commn']")
	List<WebElement> listOfSubMenu;

	/**
	 * Method to capture the list of sub-menu in Gym and print it on console
	 */
	public void displaySubMenu() {
		System.out.println("\nList of sub menu of Gyms :-");
		for (int i = 0; i < listOfSubMenu.size(); i++) {
			System.out.println(listOfSubMenu.get(i).getText());
		}
		takeScreenShot("GymSubMenus");
	}

	/**
	 * Method to close the browser
	 */
	public void closeBrowser() {
		driver.close();
	}
}
