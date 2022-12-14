package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.actions.HomePageActions;
import pages.actions.MobilePageActions;

public class MobilePageSteps extends BaseSteps {
	HomePageActions homePage = new HomePageActions();
	MobilePageActions mobilePage = new MobilePageActions();

	@Given("I am on the mobile page")
	public void i_am_on_the_mobile_page() {
		homePage.goToMobilePage();
	}

	@Given("the header displays {string}")
	public void the_header_displays(String header) {
		mobilePage.verifyOnMobilePage(header);
	}

	@Then("the title of the page is {string}")
	public void the_title_of_the_page_is(String title) {
		mobilePage.verifyMobilePageTitle(title);
	}

	@Given("I sort the items by {string}")
	public void i_sort_the_items_by(String sortBy) {
		mobilePage.sortBy(sortBy);
	}

	@Then("the item order is {string}, {string}, {string}")
	public void the_item_order_is(String firstItem, String middleItem,
			String lastItem) {
		mobilePage.verifyItemOrder(firstItem, middleItem, lastItem);
	}

	@Given("I open the details page for {string}")
	public void i_open_the_details_page_for(String device) {
		mobilePage.openDevicePage(device);
	}

	@Then("the {string} matches the price on the details page")
	public void the_matches_the_price_on_the_details_page(String price) {
		mobilePage.comparePrice(price);
	}

	@Given("I select to compare {string} and {string}")
	public void i_select_to_compare_and(String device1, String device2) {
		mobilePage.compareDevices(device1, device2);
	}

	@Then("a popup window displays that has a heading of {string}")
	public void a_popup_window_displays_that_has_a_heading_of(String header) {
		mobilePage.verifyComparePopup(header);
	}

	@Then("the popup window displays {string} and {string}")
	public void the_popup_window_displays_and(String device1, String device2) {
		mobilePage.verifyComparedDevices(device1, device2);
	}

}
