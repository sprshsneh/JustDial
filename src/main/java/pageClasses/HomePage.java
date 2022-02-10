package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.ReusableMethods;
import utilities.ReadExcelData;

/**
 * Page class
 */
public class HomePage extends ReusableMethods {

	ReadExcelData red = new ReadExcelData(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Locating Web-Elements
	 */
	@FindBy(id = "city")
	WebElement chooseCity;

	@FindBy(id = "Patna")
	WebElement patna;

	@FindBy(id = "srchbx")
	WebElement searchBox;

	@FindBy(id = "srIconwpr")
	WebElement searchButton;

	@FindBy(id = "h_flist")
	WebElement freeListingButton;

	@FindBy(id = "ContextualHotkey_27")
	WebElement fitnessButton;

	/**
	 * Method to select the city on Home Page
	 */
	public void selectCity() {
		chooseCity.clear();
		String city = red.getDataOfCell("TestData", 4, 0);
		chooseCity.sendKeys(city);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(patna));
		patna.click();
	}

	/**
	 * Method to search for the required service in the search field
	 */
	public void enterService() {
		String service = red.getDataOfCell("TestData", 4, 1);
		searchBox.sendKeys(service);
	}

	/**
	 * Method to click on the search button
	 */
	public CarWashPage clickSearchButton() {
		searchButton.click();
		return PageFactory.initElements(driver, CarWashPage.class);
	}

	/**
	 * Method to click on the free listing button
	 */
	public FreeListingPage clickFreeListingButton() {
		freeListingButton.click();
		return PageFactory.initElements(driver, FreeListingPage.class);
	}

	/**
	 * Method to click on the fitness button
	 */
	public FitnessPage clickFitnessButton() {
		scrollTo(fitnessButton);
		fitnessButton.click();
		return PageFactory.initElements(driver, FitnessPage.class);
	}

}
