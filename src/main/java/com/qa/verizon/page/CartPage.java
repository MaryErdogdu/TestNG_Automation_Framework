package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class CartPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	
	By iphone = By.xpath("//span[contains(text(),'iPhone 11')]");

	public CartPage(WebDriver driver) {
		this.driver=driver;
		elementUtil =new ElementUtil(driver);
	}
	public String getCartPageTitle(){
	return	elementUtil.doGetPageTitle();
		
	}
	
	public String phoneTypeVerify(){
	elementUtil.waitForElementPresent(iphone);
	return elementUtil.doGetText(iphone);
	}

}
