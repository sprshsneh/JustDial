package utilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Utility class
 */
public class ReadPropertiesFile {
	Properties prop;
	String path = null;
	/**
	 * Initiating the constructor to read the properties file
	 */
	public ReadPropertiesFile(String path) {
		this.path = path;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to get the URL 
	 */
	public String getUrl() {
		return prop.getProperty("url");
	}
	/**
	 * Method to get the browser
	 */
	public String getBrowser() {
		return prop.getProperty("browser");
	}
}
