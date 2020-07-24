package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.FeaturesPage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartphonePage;
import com.qa.verizon.util.Constants;

public class FeaturesPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	SmartphonePage smartphonePage;
	FeaturesPage featuresPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop =basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	    featuresPage = homePage.clickSmartPhone().selectPhone();
		
	}
		
	@Test(priority=1)
	public void getFeaturePageTitle(){
		String featurePageTitle =prop.getProperty(Constants.FEATUREPAGE_PAGE_TITLE);
		System.out.println("Feature page title : " + featurePageTitle);
		Assert.assertEquals(featurePageTitle, Constants.FEATUREPAGE_PAGE_TITLE);
	
	}
	
	@Test(priority = 2)
	public void selectFeaturesTest(){
		featuresPage.selectFeatures(prop.getProperty("zipcode"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
