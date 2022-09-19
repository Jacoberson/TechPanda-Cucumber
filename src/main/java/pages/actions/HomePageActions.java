package pages.actions;

import pages.elements.HomePageElements;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;

public class HomePageActions {
	private Driver driver = LoggingDriver.getInstance();
	public HomePageElements homePage;

	public HomePageActions() {
		this.homePage = new HomePageElements(driver);
	}

	public void goToMobilePage() {
		homePage.mobileLink().click();
	}

}
