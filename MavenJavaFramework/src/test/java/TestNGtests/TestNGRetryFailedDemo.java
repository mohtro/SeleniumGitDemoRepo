package TestNGtests;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * https://testng.org/doc/documentation-main.html#rerunning
 * 
 * line below runs the first time (regression)
 * java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs testng.xml
 * 
 * line below runs failed tests from previous run
 * java -classpath testng.jar;%CLASSPATH% org.testng.TestNG -d test-outputs test-outputs\testng-failed.xml
 */

public class TestNGRetryFailedDemo {

	@Test
	public void test1() {
		System.out.println("Inside test 1");
	}
	@Test(retryAnalyzer = listeners.TestNGRetryAnalyzer.class)
	public void test2() {
		System.out.println("Inside test 2");
		int i = 1/0;
	}
	@Test
	public void test3() {
		System.out.println("Inside test 3");
		Assert.assertTrue(false);  // import this one from testng.org
	}
	@Test
	public void test4() {
		System.out.println("Inside test 4");
	}
}
