package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class CssSelectorFindStrategy extends FindStrategy {

	public CssSelectorFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.cssSelector(getValue());
	}

}
