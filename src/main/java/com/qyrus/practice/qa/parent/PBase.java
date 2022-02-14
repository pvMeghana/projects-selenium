package com.qyrus.practice.qa.parent;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qyrus.practice.qa.util.TimeUtil;
import com.qyrus.practice.qa.util.WebDriverListener;

public class PBase {

	public static WebDriver driver;
	public static Properties prop;
	static EventFiringWebDriver e_driver;
	static WebDriverListener eventListener;

	public PBase() throws Exception {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Selenium\\frameworkbuild\\src\\main\\java\\com\\qyrus\\practice\\qa\\config\\config.properties");
		prop.load(fis);

	}
	
	public static void initialization() throws Exception {	
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Docs\\chromedriver_win32 (3)\\chromeDriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\gecko.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebDriverListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.Implicitly_Wait, TimeUnit.SECONDS);	
		driver.get(prop.getProperty("url"));
	}

}
