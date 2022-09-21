package utilities.elementManagement;

import org.openqa.selenium.By;

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

}
