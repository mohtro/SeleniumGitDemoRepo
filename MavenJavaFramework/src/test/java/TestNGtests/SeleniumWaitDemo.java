package TestNGtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		seleniumWaits();
	}

	public static void seleniumWaits() {
		System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// implicitlyWait pools every 250ms
		driver.get("https://google.com");

		// explicit wait below
		try {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		} catch (Exception e) {
			if( driver != null ) {
				System.out.println("Got Explicit exception: " + e);
				driver.quit();
			}
		}
		
		//implicit wait below
		try {
			driver.findElement(By.name("fredy")).clear();
		} catch (Exception e2) {
			if( driver != null ) {
				System.out.println("Got Implicit exception: " + e2);
				driver.quit();
			}
		}

	}
}
