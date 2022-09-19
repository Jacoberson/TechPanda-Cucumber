package utilities.driverManagement.driverServices;

import java.util.List;

import org.openqa.selenium.By;

import utilities.elementManagement.Element;

public interface ElementFindService {
	public abstract Element find(By locator);
	public abstract List<Element> findAll(By locator);
}
