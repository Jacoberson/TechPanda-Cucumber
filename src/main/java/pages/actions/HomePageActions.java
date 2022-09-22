package pages.actions;

import pages.elements.HomePageElements;

public class HomePageActions extends BaseActions {
	private HomePageElements elements;

	public HomePageActions() {
		this.elements = new HomePageElements(driver);
	}

	public void goToMobilePage() {
		elements.mobileLink().click();
	}

}
