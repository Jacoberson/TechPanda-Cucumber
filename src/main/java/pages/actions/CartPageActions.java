package pages.actions;

import org.testng.Assert;

import pages.elements.CartPageElements;

public class CartPageActions extends BaseActions {
	private CartPageElements elements;

	public CartPageActions() {
		this.elements = new CartPageElements(driver);
	}

	public void changeQuantity(String quantity) {
		elements.quantityBox().typeText(quantity);
		elements.updateButton().click();
	}

	public void verifyQuantityErrorMessage(String expectedError) {
		String actualError = elements.quantityError().getText();

		Assert.assertEquals(expectedError, actualError);
	}

	public void emptyCart() {
		elements.emptyCartButton().click();
	}

	public void verifyEmptyCart(String expectedMessage) {
		String actualMessage = elements.emptyCartMessage().getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
}
