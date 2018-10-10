package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFileDemo {
	static Properties prop = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setPrperties();

	}

	public static void getProperties() {
		try {
			prop = new Properties();

			String projectPath = System.getProperty("user.dir");
			InputStream input =new FileInputStream(projectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("Bowser is: " + browser);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	public static void setPrperties() {
		try {
			//prop = new Properties();

			String projectPath = System.getProperty("user.dir");
			OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
			//InputStream input =new FileInputStream(projectPath + "/src/test/java/config/config.properties");
			//prop.load(input);
			//prop.getProperty("browser");
			
			prop.setProperty("otherProp", "a_second_value3");
			//prop.setProperty("otherProp", null);
			
			prop.store(output, null);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
