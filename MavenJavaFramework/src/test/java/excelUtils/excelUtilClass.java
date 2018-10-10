package excelUtils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtilClass {
	public static void main(String[] args) {
		//getRowCount();
		getCellData();
	}
	public static void getRowCount() {
		try {
			String projectPath = System.getProperty("user.dir");
			String blueSkyFileName = projectPath +"/excel/BSAA-weight-balance-all-planes.xls";

			//File excelFile = new File(projectPath + "/excel/excelDatFile.xls");
			File excelFile = new File(blueSkyFileName);
			FileInputStream fis  = new FileInputStream(excelFile);

			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			//HSSFSheet sheet = workbook.getSheet("Sheet1");
			HSSFSheet sheet = workbook.getSheetAt(0);

			//XSSFWorkbook workbook = new XSSFWorkbook(blueSkyFileName);
			//XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowcount = sheet.getPhysicalNumberOfRows();
			String sheetName = sheet.getSheetName();
			System.out.println("Row count = " + rowcount);
			System.out.println("Sheet Name is: " + sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getCellData() {
		try {
			String projectPath = System.getProperty("user.dir");
			String blueSkyFileName = projectPath +"/excel/BSAA-weight-balance-all-planes.xls";
			
			String fuseDataFile = projectPath + "/excel/FUSELAGE BAG CONTENTS.xlsx";
			

			//File excelFile = new File(projectPath + "/excel/excelDatFile.xls");
			//File excelFile = new File(blueSkyFileName);
			//FileInputStream fis  = new FileInputStream(excelFile);

			//HSSFWorkbook workbook = new HSSFWorkbook(fis);
			//HSSFSheet sheet = workbook.getSheetAt(2);
			XSSFWorkbook workbook = new XSSFWorkbook(fuseDataFile);
			XSSFSheet sheet = workbook.getSheetAt(2);

			String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Cell value at: 0,0 " + cellValue);

			for ( int i = 0; i < 10; i++ ) {
				CellType cellType = sheet.getRow(i).getCell(1).getCellType();
				System.out.println("Cell type at: 0,0 " + cellType);
				if( cellType == CellType.STRING ) {
					System.out.println("cell is a string and Contains: " + sheet.getRow(i).getCell(1).getStringCellValue());
				} else if (cellType == CellType.NUMERIC) {
					System.out.println("cell is a number and Contains: " + sheet.getRow(i).getCell(1).getNumericCellValue());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
