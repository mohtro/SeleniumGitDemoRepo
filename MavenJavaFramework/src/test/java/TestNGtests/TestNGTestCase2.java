package TestNGtests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNGTestCase2 {

	static WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;

	@BeforeSuite
	public void setUpTest () {

		System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");
		driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();
		htmlReporter = new ExtentHtmlReporter("extentReportDemo.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test
	public static void testBrowser() {
		// TODO Auto-generated method stub

		ExtentTest test = extent.createTest("Google Search Test", "This is to learn seleneium and get a job.");

		System.out.println("before get url ");

		driver.get("https://www.tjzoide.com/");

		System.out.println("after get url");

		//WebElement inputBox = driver.findElement(By.id("hello"));
		//WebElement inputBox = driver.findElement(By.ByClassName.className("gLFyf gsfi"));
		//WebElement inputBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div/div[1]/div/div[1]/input"));
		//List<WebElement> inputBox = driver.findElements(By.xpath("//input"));

		//WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search']"));
		WebElement inputBox = driver.findElement(By.xpath("//a[contains(text(),'Download')]"));

		//a[contains(text(),'About')]
		//inputBox.sendKeys("tjzoide\n");

		inputBox.click();

		WebElement pdfFile = driver.findElement(By.xpath("//a[contains(text(),'TJZOIDE Users Manual D15.pdf')]"));

		List<WebElement> listofelements = driver.findElements(By.xpath("//a"));
		System.out.println("elements in list: " + listofelements.size());
		test.log(Status.INFO, "Before get tjzoide url");
		test.pass("Opened tjzoide.com");


		pdfFile.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Tittle page is: " + driver.getTitle());

		System.out.println("Current URL = " + driver.getCurrentUrl());
		System.out.println("before quit driver ");



		// google
		/*
			WebDriver cdriver = new ChromeDriver();
			cdriver.get("https://www.google.com/");

			WebElement cinputBox = cdriver.findElement(By.xpath("//input[@title='Search']"));

			cinputBox.sendKeys("tjzoide");
			cinputBox.sendKeys(Keys.RETURN);
			WebElement searchBtn = cdriver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']//*[@focusable='false']"));

			cinputBox = cdriver.findElement(By.xpath("//input[@title='Search']"));

			cinputBox.clear();
			cinputBox.sendKeys("airplane");

			searchBtn = cdriver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']//*[@focusable='false']"));
			searchBtn.click();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			cdriver.quit();

			System.out.println("Test Finished!!!");
		 */
	}

	@Test
	public static void testBrowser2() throws Exception {
		// TODO Auto-generated method stub

		ExtentTest test = extent.createTest("Google Search Test Browser2", "This is to learn seleneium and get a job.");

		System.out.println("before get url ");

		driver.get("https://www.tjzoide.com/");

		System.out.println("after get url");

		//WebElement inputBox = driver.findElement(By.id("hello"));
		//WebElement inputBox = driver.findElement(By.ByClassName.className("gLFyf gsfi"));
		//WebElement inputBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div/div[1]/div/div[1]/input"));
		//List<WebElement> inputBox = driver.findElements(By.xpath("//input"));

		//WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search']"));
		WebElement inputBox = driver.findElement(By.xpath("//a[contains(text(),'Download')]"));

		//a[contains(text(),'About')]
		//inputBox.sendKeys("tjzoide\n");

		inputBox.click();

		WebElement pdfFile = driver.findElement(By.xpath("//a[contains(text(),'TJZOIDE Users Manual D15.pdf')]"));

		List<WebElement> listofelements = driver.findElements(By.xpath("//a"));
		System.out.println("elements in list: " + listofelements.size());
		test.log(Status.INFO, "Before get tjzoide url");
		test.pass("Opened tjzoide.com");


		pdfFile.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Tittle page is: " + driver.getTitle());

		System.out.println("Current URL = " + driver.getCurrentUrl());
		System.out.println("before quit driver ");
		
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(driver.getCurrentUrl()).build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");




		// google
		/*
			WebDriver cdriver = new ChromeDriver();
			cdriver.get("https://www.google.com/");

			WebElement cinputBox = cdriver.findElement(By.xpath("//input[@title='Search']"));

			cinputBox.sendKeys("tjzoide");
			cinputBox.sendKeys(Keys.RETURN);
			WebElement searchBtn = cdriver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']//*[@focusable='false']"));

			cinputBox = cdriver.findElement(By.xpath("//input[@title='Search']"));

			cinputBox.clear();
			cinputBox.sendKeys("airplane");

			searchBtn = cdriver.findElement(By.xpath("//span[@class='z1asCe MZy1Rb']//*[@focusable='false']"));
			searchBtn.click();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			cdriver.quit();

			System.out.println("Test Finished!!!");
		 */
	}
	
	@AfterSuite
	public void afterTest () {
		driver.quit();
		extent.flush();

	}

}
