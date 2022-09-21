package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.actions.CartPageActions;
import pages.actions.HomePageActions;
import pages.actions.MobilePageActions;

public class CartPageSteps {
	HomePageActions homePage = new HomePageActions();
	MobilePageActions mobilePage = new MobilePageActions();
	CartPageActions cartPage = new CartPageActions();

	@Given("I have a {string} in my cart")
	public void i_have_a_in_my_cart(String device) {
		homePage.goToMobilePage();
		mobilePage.addDeviceToCart(device);
	}

	@Given("I change the quantity to {string}")
	public void i_change_the_quantity_to(String quantity) {
		cartPage.changeQuantity("1000");
	}

	@Then("I get an error message")
	public void i_get_an_error_message() {
		cartPage.verifyQuantityErrorMessage();
	}

	@Given("I click the empty cart button")
	public void i_click_the_empty_cart_button() {
		cartPage.emptyCart();
	}

	@Then("my shopping cart is empty")
	public void my_shopping_cart_is_empty() {
		cartPage.verifyEmptyCart();
	}

}
