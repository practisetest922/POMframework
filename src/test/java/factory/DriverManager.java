package factory;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	WebDriver driver;
	
	public WebDriver initDriver() {
		driver=WebDriverManager.chromedriver().create();
		return driver;
	}

}
