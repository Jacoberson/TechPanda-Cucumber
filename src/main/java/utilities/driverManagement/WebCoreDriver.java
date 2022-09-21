package utilities.driverManagement;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.logging.log4j.core.util.NullOutputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.elementManagement.Element;
import utilities.elementManagement.LoggingElement;
import utilities.elementManagement.WebCoreElement;
import utilities.elementManagement.findStrategies.ClassNameFindStrategy;
import utilities.elementManagement.findStrategies.CssSelectorFindStrategy;
import utilities.elementManagement.findStrategies.FindStrategy;
import utilities.elementManagement.findStrategies.IdContainingFindStrategy;
import utilities.elementManagement.findStrategies.IdFindStrategy;
import utilities.elementManagement.findStrategies.TagNameFindStrategy;
import utilities.elementManagement.findStrategies.TextContainingFindStrategy;
import utilities.elementManagement.findStrategies.UrlContainingFindStrategy;
import utilities.elementManagement.findStrategies.XpathFindStrategy;

public class WebCoreDriver extends Driver {
	private static WebDriver webDriver;
	private static WebCoreDriver instance = new WebCoreDriver();
	private static WebDriverWait wait;

	private WebCoreDriver() {
	}

	public static WebCoreDriver getInstance() {
		return instance;
	}

	@Override
	public void start(String browser) {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

		webDriver = switch (browser) {
			case "Firefox" -> {
				System.setProperty("webdriver.gecko.driver",
						"src/main/resources/browsers/geckodriver.exe");

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				disableFirefoxLogs();

				yield new FirefoxDriver(options);
			}
			case "Edge" -> {
				System.setProperty("webdriver.edge.driver",
						"src/main/resources/browsers/msedgedriver.exe");

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				EdgeDriverService service = disableEdgeLogs();

				yield new EdgeDriver(service, options);
			}
			default -> {
				System.setProperty("webdriver.chrome.driver",
						"src/main/resources/browsers/chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				ChromeDriverService service = disableChromeLogs();

				yield new ChromeDriver(service, options);
			}
		};

		webDriver.manage().window().maximize();
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
	}

	private void disableFirefoxLogs() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				"/dev/null");
	}

	private EdgeDriverService disableEdgeLogs() {
		EdgeDriverService edgeDriverService = EdgeDriverService
				.createDefaultService();
		edgeDriverService.sendOutputTo(NullOutputStream.nullOutputStream());

		return edgeDriverService;
	}

	private ChromeDriverService disableChromeLogs() {
		DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
		ChromeDriverService chromeDriverService = serviceBuilder.build();
		chromeDriverService.sendOutputTo(NullOutputStream.nullOutputStream());

		return chromeDriverService;
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}

	@Override
	public void quit() {
		if (webDriver != null)
			webDriver.quit();
	}

	@Override
	public String getUrl() {
		return webDriver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		return webDriver.getTitle();
	}

	@Override
	public File captureScreenshot() {
		File screenshotFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		return screenshotFile;
	}

	@Override
	public void openPage(String url) {
		webDriver.get(url);
	}

	@Override
	public Element find(FindStrategy findStrategy) {
		var nativeWebElement = wait.until(ExpectedConditions
				.presenceOfElementLocated(findStrategy.convertToBy()));
		Element element = new WebCoreElement(nativeWebElement,
				findStrategy.convertToBy());
		Element logElement = new LoggingElement(element);

		return logElement;
	}

	@Override
	public List<Element> findAll(FindStrategy findStrategy) {
		var nativeWebElements = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(findStrategy.convertToBy()));
		List<Element> elements = new ArrayList<>();

		for (var nativeWebElement : nativeWebElements) {
			Element element = new WebCoreElement(nativeWebElement,
					findStrategy.convertToBy());
			Element logElement = new LoggingElement(element);

			elements.add(logElement);
		}

		return elements;
	}

	@Override
	public Element findById(String id) {
		return find(new IdFindStrategy(id));
	}

	@Override
	public Element findByClassName(String className) {
		return find(new ClassNameFindStrategy(className));
	}

	@Override
	public Element findByTagName(String tagName) {
		return find(new TagNameFindStrategy(tagName));
	}

	@Override
	public Element findByCssSelector(String cssSelector) {
		return find(new CssSelectorFindStrategy(cssSelector));
	}

	@Override
	public Element findByXpath(String xpath) {
		return find(new XpathFindStrategy(xpath));
	}

	@Override
	public Element findByText(String text) {
		return find(new TextContainingFindStrategy(text));
	}

	@Override
	public Element findByIdContaining(String containing) {
		return find(new IdContainingFindStrategy(containing));
	}

	@Override
	public Element findByUrlContaining(String containing) {
		return find(new UrlContainingFindStrategy(containing));
	}

	@Override
	public List<Element> findAllById(String id) {
		return findAll(new IdFindStrategy(id));
	}

	@Override
	public List<Element> findAllByClassName(String className) {
		return findAll(new ClassNameFindStrategy(className));
	}

	@Override
	public List<Element> findAllByTagName(String tagName) {
		return findAll(new TagNameFindStrategy(tagName));
	}

	@Override
	public List<Element> findAllByCssSelector(String cssSelector) {
		return findAll(new CssSelectorFindStrategy(cssSelector));
	}

	@Override
	public List<Element> findAllByXpath(String xpath) {
		return findAll(new XpathFindStrategy(xpath));
	}

	@Override
	public List<Element> findAllByText(String text) {
		return findAll(new TextContainingFindStrategy(text));
	}

	@Override
	public List<Element> findAllByIdContaining(String containing) {
		return findAll(new IdContainingFindStrategy(containing));
	}

	@Override
	public List<Element> findAllByUrlContaining(String containing) {
		return findAll(new UrlContainingFindStrategy(containing));
	}

}
