package pages.actions;

import org.testng.Assert;

import pages.elements.CartPageElements;

public class CartPageActions extends BaseActions {
	public CartPageElements cartPage;

	public CartPageActions() {
		this.cartPage = new CartPageElements(driver);
	}

	public void changeQuantity(String quantity) {
		cartPage.quantityBox().typeText(quantity);
		cartPage.updateButton().click();
	}

	public void verifyQuantityErrorMessage(String expectedError) {
		String actualError = cartPage.quantityError().getText();

		Assert.assertEquals(expectedError, actualError);
	}

	public void emptyCart() {
		cartPage.emptyCartButton().click();

	}

	public void verifyEmptyCart(String expectedMessage) {
		String actualMessage = cartPage.emptyCartMessage().getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
}
