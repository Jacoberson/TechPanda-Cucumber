package pages.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.elements.MobilePageElements;
import utilities.driverManagement.Driver;
import utilities.driverManagement.LoggingDriver;
import utilities.elementManagement.Element;

public class MobilePageActions {
	private Driver driver = LoggingDriver.getInstance();
	public MobilePageElements mobilePage;

	public MobilePageActions() {
		this.mobilePage = new MobilePageElements(driver);
	}

	public void verifyOnMobilePage(String header) {
		Assert.assertTrue(
				mobilePage.mobilePageHeader().getText().equals(header));
	}

	public void verifyMobilePageTitle(String title) {
		Assert.assertTrue(driver.getTitle().equals(title));
	}

	public void sortBy(String sortBy) {
		new Select((WebElement) mobilePage.sortBy())
				.selectByVisibleText(sortBy);
	}

	public void verifyFirstItem(String firstItem) {
		List<Element> productNames = mobilePage.mobileProducts();

		Assert.assertTrue(productNames.get(0).getText().equals(firstItem));
	}

	public void verifyMiddleItem(String middleItem) {
		List<Element> productNames = mobilePage.mobileProducts();

		Assert.assertTrue(productNames.get(1).getText().equals(middleItem));
	}

	public void verifyLastItem(String lastItem) {
		List<Element> productNames = mobilePage.mobileProducts();

		Assert.assertTrue(productNames.get(2).getText().equals(lastItem));
	}

	public void openDevicePage(String device) {
		mobilePage.mobileName(formatDeviceName(device)).click();
	}

	private String formatDeviceName(String device) {
		String formattedDeviceName = device.toLowerCase().replace(" ", "-");

		return formattedDeviceName;
	}

	public void comparePrice(String price) {
		if (price.contains("130.00")) {
			Assert.assertEquals(mobilePage.detailsPagePriceSpecial().getText(),
					price);
		} else {
			Assert.assertEquals(mobilePage.detailsPagePriceRegular().getText(),
					price);
		}

	}
}
