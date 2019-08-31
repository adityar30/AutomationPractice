package com.automationpractice.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class OrderSummaryPage extends TestBase{
	
	static Logger log = Logger.getLogger(OrderSummaryPage.class);

	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement ConfirmOrderBtn;
	
	public OrderSummaryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ConfirmingOrder() {
		try {
		log.info("Page Title: "+driver.getTitle());
		log.info("Confirming Order");
		ConfirmOrderBtn.click();
		}catch(Exception e) {
			
			log.error("Unable to Confirm Order");
			e.printStackTrace();
		}
	}
	
	

}
