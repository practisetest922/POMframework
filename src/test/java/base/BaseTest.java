package base;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverManager;
import io.qameta.allure.Allure;

public class BaseTest {
	protected  WebDriver driver;
	
	@BeforeMethod
	public void startDriver() {
		driver=new DriverManager().initDriver();
	}
	
	@AfterMethod
	public void quitDriver(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Allure.addAttachment(result.getName(),new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
		driver.quit();
	}

}
