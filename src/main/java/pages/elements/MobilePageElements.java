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
}
