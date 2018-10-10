package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {

	@Test
	public void test21 () {
		System.out.println("I am inside test 21");
	}
	
	@Test
	public void atest22 () {
		System.out.println("I am inside test 22");
	}
	
	@Test
	public void test23 () {
		System.out.println("I am inside test 23");
		throw new SkipException("Forced skip of test3 by throwing exception");
	}
}
