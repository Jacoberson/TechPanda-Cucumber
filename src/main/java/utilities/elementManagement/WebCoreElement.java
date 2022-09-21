package utilities.elementManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebCoreElement extends Element {
	private final WebElement webElement;
	private final By by;

	public WebCoreElement(WebElement webElement, By by) {
		this.webElement = webElement;
		this.by = by;
	}

	@Override
	public By getBy() {
		return by;
	}

	@Override
	public String getText() {
		return webElement.getText();
	}

	@Override
	public void click() {
		webElement.click();
	}

	@Override
	public WebElement getWebElement() {
		return webElement;
	}

	@Override
	public void typeText(String text) {
		webElement.clear();
		webElement.sendKeys(text);
	}

}
