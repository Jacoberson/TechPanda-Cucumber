package pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageElements {
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Mobile')]")
	public WebElement mobileLink;
}
