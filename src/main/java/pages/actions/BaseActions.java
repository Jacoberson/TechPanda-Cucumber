package pages.actions;

import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;

public abstract class BaseActions {
	protected Driver driver = LoggingDriver.getInstance();
}
