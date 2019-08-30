package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class PaymentPage extends TestBase{

	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement PayByBankWireOption;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
	WebElement PayByCheckOption;
	
	public PaymentPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void PaymentMethod() {
		
		try {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		PayByBankWireOption.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
