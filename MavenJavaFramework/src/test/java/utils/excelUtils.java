package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {

	public static String fuseDataFile ;
	public static XSSFSheet sheet ;
	XSSFWorkbook workbook ;

	//			String projectPath = System.getProperty("user.dir");
	//XSSFWorkbook workbook = new XSSFWorkbook(fuseDataFile);
	//XSSFSheet sheet = workbook.getSheet("Sheet1");

	// constructor
	public excelUtils(String excelFile, String Sheet) {
		System.out.println(getClass() + " Constructor called.");
		fuseDataFile = excelFile;
		try {
			workbook = new XSSFWorkbook(fuseDataFile);
			sheet = workbook.getSheet("Sheet1");;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
	}

	public static int getRowCount() {
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println("Row count = " + rowCount);

			//String sheetName = sheet.getSheetName();
			//System.out.println("Sheet Name is: " + sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;

	}	

	public static int getMaxColCount() {
		int colCount = 0;
		
		try {
			for( int i = 0 ; i < getRowCount() ; i++) {
				if( getColCount(i) > colCount ) {
					colCount = getColCount(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
		
	}
	
	public static int getColCount(int rowNum) {
		int colCount = 0;
		try {

			colCount = sheet.getRow(rowNum).getPhysicalNumberOfCells();
			//System.out.println("Column count = " + colCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static CellType getCellType(int rowNum, int colNum ) {
		return sheet.getRow(rowNum).getCell(colNum).getCellType();
	}
	
	public static String getCellDataString(int rowNum, int colNum) {
		String cellValue = null;

		try {
			if ( sheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.STRING)  {


				cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println("Cell String value at: " + rowNum + "," + colNum + " is: "+ cellValue);
			}
			else {
				cellValue = "NOT A STRING";
			}


		} catch (Exception e) {
			System.out.println("got exception inside getCellDataString");
			e.printStackTrace();
		}
		return cellValue;
	}
	public static double getCellDataNumber(int rowNum, int colNum) {
		double cellValue = 0;
		try {

			cellValue = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("Cell Number value at: " + rowNum + "," + colNum + " is: "+ cellValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}

}

