package base;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.DriverManager;
import io.qameta.allure.Allure;
import utils.WebConfig;

public class BaseTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//ExtentReports reports;

	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		return driver.get();
	}

//	@BeforeClass
//	public void setupClass() {
//		reports = new ExtentReports();
//		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
//		reports.attachReporter(htmlReporter);
//	}
//
//	@AfterClass
//	public void teardownClass() {
//		reports.flush();
//	}

	@Parameters("browser")
	@BeforeMethod
	public void startDriver(@Optional("chrome") String browser,Method method) {
	//	 reports.createTest(method.getName());
		setDriver(new DriverManager().initDriver(browser));
		String url=WebConfig.BASE_CONFIG.getWebUrl();
		getDriver().get(url);
		System.out.println("Current thread: " + Thread.currentThread().getId() + ", " + "driver " + getDriver());
	}

	@AfterMethod
	public void quitDriver(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
	//		 reports.createTest(result.getName()).fail("fail");
		    	Allure.addAttachment(result.getName(),
					new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
		}
		System.out.println("Current thread: " + Thread.currentThread().getId() + ", " + "driver " + getDriver());
		getDriver().quit();
	}

}
