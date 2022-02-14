package com.qyrus.practice.qa.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qyrus.practice.qa.pages.HomePage;
import com.qyrus.practice.qa.pages.LoginPage;
import com.qyrus.practice.qa.parent.PBase;



public class LoginPageTestCase extends PBase {
	
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTestCase() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();	
		loginpage = new LoginPage();
		System.out.println("This is before method");
	}
	
	@Test(priority=1)
	public void getTitle() {
		String title = loginpage.validatePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void getLogo() {
		boolean value = loginpage.validatePageLogo();
		Assert.assertTrue(value);
	}
	
	@Test(priority=3)
	public void setLoginData() throws Exception {
		homepage = loginpage.loginData(prop.getProperty("Username"), prop.getProperty("Password"));	
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();	
	}

}
