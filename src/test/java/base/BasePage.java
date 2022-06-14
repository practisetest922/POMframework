package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Step("opening url....")
	public void openUrl() {
		driver.get("https://askomdch.com/");
	}
	
	
}
