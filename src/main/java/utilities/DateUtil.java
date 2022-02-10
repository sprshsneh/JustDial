package utilities;

import java.util.Date;
/**
 * Utility class
 */
public class DateUtil {
	/**
	 * Method to get the time as string to use it as name for report
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replace(":", "_").replace(" ", "_");
	}

}
