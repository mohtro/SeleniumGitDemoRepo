package TestNGtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadlessChromeDemo {
	public static String projectPath = null;
	public static WebDriver driver = null;

	public static void main(String[] args) {
		try {
			test("ie");
		} catch (Exception e) {
			System.out.println("IE got exception " + e);
			if( driver != null ) {
				driver.quit();
			} else {
				System.out.println("driver is null");
			}
		}
		test("chrome");
		test("Firefox");
	}
	public static void setup(String browserName) {
		System.out.println("Browser name is: " + browserName);
		System.out.println("Thread id is: " + Thread.currentThread().getId());
		projectPath = System.getProperty("user.dir");
		if( browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/lib/chromedriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1280x800");
			driver = new ChromeDriver(options);

		} else if( browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/lib/geckodriver/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1280x800");

			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		} else if( browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "/lib/iedriver/IEDriverServerW32.exe");
			//InternetExplorerOptions options = new InternetExplorerOptions();

			// look in triflejs.org

			driver = new InternetExplorerDriver();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		}

	}
	public static void test (String browser) {
		//setup("chrome");
		setup(browser);

		System.out.println("Browser is: " + browser);

		driver.get("https://google.com");
		/* if( browser.equalsIgnoreCase("ie")) {
			try {
				System.out.println("Sleeping for ie");
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("tjzoide");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());

		//driver.close();
		if (driver != null ) {
			driver.quit();
		}
		System.out.println("Test finished");
	}

}
