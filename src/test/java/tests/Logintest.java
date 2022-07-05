package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import page.HomePage;
import page.StorePage;



public class Logintest extends BaseTest {
	
	@Test(description = "Login and verify blue jeans")
	@Description("Searches for blue jeans")
	public void firstTest()   {
		HomePage hm=new HomePage(getDriver());
//		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(getDriver());
		sp.search("blue jeans");
	}
	
	@Test(description = "Login and verify red ")
	@Description("Searches for red ")
	public void secondTest() {
		HomePage hm=new HomePage(getDriver());
//		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(getDriver());
		sp.search("red");
		assertEquals("Red Shoes",sp.verifyRed());
		
	}
	
	@Test(description = "Login and verify yellow ")
	@Description("Searches for yellow ")
	public void ThirdTest() {
		HomePage hm=new HomePage(getDriver());
//		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(getDriver());
		sp.search("yellow");
		assertEquals("yellow Shoes",sp.verifyRed());
		
	}
	

	
}
