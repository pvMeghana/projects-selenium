package com.qyrus.practice.qa.pages.testcases;

import org.testng.Assert;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.qyrus.practice.qa.pages.ContactsPage;
import com.qyrus.practice.qa.pages.HomePage;
import com.qyrus.practice.qa.pages.LoginPage;
import com.qyrus.practice.qa.parent.PBase;
import com.qyrus.practice.qa.util.TimeUtil;

public class HomePageTestCase extends PBase {

	TimeUtil timeUtil;
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTestCase() throws Exception {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		timeUtil = new TimeUtil ();
		loginpage = new LoginPage();
		homePage = new HomePage();
		homePage = loginpage.loginData(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(priority = 1)
	public void getTitle() {
		SoftAssert sf = new SoftAssert();
		String title = homePage.validateDashboardPageTitle();
		sf.assertEquals(title, "Twitter Widget Iframe", "The given title is not valid");
	}

	@Test(priority = 2)
	public void hoverContacts() throws Exception {
		contactsPage = homePage.hoverContactsIcon();
		timeUtil.screenShot("C:\\Users\\MeghanaK\\Desktop\\Automation_Screenshots\\hoverContacts1.png");
		
	}
	
	@Test(priority = 3)
	public void hoverNewContacts() throws Exception {
		contactsPage = homePage.hoverAddContact();
		timeUtil.screenShot("C:\\Users\\MeghanaK\\Desktop\\Automation_Screenshots\\hoverContacts2.png");
		
	}

	@Test(priority = 4, enabled=false)
	public void getDateButton() {
		boolean value = homePage.validateDaeButton();
		Assert.assertTrue(value);
	}

	@Test(priority = 5, enabled=false)
	public void getContactButton() {
		boolean value = homePage.validateContactButton();
		Assert.assertTrue(value);
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}
