package steps;

import io.cucumber.java.Before;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;

public class BeforeSteps extends BaseSteps {
	private static Driver driver = LoggingDriver.getInstance();

	@Before
	public void setUp() {
		driver.start(config.properties.getProperty("browser"));
		driver.openPage(config.properties.getProperty("homePageUrl"));
	}
}
