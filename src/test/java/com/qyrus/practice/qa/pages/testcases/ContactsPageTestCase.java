package com.qyrus.practice.qa.pages.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;
import com.qyrus.practice.qa.pages.ContactsPage;
import com.qyrus.practice.qa.pages.HomePage;
import com.qyrus.practice.qa.pages.LoginPage;
import com.qyrus.practice.qa.parent.PBase;
import com.qyrus.practice.qa.util.TimeUtil;

public class ContactsPageTestCase extends PBase{
	
	TimeUtil timeUtil;
	LoginPage loginpage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetName = "TestData";


	public ContactsPageTestCase() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		timeUtil = new TimeUtil ();
		loginpage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginpage.loginData(prop.getProperty("Username"), prop.getProperty("Password"));
		contactsPage = homePage.hoverContactsIcon();
		contactsPage = homePage.hoverAddContact();
	}
	
	@Test(priority = 1, enabled=false)
	public void clickAddress() throws Exception {
		contactsPage.clickAddressText();
		
	}
	
	@Test(priority = 2)
	public void clickDashboard() throws Exception {
		contactsPage.clickDashboard();
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception{
		Object data[][] = timeUtil.getDataFromExcel(sheetName);
		return data;
		
	}
	
	@Test(priority = 3, dataProvider="getTestData")
	public void createNewContact(String Fname, String Lname) throws Exception {
		contactsPage.contactCreateDetails(Fname, Lname);
		Thread.sleep(2000);
		timeUtil.screenShot("C:\\Users\\MeghanaK\\Desktop\\Automation_Screenshots\\contact1.png");
		
	}
	
	/*@Test(priority = 3)
	public void createNewContact() throws Exception {
		contactsPage.contactCreateDetails("Meghana", "Kulkarni");
		Thread.sleep(2000);
		timeUtil.screenShot("C:\\Users\\MeghanaK\\Desktop\\Automation_Screenshots\\contact1.png");
		
	}*/
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}
