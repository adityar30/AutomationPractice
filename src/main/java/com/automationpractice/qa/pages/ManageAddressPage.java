package com.automationpractice.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.util.TestUtil;

public class ManageAddressPage extends TestBase{

	@FindBy(name="processAddress")
	WebElement ProceedtoCheckoutBtn;
	
	public ManageAddressPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ProceedTocheckout() {
		try {
			
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		ProceedtoCheckoutBtn.click();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		}
	}
	

