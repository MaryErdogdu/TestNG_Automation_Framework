package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CartPage;
import com.qa.verizon.page.FeaturesPage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartphonePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;



public class HomePageTest {
	
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop =basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		
		
	}
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomeTitle();
		System.out.println("Home Page Title : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	
	@Test(priority = 2)
	
	public void clickSmartPhoneTest(){
		homePage.clickSmartPhone();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		
	}

}
