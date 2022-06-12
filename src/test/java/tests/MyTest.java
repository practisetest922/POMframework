package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
import page.StorePage;

public class MyTest extends BaseTest {
	
	@Test
	public void firstTest() throws InterruptedException {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.enterinSearch("blue jeans");
		hm.waitforSecond();
	}
	
	@Test
	public void secondTest() throws InterruptedException {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.enterinSearch("red");
		hm.waitforSecond();
	}
	
	
}
