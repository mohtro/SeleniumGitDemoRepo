package TestNGtests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtenetReportsBasicDemo {
	static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReportDemo.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Google Search Test", "This is to learn seleneium and get a job.");

		System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");
		driver = new FirefoxDriver();

		System.out.println("before get url ");
		// log(Status, details)
		test.log(Status.INFO, "Before get tjzoide url");


		driver.get("https://www.tjzoide.com/");
		test.pass("Opened tjzoide.com");

		System.out.println("after get url");

		//WebElement inputBox = driver.findElement(By.id("hello"));
		//WebElement inputBox = driver.findElement(By.ByClassName.className("gLFyf gsfi"));
		//WebElement inputBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div/div[1]/div/div[1]/input"));
		//List<WebElement> inputBox = driver.findElements(By.xpath("//input"));

		//WebElement inputBox = driver.findElement(By.xpath("//input[@title='Search']"));
		WebElement inputBox = driver.findElement(By.xpath("//a[contains(text(),'Download')]"));
		test.pass("Got download page link");


		//a[contains(text(),'About')]
		//inputBox.sendKeys("tjzoide\n");

		inputBox.click();

		test.pass("Clicked on download link.");

		WebElement pdfFile = driver.findElement(By.xpath("//a[contains(text(),'TJZOIDE Users Manual D15.pdf')]"));

		test.pass("Got link to pdf file");

		List<WebElement> listofelements = driver.findElements(By.xpath("//a"));
		System.out.println("elements in list: " + listofelements.size());

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

		ExtentTest test2 = extent.createTest("Google Search Test", "This is to learn seleneium and get a job.");

		test2.fail("quiting driver, just for a fail log and a second  testcase report");

		driver.quit();


		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		//test.addScreenCaptureFromPath("screenshot.png");

		// calling flush writes everything to the log file
		extent.flush();
	}

}
