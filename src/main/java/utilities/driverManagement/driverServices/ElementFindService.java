package utilities.driverManagement.driverServices;

import java.util.List;

import utilities.elementManagement.Element;
import utilities.elementManagement.findStrategies.FindStrategy;

public interface ElementFindService {
	public abstract Element findById(String id);
	public abstract Element findByClassName(String className);
	public abstract Element findByTagName(String tagName);
	public abstract Element findByCssSelector(String cssSelector);
	public abstract Element findByXpath(String xpath);
	public abstract Element findByText(String text);
	public abstract Element findByIdContaining(String containing);
	public abstract Element findByUrlContaining(String containing);
	public abstract List<Element> findAllById(String id);
	public abstract List<Element> findAllByClassName(String className);
	public abstract List<Element> findAllByTagName(String tagName);
	public abstract List<Element> findAllByCssSelector(String cssSelector);
	public abstract List<Element> findAllByXpath(String xpath);
	public abstract List<Element> findAllByText(String text);
	public abstract List<Element> findAllByIdContaining(String containing);
	public abstract List<Element> findAllByUrlContaining(String containing);

	public abstract Element find(FindStrategy findStrategy);
	public abstract List<Element> findAll(FindStrategy findStrategy);
}
