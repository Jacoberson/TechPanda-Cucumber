package utilities.driverManagement;

import java.io.File;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import utilities.elementManagement.Element;
import utilities.elementManagement.findStrategies.FindStrategy;

public class DriverDecorator extends Driver {
	protected final Driver driver;

	public DriverDecorator(Driver driver) {
		this.driver = driver;
	}

	@Override
	public void start(String browser) {
		driver.start(browser);
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public String getUrl() {
		return driver.getUrl();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public File captureScreenshot() {
		return driver.captureScreenshot();
	}

	@Override
	public void openPage(String url) {
		driver.openPage(url);
	}

	@Override
	public Element find(FindStrategy findStrategy) {
		return driver.find(findStrategy);
	}

	@Override
	public List<Element> findAll(FindStrategy findStrategy) {
		return driver.findAll(findStrategy);
	}

	@Override
	public Element findById(String id) {
		return driver.findById(id);
	}

	@Override
	public Element findByClassName(String className) {
		return driver.findByClassName(className);
	}

	@Override
	public Element findByTagName(String tagName) {
		return driver.findByTagName(tagName);
	}

	@Override
	public Element findByCssSelector(String cssSelector) {
		return driver.findByCssSelector(cssSelector);
	}

	@Override
	public Element findByXpath(String xpath) {
		return driver.findByXpath(xpath);
	}

	@Override
	public Element findByText(String text) {
		return driver.findByText(text);
	}

	@Override
	public Element findByIdContaining(String id) {
		return driver.findByIdContaining(id);
	}

	@Override
	public Element findByUrlContaining(String containing) {
		return driver.findByUrlContaining(containing);
	}

	@Override
	public List<Element> findAllById(String id) {
		return driver.findAllById(id);
	}

	@Override
	public List<Element> findAllByClassName(String className) {
		return driver.findAllByClassName(className);
	}

	@Override
	public List<Element> findAllByTagName(String tagName) {
		return driver.findAllByTagName(tagName);
	}

	@Override
	public List<Element> findAllByCssSelector(String cssSelector) {
		return driver.findAllByCssSelector(cssSelector);
	}

	@Override
	public List<Element> findAllByXpath(String xpath) {
		return driver.findAllByXpath(xpath);
	}

	@Override
	public List<Element> findAllByText(String text) {
		return driver.findAllByText(text);
	}

	@Override
	public List<Element> findAllByIdContaining(String id) {
		return driver.findAllByIdContaining(id);
	}

	@Override
	public List<Element> findAllByUrlContaining(String containing) {
		return driver.findAllByUrlContaining(containing);
	}

	@Override
	public Select findSelectByCss(String css) {
		return driver.findSelectByCss(css);
	}

}
