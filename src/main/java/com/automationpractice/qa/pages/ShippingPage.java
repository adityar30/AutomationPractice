package com.automationpractice.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class ShippingPage extends TestBase{
	
	static Logger log = Logger.getLogger(ShippingPage.class);

	@FindBy(name="cgv")
	WebElement TermsOfServiceCheckbox;
	
	@FindBy(name="processCarrier")
	WebElement ProceedtoCheckoutBtn;
	
	public ShippingPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void AgreeTerms() {
		try {
		log.info("Page Title: "+driver.getTitle());
		log.info("Accepting Terms and Services");
		TermsOfServiceCheckbox.click();
		}catch(Exception e) {
			
			log.error("Not able to accept Terms and Services");
			e.printStackTrace();
		}
	}
	
	public void ProceedTocheckout() {
		try {
			log.info("Clicking on Proceed to Checkout");
		ProceedtoCheckoutBtn.click();
		}
		catch(Exception e)
		{
			log.error("Unable to Proceed");
			e.printStackTrace();
		}
	}
	
}
