package com.automationpractice.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automationpractice.qa.base.TestBase;

public class SearchResultPage extends TestBase{
	
	static Logger log = Logger.getLogger(SearchResultPage.class);
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement PopupProceedtoCheckoutBtn;
	
	public SearchResultPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void AddingItem() {
	
		try {
		log.info("Page Title: "+driver.getTitle());
		log.info("Getting the Parent windowhandle ID");
		String parentWindow=driver.getWindowHandle();
		log.info("Parent Windowhandle ID: "+parentWindow);
		String childWindow=null;
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		log.info("Adding item to Cart");
		AddToCartBtn.click();
		log.info("Getting available Window Handles");
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> itr= handle.iterator();
		while(itr.hasNext()) {
			log.debug("Switching to Child window");
			childWindow= itr.next();
			log.debug("Child Windowhandle ID: "+childWindow);
			}
		log.debug("Switching to Childwindow");
		driver.switchTo().window(childWindow);
		log.info("Clicking on Checkout button");
		PopupProceedtoCheckoutBtn.click();
		}catch(Exception e) {
			
			log.error("Error in Adding Item");
			e.printStackTrace();
		}
	}
	
	
	
	

}
