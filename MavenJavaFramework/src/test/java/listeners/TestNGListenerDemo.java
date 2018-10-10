package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	@Test
	public void test1 () {
		System.out.println("I am inside test 1");
	}
	
	@Test
	public void test2 () {
		System.out.println("I am inside test 2");
	}
	
	@Test
	public void test3 () {
		System.out.println("I am inside test 3");
		throw new SkipException("Forced skip of test3 by throwing exception");
	}
}
