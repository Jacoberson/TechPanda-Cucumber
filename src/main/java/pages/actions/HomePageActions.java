package pages.actions;

import org.openqa.selenium.support.PageFactory;

import pages.elements.HomePageElements;
import utilities.driverManagement.WebCoreDriver;

public class HomePageActions {
	public HomePageElements homePage = null;

	public HomePageActions() {
		this.homePage = new HomePageElements();
		PageFactory.initElements(WebCoreDriver.getWebDriver(), homePage);
	}

	public void goToMobilePage() {
		homePage.mobileLink.click();
	}

}
