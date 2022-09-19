package utilities.elementManagement.findStrategies;

import org.openqa.selenium.By;

public class TextContainingFindStrategy extends FindStrategy {

	public TextContainingFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.xpath(
				String.format("//*[contains(text(), '%s')]", getValue()));
	}

}
