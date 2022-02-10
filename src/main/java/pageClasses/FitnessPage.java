package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ReusableMethods;

/**
 * Page class
 */
public class FitnessPage extends ReusableMethods {

	public FitnessPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Locating Element
	 */
	@FindBy(xpath = "//*[@id='mnintrnlbnr']/ul/li[3]/a/span[2]")
	WebElement gymButton;

	/**
	 * Method to click on the Gym button
	 */
	public GymPage clickGymButton() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(gymButton));
		scrollTo(gymButton);
		gymButton.click();
		return PageFactory.initElements(driver, GymPage.class);
	}
}
