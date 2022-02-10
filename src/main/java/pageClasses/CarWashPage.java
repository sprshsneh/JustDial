package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
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
public class CarWashPage extends ReusableMethods {

	public CarWashPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Locating Web-Elements
	 */

	@FindBy(id = "distdrop_rat")
	WebElement sortButton;

	@FindBy(xpath = "/html/body/div[2]/header/section/div/div[1]/div[1]/a")
	WebElement homePageIcon;

	@FindBy(xpath = "//section[@id='best_deal_div']/section/span")
	WebElement closePopUp;

	/**
	 * Method to close the ad pop-up
	 */

	public void closePopUp() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
		closePopUp.click();
	}

	/**
	 * Method to extract the car wash services and print it on console
	 */
	public void extractCarWash() {
		List<WebElement> votes = driver.findElements(By.xpath("//*[@class='cntanr']"));
		System.out.println("List Of Car Wash Services\n");
		for (int i = 1; i <= votes.size(); i++) {
			String a = "";
			String xpathOfVotes = "(//*[@class='cntanr'])[" + i + "]/section/div[1]/section/div[1]/p[1]/a/span[3]";
			String xpathOfNames = "(//*[@class='cntanr'])[" + i + "]/section/div[1]/section/div[1]/h2/span/a/span";
			String xpathOfNumbers = "(//*[@class='cntanr'])[" + i
					+ "]/section/div[1]/section/div[1]/p[2]/span/descendant::span";
			String xpathOfRating = "(//*[@class='cntanr'])[" + i + "]/section/div[1]/section/div[1]/p/a/span[1]";
			List<WebElement> numbers = driver.findElements(By.xpath(xpathOfNumbers));
			String carWashName = driver.findElement(By.xpath(xpathOfNames)).getText();
			String voteText = driver.findElement(By.xpath(xpathOfVotes)).getText();
			String rating = driver.findElement(By.xpath(xpathOfRating)).getText();
			float f = Float.parseFloat(rating);
			for (int j = 0; j < numbers.size(); j++) {
				String className = numbers.get(j).getAttribute("class").split("-")[1];
				String digit = mobileClass(className);
				a += digit;
			}
			String vote = voteText.replace(" Votes", "");
			int Vote = Integer.parseInt(vote);
			if (Vote > 20 && f > 4.0) {
				System.out.println(
						"Name:" + carWashName + "\nNumber:" + a + "\nNo. of Votes:" + vote + "\nRating:" + f + "\n");
			}

		}
		takeScreenShot("Carwash");
	}

	/**
	 * Method to go navigate to HomePage
	 */
	public HomePage goToHomePage() {
		homePageIcon.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * Helper method to extract Phone-No.
	 */
	public String mobileClass(String k) {
		String ans = null;
		if (k.equalsIgnoreCase("dc")) {
			ans = "+";
		} else if (k.equalsIgnoreCase("fe")) {
			ans = "(";
		} else if (k.equalsIgnoreCase("hg")) {
			ans = ")";
		} else if (k.equalsIgnoreCase("ba")) {
			ans = "-";
		} else if (k.equalsIgnoreCase("acb")) {
			ans = "0";
		} else if (k.equalsIgnoreCase("yz")) {
			ans = "1";
		} else if (k.equalsIgnoreCase("wx")) {
			ans = "2";
		} else if (k.equalsIgnoreCase("vu")) {
			ans = "3";
		} else if (k.equalsIgnoreCase("ts")) {
			ans = "4";
		} else if (k.equalsIgnoreCase("rq")) {
			ans = "5";
		} else if (k.equalsIgnoreCase("po")) {
			ans = "6";
		} else if (k.equalsIgnoreCase("nm")) {
			ans = "7";
		} else if (k.equalsIgnoreCase("lk")) {
			ans = "8";
		} else if (k.equalsIgnoreCase("ji")) {
			ans = "9";
		}
		return ans;
	}

}
