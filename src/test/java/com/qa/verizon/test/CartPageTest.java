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

public class CartPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonePage smartphonePage;
	FeaturesPage featuresPage;
	CartPage cartPage;
	
	@BeforeTest
	
	public void setUp(){
		basePage = new BasePage();
		prop =basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
        smartphonePage =homePage.clickSmartPhone();
        featuresPage = smartphonePage.selectPhone();
        cartPage =featuresPage.selectFeatures(prop.getProperty("zipcode"));
        
	}
        @Test(priority =1)
        public void getCartPageTitleTest(){
    		String cartPageTitle =cartPage.getCartPageTitle();
    		System.out.println("Cart page title : " + cartPageTitle);
    		Assert.assertEquals(cartPageTitle, Constants.CART_PAGE_TITLE);
    	
    	}
        @Test(priority =2)
         public void verifyPhoneName(){
        	String phoneName=cartPage.phoneTypeVerify();
        	System.out.println("phone name : " + phoneName);
        
        	Assert.assertEquals(phoneName, Constants.PHONE_NAME);
        	
        }
         @AfterTest
         public void tearDown(){
        	 driver.quit();
         }
        
	

		
	}
	
	


