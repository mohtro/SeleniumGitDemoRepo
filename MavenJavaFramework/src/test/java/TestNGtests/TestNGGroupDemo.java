package TestNGtests;

import org.testng.annotations.Test;

@Test (groups = {"AllTests"})
public class TestNGGroupDemo {
	@Test (groups = {"sanity","regression"})
	public void test1() {
		System.out.println("inside test 1");
	}
	@Test (groups = {"sanity","regression"})
	public void test2() {
		System.out.println("inside test 2");
	}

	@Test (groups = {"sanity","regression"})
	public void test3() {
		System.out.println("inside test 3");
	}

	@Test (groups = {"sanity","regression"})
	public void test4() {
		System.out.println("inside test 4");
	}

	@Test (groups = {"regression"})
	public void test5() {
		System.out.println("inside test 5");
	}

	@Test (groups = {"regression"})
	public void test6() {
		System.out.println("inside test 6");
	}


}
