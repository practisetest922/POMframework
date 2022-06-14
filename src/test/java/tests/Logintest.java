package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import page.HomePage;
import page.StorePage;

public class Logintest extends BaseTest {
	
	@Test(description = "Login and verify blue jeans")
	@Description("Searches for blue jeans")
	public void firstTest()   {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.search("blue jeans");
	}
	
	@Test(description = "Login and verify red ")
	@Description("Searches for red ")
	public void secondTest() {
		HomePage hm=new HomePage(driver);
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(driver);
		sp.search("red");
		assertEquals("Red",sp.verifyRed());
		
	}
	
	
}
