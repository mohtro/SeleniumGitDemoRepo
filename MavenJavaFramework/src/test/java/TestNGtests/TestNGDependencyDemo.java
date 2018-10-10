package TestNGtests;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	@Test(dependsOnMethods= {"test2"},priority=1)
	//@Test
	public void test1() {
		System.out.println("Inside test1");
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("Inside test2");
	}
}
