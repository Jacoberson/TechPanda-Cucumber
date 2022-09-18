package utilities.driverManagement;

import java.io.File;

import org.apache.logging.log4j.Logger;

import utilities.logSetup.ApplicationLogger;

public class LoggingDriver extends DriverDecorator {
	private static Logger logger = ApplicationLogger.getApplicationLogger();
	private static LoggingDriver instance = new LoggingDriver(
			new WebCoreDriver());

	private LoggingDriver(Driver driver) {
		super(driver);
	}

	public static LoggingDriver getInstance() {
		return instance;
	}

	@Override
	public void start(String browser) {
		logger.trace(String.format("Starting browser %s", browser));
		driver.start(browser);
	}

	@Override
	public void quit() {
		logger.trace("Quitting browser");
		driver.quit();
	}

	@Override
	public String getUrl() {
		logger.trace(String.format("url is %s", driver.getUrl()));
		return driver.getUrl();
	}

	@Override
	public String getTitle() {
		logger.trace(String.format("title is %s", driver.getTitle()));
		return driver.getTitle();
	}

	@Override
	public File captureScreenshot() {
		logger.trace("Capturing screenshot");
		return driver.captureScreenshot();
	}

	@Override
	public void openPage(String url) {
		logger.trace(String.format("Opening url %s", url));
		driver.openPage(url);
	}

}
