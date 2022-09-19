package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class TagNameFindStrategy extends FindStrategy {

	public TagNameFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.tagName(getValue());
	}

}
