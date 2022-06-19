package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import page.HomePage;
import page.StorePage;

public class NavigationTest extends BaseTest {
	
	@Test(description = "Login and verify blue jeans")
	@Description("Searches for blue jeans")
	public void firstTest()   {
		HomePage hm=new HomePage(getDriver());
		hm.openUrl();
		hm.clickbuttonShopnow();
		StorePage sp=new StorePage(getDriver());
		sp.search("blue jeans");
	}
	
	
	
}
