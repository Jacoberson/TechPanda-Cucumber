package utilities.elementManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Element {
	public abstract By getBy();
	public abstract WebElement getWebElement();
	public abstract String getText();
	public abstract void click();
	public abstract void typeText(String text);
}
