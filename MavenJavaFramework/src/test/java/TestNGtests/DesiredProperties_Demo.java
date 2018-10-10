package TestNGtests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredProperties_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\iedriver\\IEDriverServerW32.exe");

		//DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("ignoreProtectedModeSetting", true);
		

		  // Set capability of IE driver to Ignore all zones browser protected mode settings.
		  //DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		  //caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		
		//DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		//caps.setCapability("ignoreZoomSetting", true);
		//driver = new InternetExplorerDriver(caps);

		  // Initialize InternetExplorerDriver Instance using new capability.
		 //@SuppressWarnings("deprecation")
		/////WebDriver driver = new InternetExplorerDriver();
		 // WebDriver driver2 = new InternetExplorer
		  //driver.
		
		WebDriver driver = new ChromeDriver();
		
		//WebElement html = driver.findElement(By.tagName("html"));
		//html.sendKeys(Keys.chord(Keys.CONTROL, "0"));

		  //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  
		// Press CTRL + 0 keys of keyboard to set IEDriver Instance zoom level to 100%.
		  //driver.findElement(By.tagName("html")).sendKeys(Keys.CONTROL, "0");
		
		//InternetExplorerOptions options = new InternetExplorerOptions();
		//options.setCapability("ignoreProtectedModeSetting", true);
				   //.requireWindowFocus();
		
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new InternetExplorerDriver(options);
		//InternetExplorerOptions driver2= new InternetExplorerOptions(caps);

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
		System.out.println("before click");

		inputBox.click();
		System.out.println("after click");

		
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
		
	}

}
