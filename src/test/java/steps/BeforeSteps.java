package steps;

import io.cucumber.java.Before;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;
import utilities.fileReaders.ConfigFileReader;

public class BeforeSteps {
	private static Driver driver = LoggingDriver.getInstance();
	protected ConfigFileReader config = new ConfigFileReader();

	@Before
	public void setUp() {
		driver.start(config.properties.getProperty("browser"));
		driver.openPage(config.properties.getProperty("homePageUrl"));
	}
}
