package utilities.driverManagement;

import java.io.File;

public class DriverDecorator extends Driver {
	protected final Driver driver;

	public DriverDecorator(Driver driver) {
		this.driver = driver;
	}

	@Override
	public void start(String browser) {
		driver.start(browser);
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public String getUrl() {
		return driver.getUrl();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public File captureScreenshot() {
		return driver.captureScreenshot();
	}

	@Override
	public void openPage(String url) {
		driver.openPage(url);
	}

}
