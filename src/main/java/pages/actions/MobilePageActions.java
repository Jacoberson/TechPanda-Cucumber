package pages.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import pages.elements.MobilePageElements;
import utilities.driverManagement.LoggingDriver;
import utilities.driverManagement.WebCoreDriver;

public class MobilePageActions {
	private LoggingDriver driver = LoggingDriver.getInstance();
	public MobilePageElements mobilePage = null;

	public MobilePageActions() {
		this.mobilePage = new MobilePageElements();
		PageFactory.initElements(WebCoreDriver.getWebDriver(), mobilePage);
	}

	public void verifyOnMobilePage(String header) {
		Assert.assertTrue(mobilePage.mobilePageHeader.getText().equals(header));
	}

	public void verifyMobilePageTitle(String title) {
		Assert.assertTrue(driver.getTitle().equals(title));
	}

	public void sortBy(String sortBy) {
		new Select(mobilePage.sortBy).selectByVisibleText(sortBy);
	}

	public void verifyFirstItem(String firstItem) {
		List<WebElement> productNames = mobilePage.mobileProducts;

		Assert.assertTrue(productNames.get(0).getText().equals(firstItem));
	}

	public void verifyMiddleItem(String middleItem) {
		List<WebElement> productNames = mobilePage.mobileProducts;

		Assert.assertTrue(productNames.get(1).getText().equals(middleItem));
	}

	public void verifyLastItem(String lastItem) {
		List<WebElement> productNames = mobilePage.mobileProducts;

		Assert.assertTrue(productNames.get(2).getText().equals(lastItem));
	}

	public void openDevicePage(String device) {
		switch (device) {
			case "SONY XPERIA" :
				mobilePage.sonyXperiaLink.click();
				break;
			case "IPHONE" :
				mobilePage.iPhoneLink.click();
				break;
			case "SAMSUNG GALAXY" :
				mobilePage.samsungGalaxyLink.click();
				break;
		}
	}

	public void comparePrice(String price) {
		if (price.contains("130.00")) {
			Assert.assertEquals(mobilePage.detailsPagePriceSpecial.getText(),
					price);
		} else {
			Assert.assertEquals(mobilePage.detailsPagePriceRegular.getText(),
					price);
		}

	}
}
