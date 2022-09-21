package utilities.elementManagement;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import utilities.logSetup.ApplicationLogger;

public class LoggingElement extends ElementDecorator {
	private static Logger logger = ApplicationLogger.getApplicationLogger();

	public LoggingElement(Element element) {
		super(element);
	}

	@Override
	public By getBy() {
		logger.info(String.format("element's locator = %s", element.getBy()));
		return element.getBy();
	}

	@Override
	public String getText() {
		logger.info(String.format("element's text = %s", element.getText()));
		return element.getText();
	}

	@Override
	public void click() {
		logger.info("click on element");
		element.click();
	}

	@Override
	public void typeText(String text) {
		logger.info(String.format("typing '%s'", text));
		element.typeText(text);
	}

}
