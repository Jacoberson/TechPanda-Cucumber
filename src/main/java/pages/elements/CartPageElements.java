package pages.elements;

import utilities.driverManagement.Driver;
import utilities.elementManagement.Element;

public class CartPageElements {
	private Driver driver;

	public CartPageElements(Driver driver) {
		this.driver = driver;
	}

	public Element quantityBox() {
		return driver.findByCssSelector("[title='Qty']");
	}

	public Element updateButton() {
		return driver.findByCssSelector("[title='Update']");
	}

	public Element quantityError() {
		return driver.findByCssSelector(".item-msg.error");
	}

	public Element emptyCartButton() {
		return driver.findById("empty_cart_button");
	}

	public Element emptyCartMessage() {
		return driver.findByClassName("cart-empty");
	}
}
