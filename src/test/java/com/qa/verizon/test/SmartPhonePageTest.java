package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartphonePage;
import com.qa.verizon.util.Constants;

public class SmartPhonePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartPhonePage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop =basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		smartPhonePage = homePage.clickSmartPhone();
	

}
	@Test(priority = 1)
	
	public void getVerifySmartPhonePage(){
		String SmartPhoneTitle = smartPhonePage.getSmartphonePageTitle();
		System.out.println("smartphone title : " + SmartPhoneTitle);
		Assert.assertEquals(SmartPhoneTitle, Constants.SMARTPHONE_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void clickPhoneTest(){
		smartPhonePage.selectPhone();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	



}
