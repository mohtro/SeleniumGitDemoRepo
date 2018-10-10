package TestNGtests;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class SeleniumFluentWaitDemo {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		test();

	}
	public static void test () {
		System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");
		driver = new ChromeDriver();
		driver.get("https://google.com");

		driver.findElement(By.name("q")).sendKeys("tjzoide");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		//driver.findElement(By.linkText("Tjzoide.com: TJZOIDE | 4 axis hotwire foam cutting CAD/CAM software")).click();


		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		// so the partialLinkText is for a link in the second page.  manually advance the results
		// in google to the second page so the link is visible

		
		//**************
		// this loop done by me!,  to advance page if element not found in current page.
		boolean found = false;
		int i = 0;
		WebElement linkElement = null;
		while ( found == false && i < 3) {
			try {
				linkElement =  driver.findElement(By.partialLinkText("Tjzoide.com: TJZOIDE | 4 axis hotwire foam cutting CAD/CAM software"));
				found = true;
			} catch (Exception e2) {
				i++;
				System.out.println("Element not found in this page, mooving to next page... i= " + i);
				driver.findElement(By.id("pnnext")).click();
			}
		}
		//**************
		//driver.findElement(By.id("pnnext")).click();

		if (linkElement != null ) {
			linkElement.click();
		}

		/*
		 WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement =  driver.findElement(By.partialLinkText("Tjzoide.com: TJZOIDE | 4 axis hotwire foam cutting CAD/CAM software"));

				if (linkElement.isEnabled()) {
					System.out.println("Element Found");

				}
				return linkElement;
			}
		});
		 */

		//element.click();


		//<h3 class="LC20lb">Tjzoide.com: TJZOIDE | 4 axis hotwire foam cutting CAD/CAM software</h3>
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		System.out.println("Test Completed.");
	}
}
