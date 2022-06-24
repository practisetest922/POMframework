package factory;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	WebDriver driver;

	public WebDriver initDriver(String browser) {
		if (browser == null) {
			browser = System.getProperty("browser", "chrome");// it will take property through maven
		}
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new IllegalStateException("Invalid browser name - " + browser);
		}

		return driver;
	}

}
