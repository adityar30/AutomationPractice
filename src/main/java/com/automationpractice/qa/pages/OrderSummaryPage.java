package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.base.TestBase;

public class OrderSummaryPage extends TestBase{

	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement ConfirmOrderBtn;
	
	public OrderSummaryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ConfirmingOrder() {
		try {
		String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		ConfirmOrderBtn.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
