package testClasses;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import pageClasses.CarWashPage;
import pageClasses.FitnessPage;
import pageClasses.FreeListingPage;
import pageClasses.GymPage;
import pageClasses.HomePage;
import utilities.ExtentReportManager;

/**
 * Test class
 */
public class TestCarWash {
	/**
	 * Instantiating the object of page classes and extent report class
	 */
	ExtentReports report = ExtentReportManager.getReport();
	ExtentTest logger;

	PageBaseClass pbc;
	HomePage hp;
	FreeListingPage flp;
	FitnessPage fp;
	GymPage gp;

	/**
	 * This test will execute before the execution of any test
	 */
	@BeforeSuite
	public void openBrowser() {
		pbc = new PageBaseClass();
		pbc.invokeBrowser();
		hp = pbc.loadPage();

	}

	/**
	 * This test will extract the car wash services listen down
	 */
	@Test(priority = 0, groups = { "Sanity", "Reggression" })
	public void extractCarWashServices() {
		logger = report.createTest("Extract Car Wash Services");
		hp.selectCity();
		logger.log(Status.PASS, "City Selected successfully");
		hp.enterService();
		logger.log(Status.PASS, "Car Wash Services enetered in the search field");
		CarWashPage cwp = hp.clickSearchButton();
		logger.log(Status.PASS, "Search Button clicked successfully");
		cwp.closePopUp();
		logger.log(Status.PASS, "PopUp closed Succesfully");
		cwp.extractCarWash();
		logger.log(Status.PASS, "Succesfully extracted the required services");
		hp = cwp.goToHomePage();
		logger.log(Status.INFO, "Test passed Seccessfully");

	}

	/**
	 * This test will extract the error message from free listing page
	 */
	@Test(priority = 1, groups = { "Sanity", "Reggression" })
	public void checkErrorMessage() {

		logger = report.createTest("Extract Error Message from FreeListing Page");
		flp = hp.clickFreeListingButton();
		logger.log(Status.PASS, "Free Listing link clicked successfully");
		flp.enterDetails();
		logger.log(Status.PASS, "Form filled Successfully");
		flp.clickSubmitButton();
		logger.log(Status.PASS, "Submit button Successfully");
		flp.getErrorMessage();
		logger.log(Status.PASS, "Error Message extracted Successfully");
		hp = flp.navigateBackToHomePage();
		logger.log(Status.INFO, "Test passed Seccessfully");
	}

	/**
	 * This test will extract the sub menus in the Gym menu
	 */
	@Test(priority = 2, groups = { "Sanity", "Reggression" })
	public void extractGymSubMenus() {
		logger = report.createTest("Extract Gym Sub Menus");
		fp = hp.clickFitnessButton();
		logger.log(Status.PASS, "Fitness Button clicked Succesfully");
		gp = fp.clickGymButton();
		logger.log(Status.PASS, "Gym Button clicked successfully");
		gp.displaySubMenu();
		logger.log(Status.PASS, "Gym sub menus extracted successfully");
		logger.log(Status.INFO, "Test passed Seccessfully");

	}

	/**
	 * This test will execute after each of the test is executed
	 */
	@AfterSuite
	public void closeBrowser() {
		gp.closeBrowser();
		report.flush();
	}

}