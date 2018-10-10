

// The type List is not generic; it cannot be parameterized with arguments
// this error happens because of awt instead of util in the inport.

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new InternetExplorerDriver();

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

		driver.quit();
		
		// google
		
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
	}

}
