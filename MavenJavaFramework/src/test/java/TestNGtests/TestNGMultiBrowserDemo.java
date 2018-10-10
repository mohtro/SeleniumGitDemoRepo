package TestNGtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;
	String projectPath=null;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser name is: " + browserName);
		System.out.println("Thread id is: " + Thread.currentThread().getId());
		projectPath = System.getProperty("user.dir");
		if( browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/lib/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if( browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/lib/geckodriver/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		} else if( browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "/lib/iedriver/IEDriverServerW32.exe");
			driver = new InternetExplorerDriver();
		}
	}

	@Test
	public void test1() throws Exception {
		driver.get("https://google.com");
		Thread.sleep(1000);
	}

	@AfterTest
	public void teardown() throws Exception {

		//driver.close();
		Thread.sleep(1000);
		driver.quit();
		System.out.println("Test Completed succsessfully");

	}	
	
	@AfterSuite
	public void teardown2() throws Exception {

		//driver.close();
		Thread.sleep(1000);
		driver.quit();
		System.out.println("AFter Suite Called.");

	}
}
