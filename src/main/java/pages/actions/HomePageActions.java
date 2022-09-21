package pages.actions;

import pages.elements.HomePageElements;

public class HomePageActions extends BaseActions {
	public HomePageElements homePage;

	public HomePageActions() {
		this.homePage = new HomePageElements(driver);
	}

	public void goToMobilePage() {
		homePage.mobileLink().click();
	}

}
