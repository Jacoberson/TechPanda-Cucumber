package utilities.elementManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementDecorator extends Element {
	protected final Element element;

	protected ElementDecorator(Element element) {
		this.element = element;
	}

	@Override
	public By getBy() {
		return element.getBy();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public void click() {
		element.click();
	}

	@Override
	public WebElement getWebElement() {
		return element.getWebElement();
	}

	@Override
	public void typeText(String text) {
		element.typeText(text);
	}

}
