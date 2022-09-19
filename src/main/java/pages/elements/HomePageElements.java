package pages.elements;

import org.openqa.selenium.By;

import utilities.driverManagement.Driver;
import utilities.elementManagement.Element;

public class HomePageElements {
	private Driver driver;

	public HomePageElements(Driver driver) {
		this.driver = driver;
	}

	public Element mobileLink() {
		return driver.find(By.xpath("//a[contains(text(), 'Mobile')]"));
	}
}
