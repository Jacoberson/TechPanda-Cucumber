package pages.actions;

import java.util.List;

import org.testng.Assert;

import pages.elements.MobilePageElements;
import utilities.elementManagement.Element;

public class MobilePageActions extends BaseActions {
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
		mobilePage.sortBy().selectByVisibleText(sortBy);
	}

	public void verifyItemOrder(String item1, String item2, String item3) {
		String[] items = {item1, item2, item3};
		List<Element> productNames = mobilePage.mobileProducts();

		for (int i = 0; i < productNames.size(); i++) {
			String itemToCompare = items[i];
			Assert.assertTrue(
					productNames.get(i).getText().equals(itemToCompare));
		}
	}

	public void openDevicePage(String device) {
		mobilePage.mobileName(formatDeviceName(device)).click();
	}

	public void comparePrice(String price) {
		Assert.assertEquals(mobilePage.detailsPagePrice().getText(), price);
	}

	public void addDeviceToCart(String device) {
		mobilePage.addToCartButton(formatDeviceName(device)).click();
	}

	private String formatDeviceName(String device) {
		String formattedDeviceName = device.toLowerCase().replace(" ", "-");

		return formattedDeviceName;
	}
}
