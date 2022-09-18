package utilities.driverManagement.driverServices;

public interface BrowserService {
	public abstract void start(String browser);
	public abstract void quit();
	public abstract String getUrl();
	public abstract String getTitle();
}
