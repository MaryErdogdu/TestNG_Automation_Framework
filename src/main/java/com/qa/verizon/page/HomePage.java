package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
    ElementUtil elementUtil;
    
  
   
   By phone = By.xpath("//button[contains(text(),'Phones list')]");
   
   By smartphone = By.id("thirdLevel00");
   

   public HomePage(WebDriver driver) {
	this.driver=driver;
	elementUtil = new ElementUtil(driver);

   }
   public String getHomeTitle(){
	   elementUtil.waitForTitlePresent(Constants.HOME_PAGE_TITLE);
	   return elementUtil.doGetPageTitle();
	   
   }

   public SmartphonePage clickSmartPhone(){
	  //elementUtil.waitForElementPresent(phone);
	   elementUtil.moveToElement(phone);
	  //elementUtil.waitForElementPresent(smartphone);
	   elementUtil.doClick(smartphone);
	   
	   return new SmartphonePage(driver);
	   
	   
   }
}
