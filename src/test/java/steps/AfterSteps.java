package steps;

import io.cucumber.java.After;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;

public class AfterSteps {
	private static Driver driver = LoggingDriver.getInstance();

	@After
	public void tearDown() {
		driver.quit();
	}
}
