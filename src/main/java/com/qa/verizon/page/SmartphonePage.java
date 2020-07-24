package com.qa.verizon.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.test.FeaturesPageTest;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;

public class SmartphonePage extends BasePage {
	
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	 By Iphone11 = By.xpath("//a[@aria-label='Apple iPhone 11']");
	
	   
	   public SmartphonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	   public String getSmartphonePageTitle(){
		   elementUtil.waitForTitlePresent(Constants.SMARTPHONE_PAGE_TITLE);
		   return elementUtil.doGetPageTitle();
		   
	   }
	   public FeaturesPage selectPhone(){
		   elementUtil.waitForElementPresent(Iphone11);
		   elementUtil.doClick(Iphone11);
		   
		   return new FeaturesPage(driver);
		   
	   }

}
