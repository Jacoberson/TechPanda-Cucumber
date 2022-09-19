package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class XpathFindStrategy extends FindStrategy {

	public XpathFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.xpath(getValue());
	}

}
