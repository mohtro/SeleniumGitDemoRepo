package excelDemo;

import utils.excelUtils;

public class excelDemoTestNG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		String fuseDataFile = projectPath + "/excel/FUSELAGE BAG CONTENTS.xlsx";

		excelUtils excel = new excelUtils(fuseDataFile, "Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
	}

}
