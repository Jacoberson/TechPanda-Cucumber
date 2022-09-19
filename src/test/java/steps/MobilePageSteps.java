package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.actions.HomePageActions;
import pages.actions.MobilePageActions;

public class MobilePageSteps {
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

	@Then("the first item is {string}")
	public void the_first_item_is(String firstItem) {
		mobilePage.verifyFirstItem(firstItem);
	}

	@And("the middle item is {string}")
	public void the_middle_item_is(String middleItem) {
		mobilePage.verifyMiddleItem(middleItem);
	}

	@And("the last item is {string}")
	public void the_last_item_is(String lastItem) {
		mobilePage.verifyLastItem(lastItem);
	}

	@Given("I open the details page for {string}")
	public void i_open_the_details_page_for(String device) {
		mobilePage.openDevicePage(device);
	}

	@Then("the {string} matches the price on the details page")
	public void the_matches_the_price_on_the_details_page(String price) {
		mobilePage.comparePrice(price);
	}

}
