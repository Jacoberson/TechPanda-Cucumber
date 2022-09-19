package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class IdFindStrategy extends FindStrategy {

	public IdFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.id(getValue());
	}

}
