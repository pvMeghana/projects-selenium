package com.qyrus.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qyrus.practice.qa.parent.PBase;
import com.qyrus.practice.qa.util.TimeUtil;


public class HomePage extends PBase {
	

	@FindBy(xpath = "//*[@class=\"users icon\"]")
	WebElement contactIcon;
	
	@FindBy(xpath="//*[text()=\"Contacts\"]")
	WebElement contactText;
	
	@FindBy(xpath="(//*[text()=\"Contacts\"]//following::i[1])[1]")
	WebElement addNewContact;

	@FindBy(xpath = "//*[text()=\"Date\"]")
	WebElement validateDate;

	@FindBy(xpath = "//*[text()=\"Contact\"]")
	WebElement validateContact;


	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	public static String validateDashboardPageTitle() {
		return driver.getTitle();
	}

	public ContactsPage hoverContactsIcon() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(contactIcon).build().perform();
		contactText.click();
		Thread.sleep(5000);
		return new ContactsPage();
	}
	
	public ContactsPage hoverAddContact() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(addNewContact).build().perform();
		addNewContact.click();
		Thread.sleep(5000);
		return new ContactsPage();
	}


	public boolean validateDaeButton() {
		return validateDate.isDisplayed();
	}

	public boolean validateContactButton() {
		return validateContact.isDisplayed();
	}

}
