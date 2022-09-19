package utilities.elementManagement;

import org.openqa.selenium.By;

public abstract class Element {
	public abstract By getBy();
	public abstract String getText();
	public abstract void click();
}
