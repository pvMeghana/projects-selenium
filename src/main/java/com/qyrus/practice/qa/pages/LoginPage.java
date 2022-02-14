package com.qyrus.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qyrus.practice.qa.parent.PBase;

public class LoginPage extends PBase {
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	WebElement loginButton;
	
	@FindBy(xpath="(//div[@class=\"ui message\"])[2]")
	WebElement logoVerify;
	
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public static String validatePageTitle() {	
		return driver.getTitle();	
	}
	
	public boolean validatePageLogo() {		
		return logoVerify.isDisplayed();
	}
	
	public HomePage loginData(String uName, String pName) throws Exception {
		userName.sendKeys(uName);
		passWord.sendKeys(pName);
		loginButton.click();	
		return new HomePage();
	}

}
