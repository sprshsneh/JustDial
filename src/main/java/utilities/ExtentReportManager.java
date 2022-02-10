package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
 * Utility class
 */
public class ExtentReportManager {

	public static ExtentReports report;
	/**
	 * Instantiation of Extent Report
	 */
	public static ExtentReports getReport() {
		if (report == null) {
			String reportName = DateUtil.getTimeStamp();
			ExtentSparkReporter reporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "\\ExtentReports\\" + reportName + ".html");
			report = new ExtentReports();
			report.attachReporter(reporter);

			report.setSystemInfo("Environment", "Windows 10");

			reporter.config().setReportName("Test Report");
		}
		return report;
	}

}
