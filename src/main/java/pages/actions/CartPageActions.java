package pages.actions;

import org.testng.Assert;

import pages.elements.CartPageElements;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;
import utilities.fileReaders.ConfigFileReader;

public class CartPageActions {
	private ConfigFileReader config = new ConfigFileReader();
	private Driver driver = LoggingDriver.getInstance();
	public CartPageElements cartPage;

	public CartPageActions() {
		this.cartPage = new CartPageElements(driver);
	}

	public void changeQuantity(String quantity) {
		cartPage.quantityBox().typeText(quantity);
		cartPage.updateButton().click();
	}

	public void verifyQuantityErrorMessage() {
		String expectedError = config.properties.getProperty("quantityError");
		String actualError = cartPage.quantityError().getText();

		Assert.assertEquals(expectedError, actualError);
	}

	public void emptyCart() {
		cartPage.emptyCartButton().click();

	}

	public void verifyEmptyCart() {
		String expectedMessage = config.properties
				.getProperty("emptyCartMessage");
		String actualMessage = cartPage.emptyCartMessage().getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
}
