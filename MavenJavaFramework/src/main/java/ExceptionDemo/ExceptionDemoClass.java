package ExceptionDemo;

import java.io.IOException;

public class ExceptionDemoClass {

	public static void main(String[] args) {

		try {
			// use the argument of 0 to throw a divide by zero exception, otherwise and IO exception
			exceptionDemo(1);
		} catch (IOException e) {
			System.out.println("Got IOException msg: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Got Exception msg: " + e.getMessage());
			e.printStackTrace();
			System.out.println();
		} finally {
			System.out.println("Inside Finally Block.");
		}

	}

	public static void exceptionDemo(int div) throws Exception {
		System.out.println("Inside ExceptionDemoClass - about to trow exception");
		//int i = 1/0;
		int i = 1/div;
		throw new IOException("Thown as an example");
	}
}
