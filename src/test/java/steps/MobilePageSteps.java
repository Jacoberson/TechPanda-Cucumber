package steps;

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

	@Then("the middle item is {string}")
	public void the_middle_item_is(String middleItem) {
		mobilePage.verifyMiddleItem(middleItem);
	}

	@Then("the last item is {string}")
	public void the_last_item_is(String lastItem) {
		mobilePage.verifyLastItem(lastItem);
	}

}
