package utilities.driverManagement;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.logging.log4j.core.util.NullOutputStream;
import org.openqa.selenium.By;
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
	public Element find(By locator) {
		var nativeWebElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		Element element = new WebCoreElement(nativeWebElement, locator);
		Element logElement = new LoggingElement(element);

		return logElement;
	}

	@Override
	public List<Element> findAll(By locator) {
		var nativeWebElements = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		List<Element> elements = new ArrayList<>();

		for (var nativeWebElement : nativeWebElements) {
			Element element = new WebCoreElement(nativeWebElement, locator);
			Element logElement = new LoggingElement(element);

			elements.add(logElement);
		}

		return elements;
	}

}
