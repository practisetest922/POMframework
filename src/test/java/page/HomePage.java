package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(xpath = "(//a[text()='Shop Now'])[1]")
	private WebElement shopNowbutton;
	
	//private By shopNowbutton= By.xpath("(//a[text()='Shop Now'])[1]");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickbuttonShopnow(){
		//driver.findElement(shopNowbutton).click();
		wait.until(ExpectedConditions.visibilityOf(shopNowbutton)).click();
	}
	
		
	public void waitforSecond() throws InterruptedException {
		Thread.sleep(2000);
	}

}
