package utilities.driverManagement;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.output.NullOutputStream;
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

public class WebCoreDriver extends Driver {
	private static WebDriver webDriver;
	private static WebCoreDriver instance = new WebCoreDriver();

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
	}

	private void disableFirefoxLogs() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				"/dev/null");
	}

	private EdgeDriverService disableEdgeLogs() {
		EdgeDriverService edgeDriverService = EdgeDriverService
				.createDefaultService();
		edgeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

		return edgeDriverService;
	}

	private ChromeDriverService disableChromeLogs() {
		DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
		ChromeDriverService chromeDriverService = serviceBuilder.build();
		chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

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

}
