package baseClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.HomePage;
import utilities.ReadPropertiesFile;

/**
 * DriverSetup class
 */
public class PageBaseClass {

	/**
	 * Instantiating object of Properties Reader file to use it in driver setup
	 */
	public WebDriver driver;

	ReadPropertiesFile rpf = new ReadPropertiesFile(System.getProperty("user.dir") + "\\configuration.properties");

	public void invokeBrowser() {

		/**
		 * Driver Setup
		 */
		try {

			if (rpf.getBrowser().equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
			} else if (rpf.getBrowser().equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("start-maximized");
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments("--disable-notifications");
				driver = new FirefoxDriver(options);
			} else {
				WebDriverManager.operadriver().setup();
				OperaOptions options = new OperaOptions();
				options.addArguments("start-maximized");
				options.addArguments("--disable-blink-features=AutomationControlled");
				options.addArguments("--disable-notifications");
				driver = new OperaDriver();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	/**
	 * Method to load the URL
	 */
	public HomePage loadPage() {
		driver.get(rpf.getUrl());
		return PageFactory.initElements(driver, HomePage.class);
	}

}
