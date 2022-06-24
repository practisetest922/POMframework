package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "user-name")
	private WebElement usernameTextBox;
	
	@FindBy(id = "password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	

	public void loginTest(String userName, String password){
		usernameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	   Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
	}

}
