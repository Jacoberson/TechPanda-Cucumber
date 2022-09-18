package utilities.driverManagement;

import utilities.driverManagement.driverServices.BrowserService;
import utilities.driverManagement.driverServices.DriverService;
import utilities.driverManagement.driverServices.NavigationService;

public abstract class Driver
		implements
			BrowserService,
			DriverService,
			NavigationService {

}
