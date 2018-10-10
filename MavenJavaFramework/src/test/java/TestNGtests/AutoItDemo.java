package TestNGtests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AutoItDemo {

	public static String projectPath = null;
	public static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setup("chrome", false);

		driver.get("http://tinyupload.com");
		driver.findElement(By.name("uploaded_file")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Runtime.getRuntime().exec("C:\\FREDY\\SELENIUM\\AutoITFiles\\tinyUploadTest.exe " + "C:\\FREDY\\SELENIUM\\ScratchPad\\testFileCMDLINE.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}


	public static void setup(String browserName, Boolean headless) {
		System.out.println("Browser name is: " + browserName);
		System.out.println("Thread id is: " + Thread.currentThread().getId());
		projectPath = System.getProperty("user.dir");
		if( browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/lib/chromedriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if( headless ) {
				options.addArguments("--headless");
				options.addArguments("window-size=1280x800");
			}
			driver = new ChromeDriver(options);

		} else if( browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/lib/geckodriver/geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\FREDY\\SELENIUM\\EclipseWorkspace\\MavenJavaFramework\\lib\\geckodriver\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions();
			if( headless ) {
				options.addArguments("--headless");
				options.addArguments("window-size=1280x800");
			}

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
}
