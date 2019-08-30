package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class ShippingPage extends TestBase{

	@FindBy(name="cgv")
	WebElement TermsOfServiceCheckbox;
	
	@FindBy(name="processCarrier")
	WebElement ProceedtoCheckoutBtn;
	
	public ShippingPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void AgreeTerms() {
		try {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		TermsOfServiceCheckbox.click();
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ProceedTocheckout() {
		try {
		ProceedtoCheckoutBtn.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
