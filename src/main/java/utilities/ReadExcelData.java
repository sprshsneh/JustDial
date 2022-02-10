package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class
 */
public class ReadExcelData {

	String path = null;
	FileInputStream fis = null;
	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;

	/**
	 * Initiating the constructor to read the excel file
	 */
	public ReadExcelData(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get no of rows from a sheet
	 */
	public int getRowCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		int rownum = sheet.getLastRowNum();
		return rownum + 1;
	}

	/**
	 * Method to get no of columns from a sheet
	 */
	public int getColoumnCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(0);
		int coloumnNum = row.getLastCellNum();
		return coloumnNum;
	}

	/**
	 * Method to get data from a specific cell
	 */
	public String getDataOfCell(String sheetName, int rowNum, int colNum) {
		sheet = wb.getSheet(sheetName);
		cell = sheet.getRow(rowNum).getCell(colNum);
		String data = cell.getStringCellValue();
		return data;
	}

	/**
	 * Method to get data from a specific row
	 */
	public String[] getDataFromRow(String sheetName, int rowNum) {
		int coloumnCount = getColoumnCount(sheetName);
		sheet = wb.getSheet(sheetName);
		String[] data = new String[coloumnCount];
		for (int i = 0; i < coloumnCount; i++) {
			CellType type = sheet.getRow(rowNum).getCell(i).getCellTypeEnum();
			if (type.equals("NUMERIC"))
				data[i] = String.valueOf(sheet.getRow(rowNum).getCell(i).getNumericCellValue());
			else
				data[i] = String.valueOf(sheet.getRow(rowNum).getCell(i));
		}
		return data;
	}

	/**
	 * Method to get data from specific column
	 */
	public String[] getDataFromColoumn(String sheetName, int colNum) {
		int rowCount = getRowCount(sheetName);
		sheet = wb.getSheet(sheetName);
		String[] data = new String[rowCount];
		for (int i = 0; i < rowCount; i++) {

			data[i] = String.valueOf(sheet.getRow(i).getCell(colNum));

		}
		return data;
	}

}
