package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import io.qameta.allure.Step;

public class StorePage extends BasePage {
	
	private By searchTextBox= By.id("woocommerce-product-search-field-0");
	private By searchButton= By.xpath("//button[text()='Search']");
	private By headerRed=By.xpath("//h1");
	
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Typed in search and hit search button")
	public void search(String text) {
//		driver.findElement(searchTextBox).clear();
//		driver.findElement(searchTextBox).sendKeys(text);
//		driver.findElement(searchButton).click();
		WebElement searchTextbox=wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
		searchTextbox.clear();
		searchTextbox.sendKeys(text);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
	}

	public String verifyRed() {
		return driver.findElement(headerRed).getText();
		
	}

}
