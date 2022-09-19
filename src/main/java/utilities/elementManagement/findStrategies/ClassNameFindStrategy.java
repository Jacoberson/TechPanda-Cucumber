package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class ClassNameFindStrategy extends FindStrategy {

	public ClassNameFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.className(getValue());
	}

}
