package com.automationpractice.qa.pages;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automationpractice.qa.base.TestBase;
import com.automationpractice.qa.util.TestUtil;

public class ShoppingCartPage extends TestBase{
	
	static Logger log = Logger.getLogger(ShoppingCartPage.class);
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	WebElement ProceedtoCheckoutBtn;
	
	public ShoppingCartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ProceedTocheckout() {
		
		try {
			log.info("Page Title: "+driver.getTitle());
			log.info("Taking Screenshot of Shopping Cart");
			new TestUtil().takeScreenshot();
			ProceedtoCheckoutBtn.click();
		} catch (IOException e) {
			
			log.error("Error in Adding Item to cart");
			e.printStackTrace();
		}
	}

}
