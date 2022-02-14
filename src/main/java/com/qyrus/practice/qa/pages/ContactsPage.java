package com.qyrus.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qyrus.practice.qa.parent.PBase;

public class ContactsPage extends PBase {
	
	
	@FindBy(xpath="//*[text()=\"Address\"]")
	WebElement moveToAddress;
	
	@FindBy(id="dashboard-toolbar")
	WebElement clickOnDashboard;
	
	@FindBy(name="first_name")
	WebElement contactFirstName;
	
	@FindBy(name="last_name")
	WebElement contactLastName;
	
	@FindBy(xpath="//*[text()=\"Save\"]")
	WebElement contactSaveButton;
	
	public ContactsPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public void clickAddressText() throws Exception {
		Actions action = new Actions(driver);
		action.clickAndHold(moveToAddress).build().perform();
		Thread.sleep(2000);
	}
	
	public void clickDashboard() throws Exception {
		Actions action = new Actions(driver);
		action.clickAndHold(clickOnDashboard).build().perform();
		Thread.sleep(2000);
	}
	
	public void contactCreateDetails(String Fname, String Lname) {
		contactFirstName.sendKeys(Fname);
		contactLastName.sendKeys(Lname);
		contactSaveButton.click();
	}

}
