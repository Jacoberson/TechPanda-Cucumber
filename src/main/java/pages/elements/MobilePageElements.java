package pages.elements;

import java.util.List;

import org.openqa.selenium.By;

import utilities.driverManagement.Driver;
import utilities.elementManagement.Element;

public class MobilePageElements {
	private Driver driver;

	public MobilePageElements(Driver driver) {
		this.driver = driver;
	}

	public Element mobilePageHeader() {
		return driver.find(By.tagName("h1"));
	}

	public Element sortBy() {
		return driver.find(By.cssSelector("[title='Sort By']"));
	}

	public List<Element> mobileProducts() {
		return driver.findAll(By.cssSelector(".product-name"));
	}

	public Element mobileName(String deviceName) {
		return driver.find(By
				.cssSelector(String.format("h2 > a[href*='%s']", deviceName)));
	}

	public Element detailsPagePriceRegular() {
		return driver.find(By.className("price"));
	}

	public Element detailsPagePriceSpecial() {
		return driver.find(By.id("product-price-3"));
	}

}
