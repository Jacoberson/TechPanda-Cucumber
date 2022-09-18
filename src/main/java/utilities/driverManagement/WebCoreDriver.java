package utilities.driverManagement;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCoreDriver extends Driver {
	private static WebDriver webDriver;

	@Override
	public void start(String browser) {
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

		webDriver = switch (browser) {
			case "Firefox" -> {
				WebDriverManager.firefoxdriver().setup();

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				yield new FirefoxDriver(options);
			}
			case "Edge" -> {
				WebDriverManager.edgedriver().setup();

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				yield new EdgeDriver(options);
			}
			default -> {
				WebDriverManager.chromedriver().setup();

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				yield new ChromeDriver(options);
			}
		};

		webDriver.manage().window().maximize();
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
