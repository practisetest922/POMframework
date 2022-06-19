package base;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import factory.DriverManager;
import io.qameta.allure.Allure;

public class BaseTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		return driver.get();
	}

	
	@Parameters("browser")
	@BeforeMethod
	public void startDriver(String browser) {
		setDriver(new DriverManager().initDriver(browser));
		System.out.println("Current thread: "+Thread.currentThread().getId()+", "+"driver "+getDriver());
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Allure.addAttachment(result.getName(),
					new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
		}
		System.out.println("Current thread: "+Thread.currentThread().getId()+", "+"driver "+getDriver());
		getDriver().quit();
	}

}
