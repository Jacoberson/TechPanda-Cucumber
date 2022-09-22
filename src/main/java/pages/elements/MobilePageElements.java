package pages.elements;

import java.util.List;

import org.openqa.selenium.support.ui.Select;

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

	public Select sortBy() {
		var element = driver.findByCssSelector("[title='Sort By']");

		return new Select(element.getWebElement());
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

	public Element addToCartButton(String deviceName) {
		String phoneActionsDiv = getActionsDivForDevice(deviceName);

		return driver.findByCssSelector(
				String.format("%s > button", phoneActionsDiv));
	}

	public Element addToCompareLink(String deviceName) {
		String phoneActionsDiv = getActionsDivForDevice(deviceName);

		return driver.findByCssSelector(String
				.format("%s > ul > li:nth-child(2) > a", phoneActionsDiv));
	}

	public Element compareButton() {
		return driver.findByCssSelector("[title='Compare']");
	}

	public Element compareProductsHeader() {
		return driver.findByCssSelector(".page-title > h1");
	}

	public Element comparedDevice(String deviceName) {
		return driver.findByCssSelector(
				String.format("h2 > a[title='%s']", deviceName));
	}

	private String getActionsDivForDevice(String deviceName) {
		return String.format("li > a[href*='%s'] + div > div[class='actions']",
				deviceName);
	}

}
