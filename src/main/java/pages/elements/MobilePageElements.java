package pages.elements;

import java.util.List;

import utilities.driverManagement.Driver;
import utilities.elementManagement.Element;

public class MobilePageElements {
	private Driver driver;

	public MobilePageElements(Driver driver) {
		this.driver = driver;
	}

	public Element mobilePageHeader() {
		return driver.findByTagName("h1");
	}

	public Element sortBy() {
		return driver.findByCssSelector("[title='Sort By']");
	}

	public List<Element> mobileProducts() {
		return driver.findAllByCssSelector(".product-name");
	}

	public Element mobileName(String deviceName) {
		return driver.findByUrlContaining(deviceName);
	}

	public Element detailsPagePrice() {
		return driver.findByIdContaining("product-price");

	}

}
