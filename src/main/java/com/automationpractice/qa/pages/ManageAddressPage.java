package com.automationpractice.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.qa.base.TestBase;

public class ManageAddressPage extends TestBase{
	
	static Logger log = Logger.getLogger(ManageAddressPage.class);

	@FindBy(name="processAddress")
	WebElement ProceedtoCheckoutBtn;
	
	public ManageAddressPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ProceedTocheckout() {
		try {
			
		log.info("Page Title: "+driver.getTitle());
		log.info("Clicking on Proceed to Checkout");
		ProceedtoCheckoutBtn.click();
		}
		catch(Exception e) {
			log.error("Unable to checkout");
			
			e.printStackTrace();
		}
		}
	}
	

