package Log4jDemoPackage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class Log4jDemoClass {

	//Logger logger = new LogManager().getLogger(Log4jDemoClass.class);
	public static Logger logger = LogManager.getLogger(Log4jDemoClass.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Starts...");
		
		System.out.println("CLASSPATH= " + System.getenv("CLASSPATH"));
		logger.trace("logger trace message");
		logger.info("logger information message");
		logger.error("logger error message");
		logger.warn("logger warning message");
		logger.fatal("logger fatal message");


		System.out.println("Test Ends!!!");
	}

}
