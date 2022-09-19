package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class UrlContainingFindStrategy extends FindStrategy {

	public UrlContainingFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.cssSelector(String.format("[href*='%s']", getValue()));
	}

}
