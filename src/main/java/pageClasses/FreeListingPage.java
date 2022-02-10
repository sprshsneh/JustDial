package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.ReusableMethods;
import utilities.ReadExcelData;

/**
 * Page class
 */
public class FreeListingPage extends ReusableMethods {
	String arr[] = null;

	public FreeListingPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Locating Web-Elements
	 */
	@FindBy(id = "fcom")
	WebElement companyName;

	@FindBy(id = "fname")
	WebElement firstName;

	@FindBy(id = "lname")
	WebElement lastName;

	@FindBy(id = "fmb0")
	WebElement mobileNo;

	@FindBy(xpath = "//button[@class='bbtn subbtn']")
	WebElement submitButton;

	@FindBy(id = "fmb0Err")
	WebElement errorMessage;

	@FindBy(xpath = "//div[@class='drop']")
	WebElement title;

	@FindBy(xpath = "//*[@id=\"salopt\"]/li[1]")
	WebElement mr;

	/**
	 * Method to enter the details in all the input fields
	 */
	public void enterDetails() {
		ReadExcelData red = new ReadExcelData(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");
		arr = red.getDataFromRow("TestData", 1);
		companyName.sendKeys(arr[0]);
		title.click();
		mr.click();
		firstName.sendKeys(arr[1]);
		lastName.sendKeys(arr[2]);
		mobileNo.sendKeys(arr[3]);
	}

	/**
	 * Method to click on the submit button
	 */
	public void clickSubmitButton() {
		submitButton.click();
		takeScreenShot("ErrorMessage");
	}

	/**
	 * Method to capture the error message and print it on console
	 */
	public void getErrorMessage() {
		System.out.println("\nError Message:\n" + errorMessage.getText());

	}

	/**
	 * Method to navigate to home page
	 */
	public HomePage navigateBackToHomePage() {
		driver.navigate().back();
		return PageFactory.initElements(driver, HomePage.class);
	}
}