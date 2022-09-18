package utilities.logSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLogger {
	private static Logger logger = LogManager.getLogger();

	public static Logger getApplicationLogger() {
		return logger;
	}
}
