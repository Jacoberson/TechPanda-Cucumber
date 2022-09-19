package pages.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MobilePageElements {
	@FindBy(how = How.TAG_NAME, using = "h1")
	public WebElement mobilePageHeader;

	@FindBy(how = How.CSS, using = "[title='Sort By']")
	public WebElement sortBy;

	@FindBy(how = How.CSS, using = ".product-name")
	public List<WebElement> mobileProducts;

	@FindBy(how = How.CSS, using = "h2 > a[href*='sony-xperia']")
	public WebElement sonyXperiaLink;

	@FindBy(how = How.CSS, using = "h2 > a[href*='iphone']")
	public WebElement iPhoneLink;

	@FindBy(how = How.CSS, using = "h2 > a[href*='samsung-galaxy']")
	public WebElement samsungGalaxyLink;

	@FindBy(how = How.CLASS_NAME, using = "price")
	public WebElement detailsPagePriceRegular;

	@FindBy(how = How.ID, using = "product-price-3")
	public WebElement detailsPagePriceSpecial;

}
