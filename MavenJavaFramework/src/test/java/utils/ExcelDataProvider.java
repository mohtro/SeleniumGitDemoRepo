package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	/*
	 * public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		String fuseDataFile = projectPath + "/excel/FUSELAGE BAG CONTENTS.xlsx";

		Object localData[][] = testData(fuseDataFile,"Sheet1");
		System.out.println("Object data at 0,0 is: " + localData[0][0]);
		System.out.println("localData Object rows is: " + localData.length);
		System.out.println("localData Object Columns is: " + localData[0].length);
	}
	 */
	WebDriver driver = null;

	// Annotation for testNG 
	@DataProvider(name = "excelTestData")
	public Object getData() {
		String projectPath = System.getProperty("user.dir");
		String fuseDataFile = projectPath + "/excel/FUSELAGE BAG CONTENTS.xlsx";

		Object localData[][] = testData(fuseDataFile,"Sheet1");
		return localData;
	}

	// Annotation for TestNG to use the same data Provider 
	@Test(dataProvider = "excelTestData")
	public void test1 (String bag, String qty, String desc, String subKit) throws Exception {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		
		System.out.println("qty= " + qty + " bag= " + bag + " desc= " + desc + " subKit= " + subKit);
		//driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		//driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(desc);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("password");
		
		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtUsername")).sendKeys("username by name");
		Thread.sleep(2000);

		//driver.quit();
	}
	
	//@OnStart

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("hello");
		//driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("password");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	public static Object[][] testData(String excelFile, String sheetName) {
		excelUtils excel = new excelUtils(excelFile, sheetName);
		int rowCount = excel.getRowCount();

		System.out.println("RowCount is: " + rowCount + " MaxColCount is: " + excel.getMaxColCount());
		//Object data[][] = new Object[rowCount][excel.getMaxColCount()];
		Object data[][] = new Object[3][excel.getMaxColCount()];

		//for (int i=0 ; i< rowCount ; i++) {
		for (int i=0 ; i< 3 ; i++) {
			int colCount = excel.getColCount(i);

			for (int j = 0 ; j< colCount ; j++ ) {
				CellType cellType = excel.getCellType(i, j);

				if( cellType == CellType.STRING) {
					String cellData = excel.getCellDataString(i, j);
					data[i][j] = cellData;
					System.out.print(cellData);
				} else if (cellType == CellType.NUMERIC ) {
					double cellDataNumber = excel.getCellDataNumber(i, j);
					data[i][j] = Double.toString(cellDataNumber);
					System.out.print(cellDataNumber);
				}

				if ( j < colCount - 1 ) {
					System.out.print(" , ");
				}
			}
			System.out.println();
		}
		return data;
	}
}
