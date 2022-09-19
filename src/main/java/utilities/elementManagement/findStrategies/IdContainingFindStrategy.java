package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class IdContainingFindStrategy extends FindStrategy {

	public IdContainingFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.cssSelector(String.format("[id*='%s']", getValue()));
	}

}
