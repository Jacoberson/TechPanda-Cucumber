package pages.actions;

import java.util.List;

import org.testng.Assert;

import pages.elements.MobilePageElements;
import utilities.elementManagement.Element;

public class MobilePageActions extends BaseActions {
	private MobilePageElements elements;

	public MobilePageActions() {
		this.elements = new MobilePageElements(driver);
	}

	private String formatDeviceName(String device) {
		String formattedDeviceName = device.toLowerCase().replace(" ", "-");

		return formattedDeviceName;
	}

	public void verifyOnMobilePage(String header) {
		Assert.assertTrue(elements.mobilePageHeader().getText().equals(header));
	}

	public void verifyMobilePageTitle(String title) {
		Assert.assertTrue(driver.getTitle().equals(title));
	}

	public void sortBy(String sortBy) {
		elements.sortBy().selectByVisibleText(sortBy);
	}

	public void verifyItemOrder(String item1, String item2, String item3) {
		String[] items = {item1, item2, item3};
		List<Element> productNames = elements.mobileProducts();

		for (int i = 0; i < productNames.size(); i++) {
			String itemToCompare = items[i];
			Assert.assertTrue(
					productNames.get(i).getText().equals(itemToCompare));
		}
	}

	public void openDevicePage(String device) {
		elements.mobileName(formatDeviceName(device)).click();
	}

	public void comparePrice(String price) {
		Assert.assertEquals(elements.detailsPagePrice().getText(), price);
	}

	public void addDeviceToCart(String device) {
		elements.addToCartButton(formatDeviceName(device)).click();
	}

	public void compareDevices(String device1, String device2) {
		String formattedDeviceName1 = formatDeviceName(device1);
		String formattedDeviceName2 = formatDeviceName(device2);

		elements.addToCompareLink(formattedDeviceName1).click();
		elements.addToCompareLink(formattedDeviceName2).click();
		elements.compareButton().click();
	}

	public void verifyComparePopup(String header) {
		List<String> windows = driver.getAllWindows();

		for (var window : windows) {
			if (!driver.getCurrentWindow().equals(window)) {
				driver.switchWindow(window);
				break;
			}
		}

		Assert.assertTrue(
				elements.compareProductsHeader().getText().equals(header));
	}

	public void verifyComparedDevices(String device1, String device2) {
		String displayedDevice1 = elements.comparedDevice(device1).getText();
		String displayedDevice2 = elements.comparedDevice(device2).getText();

		Assert.assertEquals(device1.toUpperCase(), displayedDevice1);
		Assert.assertEquals(device2.toUpperCase(), displayedDevice2);
	}
}
