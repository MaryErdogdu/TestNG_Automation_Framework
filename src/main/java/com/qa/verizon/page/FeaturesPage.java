package com.qa.verizon.page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.Constants;
import com.qa.verizon.util.ElementUtil;


public class FeaturesPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By color = By.xpath("//div[@style='background-color: rgb(207, 190, 169);']");
	
	By size = By.xpath("//div[@class='sizePad']");
	
	By paymentOptions =By.xpath("//div[@class='cursorPointer height100p positionRelative border_grayThree ']");

	By clickContinue = By.id("ATC-Btn");	
	
	By zipcode = By.id("zipcode");
	
	By confirmLocation = By.xpath("//button[@type='submit']");
	
	By newCustomer = By.xpath("//button[@aria-label='New Customer']");
	
	public FeaturesPage(WebDriver driver) {
		this.driver =driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getFeaturePageTitle(){
     return elementUtil.waitForGetPageTitle(Constants.FEATUREPAGE_PAGE_TITLE);
		
	}
	
	public CartPage selectFeatures(String zip){
	
		elementUtil.doClick(color);
		elementUtil.doClick(size);
		elementUtil.doClick(paymentOptions);
		elementUtil.doClick(clickContinue);
		elementUtil.doSendKeys(zipcode, zip);
		elementUtil.doClick(confirmLocation);
		elementUtil.doClick(newCustomer);
		
		return new CartPage(driver);
	}
	
	
	}
	
	
