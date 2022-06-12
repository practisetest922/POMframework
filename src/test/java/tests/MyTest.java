package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
import page.StorePage;

public class MyTest extends BaseTest {
	
	@Test
	public void firstTest()   {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.enterinSearch("blue jeans");
	}
	
	@Test
	public void secondTest() {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.enterinSearch("red");
	}
	
	
}
