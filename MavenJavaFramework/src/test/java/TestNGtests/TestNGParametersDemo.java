package TestNGtests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
	
	//@BeforeSuite
	@Parameters({"ConstructorParam"})
	public TestNGParametersDemo (@Optional("default_param") String param) {
		System.out.println("This is the constructor with parameter: " + param);
	}
	
	@Test
	//@Parameters({"Myname","abc"})
	@Parameters({"MyName"})
	public void test(@Optional("default_value") String name) {
		System.out.println("Name is: " + name);
		//TestNGParametersDemo demo = new TestNGtests.TestNGParametersDemo();
	}

}
