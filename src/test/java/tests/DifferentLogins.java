package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import page.HomePage;
import page.LoginPage;
import page.StorePage;
import utils.CSVUtils;

public class DifferentLogins extends BaseTest {


	@Test(dataProvider="csvdata",dataProviderClass = CSVUtils.class,description = "Different logins with data")
	@Description("Attempt to login")
	public void firstTest(String testcase,String username,String password) {
		
		HomePage hm=new HomePage(getDriver());
		hm.openUrlSauce();
		LoginPage lp=new LoginPage(getDriver());
		lp.loginTest(username, password);
	}
}
