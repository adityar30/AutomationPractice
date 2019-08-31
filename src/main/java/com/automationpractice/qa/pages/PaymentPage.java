package com.automationpractice.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class PaymentPage extends TestBase{
	
	static Logger log = Logger.getLogger(PaymentPage.class);

	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement PayByBankWireOption;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	WebElement PayByCheckOption;
	
	public PaymentPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void PaymentMethod() {
		
		try {
		log.info("Page Title: "+driver.getTitle());
		log.info("Clicking on Pay by Bank Wire option");
		PayByBankWireOption.click();
		}catch(Exception e) {
			log.error("Unable to proceed with payment");
			e.printStackTrace();
		}
	}
	

}
